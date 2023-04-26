package app.router;

import configs.AppCfg;
import org.jetbrains.annotations.NotNull;
import ui.ViewPanel;
import util.AppUtils;
import util.ClassUtils;

import java.awt.*;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Manages the views of the application.
 * Scans for views and registers them to the router.
 * Handles view redirection.
 * @see View
 * @see RouterRedirect
 * @see ViewPanel
 * @see ViewPanel#redirect(String, Object...)
 */
public class Router {

    // containers
    private Container owner;
    private Container container;

    // views types and annotations
    private final Map<String, Class<? extends ViewPanel>> viewTypes = new HashMap<>();
    private final Map<String, View> viewAnnotations = new HashMap<>();

    // tracking views
    private ViewPanel currentView;
    private Class<? extends ViewPanel> defaultViewType;
    private ViewPanel defaultView;
    public String defaultViewName;
    private final Map<String, ViewPanel> cache = new HashMap<>();

    public Router(Container owner) {
        this.owner = owner;
        initRouter();
    }

    protected void initRouter() {
        try {
            registerViewTypes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Container getOwner() {
        return owner;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public Container getCurrentView() {
        return currentView;
    }

    public void setCurrentView(ViewPanel view) {
        this.currentView = view;
    }

    public Set<Class<? extends ViewPanel>> scanViewTypes() {
        return ClassUtils.getSubTypes(AppCfg.RouterViewPackage, ViewPanel.class, View.class);
    }

    protected void registerViewTypes() throws RouterConfigException {
        Set<Class<? extends ViewPanel>> types = scanViewTypes();
        for (Class<? extends ViewPanel> type : types) {
            registerViewType(type);
        }
        // if default view not found, throw an exception
        if (defaultViewType == null) {
            throw new RouterConfigException("Default view not found");
        }
    }

    public void registerViewType(@NotNull Class<? extends ViewPanel> type) throws RouterConfigException {
        View viewAnnotation = type.getAnnotation(View.class);
        viewTypes.put(viewAnnotation.name(), type);
        viewAnnotations.put(viewAnnotation.name(), viewAnnotation);
        if (viewAnnotation.isDefault()) {
            if (defaultViewType != null) {
                throw new RouterConfigException("Multiple default views found");
            }
            defaultViewType = type;
            defaultViewName = viewAnnotation.name();
        }
    }

    private ViewPanel createView(String name, Object... args) {
        return createView(getViewType(name), getViewAnnotation(name), args);
    }

    private ViewPanel createView(
            @NotNull Class<? extends ViewPanel> type,
            @NotNull View viewAnnotation,
            Object... args
    ) {
        try {
            ViewPanel view = ClassUtils.newInstance(type, args);
            view.setRouter(this);
            view.setName(viewAnnotation.name());
            view.setCacheable(viewAnnotation.cacheable());
            view.setDefault(viewAnnotation.isDefault());
            return view;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Class<? extends ViewPanel> getViewType(String name) {
        return viewTypes.get(name);
    }

    public ViewPanel getViewFromCache(String name) {
        return cache.get(name);
    }

    public boolean hasViewType(String name) {
        return viewTypes.containsKey(name);
    }

    public boolean isViewCached(String name) {
        return cache.containsKey(name);
    }

    public View getViewAnnotation(String name) {
        return viewAnnotations.get(name);
    }

    public boolean isViewCacheable(String name) {
        return getViewAnnotation(name).cacheable();
    }

    public void redirect(String name, Object... args) throws IllegalRouteException {
        if (args.length == 0 && isViewCached(name)) {
            mountFromCache(name);
            return;
        }
        if (!hasViewType(name)) {
            throw new IllegalRouteException("View not found");
        }
        mountNewView(name, args);
    }

    public ViewPanel mountFromCache(String name) {
        ViewPanel view = getViewFromCache(name);
        replaceContainer(view);
        view.onMount();
        return view;
    }

    public ViewPanel mountNewView(String name, Object... args) {
        ViewPanel view = createView(name, args);
        if (isViewCacheable(name)) {
            cache.put(name, view);
        }
        replaceContainer(view);
        view.initialize();
        view.onMount();
        return view;
    }

    public void mountNewDefaultView() {
        defaultView = mountNewView(defaultViewName);
    }

    private void replaceContainer(ViewPanel nextView) {
        container.removeAll();
        container.add(nextView);
        setCurrentView(nextView);
        container.revalidate();
        container.repaint();
    }

}

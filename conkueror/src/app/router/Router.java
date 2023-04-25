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

public class Router {

    // containers
    private Container owner;
    private Container defaultContainer;
    private Container currentContainer;

    // views and properties
    private final Map<String, Class<? extends ViewPanel>> views = new HashMap<>();
    private final Map<String, View> viewAnnotations = new HashMap<>();

    // default view
    private Class<? extends ViewPanel> defaultViewClass;
    private ViewPanel defaultView;
    public String defaultViewName;

    // view cache
    private final Map<String, ViewPanel> cache = new HashMap<>();

    public Router(Container owner) {
        this.owner = owner;
        initRouter();
    }

    protected void initRouter() {
        try {
            scanViews();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Container getOwner() {
        return owner;
    }

    public void setOwner(Container owner) {
        this.owner = owner;
    }

    public Container getDefaultContainer() {
        return defaultContainer;
    }

    public void setDefaultContainer(Container defaultContainer) {
        this.defaultContainer = defaultContainer;
    }

    public Container getCurrentContainer() {
        return currentContainer;
    }

    public void setCurrentContainer(Container currentContainer) {
        this.currentContainer = currentContainer;
    }

    public Set<Class<? extends ViewPanel>> getViews() {
        return ClassUtils.getSubTypes(AppCfg.RouterViewPackage, ViewPanel.class, View.class);
    }

    protected void scanViews() throws RouterConfigException {
        Set<Class<? extends ViewPanel>> types = getViews();
        for (Class<? extends ViewPanel> type : types) {
            System.out.println("type " + type.toString());
            registerView(type);
        }
        // if default view not found, throw an exception
        if (defaultViewClass == null) {
            throw new RouterConfigException("Default view not found");
        }
    }

    public void registerView(@NotNull Class<? extends ViewPanel> viewType) throws RouterConfigException {
        View viewAnnotation = viewType.getAnnotation(View.class);
        if (viewAnnotation == null) {
            throw new RouterConfigException("View annotation not found");
        }
        views.put(viewAnnotation.name(), viewType);
        viewAnnotations.put(viewAnnotation.name(), viewAnnotation);
        if (viewAnnotation.isDefault()) {
            if (defaultViewClass != null) {
                throw new RouterConfigException("Multiple default views found");
            }
            defaultViewClass = viewType;
            defaultView = createView(viewAnnotation.name());
            defaultViewName = viewAnnotation.name();
        }
    }

    private void configureDefaultView(@NotNull Class<? extends ViewPanel> viewType) {

    }

    private void configureViewPanel(ViewPanel viewPanel, View viewAnnotation) {
        viewPanel.setRouter(this);
        viewPanel.setName(viewAnnotation.name());
        viewPanel.setCacheable(viewAnnotation.cacheable());
        viewPanel.setDefault(viewAnnotation.isDefault());
    }

    private ViewPanel createView(String name, Object... args) {
        return createView(getView(name), getViewAnnotation(name), args);
    }

    private ViewPanel createView(
            @NotNull Class<? extends ViewPanel> viewType,
            @NotNull View viewAnnotation,
            Object... args
    ) {
        ViewPanel view = ClassUtils.newInstance(viewType, args);
        configureViewPanel(view, viewAnnotation);
        return view;
    }

    public Class<? extends ViewPanel> getView(String name) {
        return views.get(name);
    }

    public boolean hasView(String name) {
        return views.containsKey(name);
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

    public boolean isViewDefault(String name) {
        return getViewAnnotation(name).isDefault();
    }

    public void redirect(String name, Object... args) {
        if (args.length == 0 && isViewCached(name)) {
            navigate(cache.get(name));
            return;
        }
        if (hasView(name)) {
            ViewPanel view = createView(name, args);
            if (isViewCacheable(name)) {
                cache.put(name, view);
            }
            navigate(view);
        }
    }

    public void redirect(@NotNull Class<? extends ViewPanel> view) {
        redirect(view.getName());
    }

    public void navigate(Container nextContainer) {
        defaultContainer.removeAll();
        defaultContainer.add(nextContainer);
        setCurrentContainer(nextContainer);
        defaultContainer.revalidate();
        defaultContainer.repaint();
    }

    public void navigate() {
        navigate(defaultView);
    }

}

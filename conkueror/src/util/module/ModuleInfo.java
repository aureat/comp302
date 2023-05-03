package util.module;

import util.ClassUtils;

public class ModuleInfo {

    public static final String developer = ClassUtils.getModuleAnnotation(Developer.class).value();
    public static final String version = ClassUtils.getModuleAnnotation(Version.class).value();

    public static final String RouterViewsPackage = "ui.app.views";
    public static final String RouterControllersPackage = "ui.app.controllers";
    public static final String MapsPackage = "domain.maps";
    public static final String ConfigsPackage = "domain.configs";

}

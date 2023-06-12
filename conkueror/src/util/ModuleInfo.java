package util;

import util.annotations.Developer;
import util.annotations.Version;

public class ModuleInfo {

    public static final String developer = ClassUtils.getModuleAnnotation(Developer.class).value();
    public static final String versionId = ClassUtils.getModuleAnnotation(Version.class).id();
    public static final String versionName = ClassUtils.getModuleAnnotation(Version.class).name();
    public static final String versionDate = ClassUtils.getModuleAnnotation(Version.class).date();

    public static final String RouterViewsPackage = "ui.app.views";
    public static final String RouterControllersPackage = "ui.app.controllers";
    public static final String MapsPackage = "domain.maps";
    public static final String ConfigsPackage = "domain.configs";

}

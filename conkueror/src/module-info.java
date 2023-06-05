import util.module.Developer;
import util.module.Version;

/**
 * This module contains the core classes and
 * the application classes for the game ConKUeror.
 */
@Version("0.5.6")
@Developer("Nerd^5")
module conkueror {
    requires java.desktop;
    requires java.base;
    requires java.compiler;
    requires java.xml;
    requires org.jetbrains.annotations;
    requires jdk.jfr;
    requires org.reflections;
    requires org.junit.jupiter.api;
}
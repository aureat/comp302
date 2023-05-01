package util;

import java.util.Locale;
import java.util.StringTokenizer;

public class SystemInfo {

    public static final String osName;
    public static final boolean isWindows;
    public static final boolean isMacOS;
    public static final boolean isLinux;

    public static final long osVersion;
    public static final long javaVersion;

    public static boolean isMacFullWindowContentSupported;

    static {
        // determine OS
        osName = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
        isWindows = osName.contains("windows");
        isMacOS = osName.contains("mac");
        isLinux = osName.contains("linux");

        // determine OS and Java version
        osVersion = scanVersion(System.getProperty("os.version"));
        javaVersion = scanVersion(System.getProperty("java.version"));

        // Java 12 required for full window content on macOS
        isMacFullWindowContentSupported = isMacOS &&
                (javaVersion >= toVersion( 11, 0, 8, 0 ) ||
                        (javaVersion >= toVersion( 1, 8, 0, 292 ) &&
                                (javaVersion < toVersion( 9, 0, 0, 0 ))));
    }

    public static boolean isMacOSNewerThan( int major, int minor, int micro, int patch ) {
        return isMacOS && osVersion >= toVersion(major, minor, micro, patch);
    }

    public static boolean isMacOSNewerThan(String version) {
        return isMacOS && System.getProperty("os.version").compareTo(version) >= 0;
    }

    public static long scanVersion( String version ) {
        int major = 1, minor = 0, micro = 0, patch = 0;
        try {
            StringTokenizer st = new StringTokenizer(version, "._-+");
            major = Integer.parseInt(st.nextToken());
            minor = Integer.parseInt(st.nextToken());
            micro = Integer.parseInt(st.nextToken());
            patch = Integer.parseInt(st.nextToken());
        } catch (Exception ex) {
            // @ignore
        }
        return toVersion(major, minor, micro, patch);
    }

    public static long toVersion( int major, int minor, int micro, int patch ) {
        return ((long) major << 48) + ((long) minor << 32) + ((long) micro << 16) + patch;
    }

}

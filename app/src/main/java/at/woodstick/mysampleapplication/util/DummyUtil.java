package at.woodstick.mysampleapplication.util;

/**
 *
 */

public final class DummyUtil {

    private DummyUtil() {
    }

    public static <T> T echo(T value) {
        return value;
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int sbutract(int a, int b) {
        return a - b;
    }

    public static String emptyIfNull(String value) {
        return value == null ? "" : value;
    }

    public static boolean isNullOrEmpty(String value) {
        if(value == null || value.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }
}


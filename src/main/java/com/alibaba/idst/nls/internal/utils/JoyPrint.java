package com.alibaba.idst.nls.internal.utils;

public class JoyPrint {
    private static boolean sIsPrintOpen = true;
    private static JoyPrintLevel sPrintLevel = JoyPrintLevel.VERBOSE;

    public enum JoyPrintLevel {
        VERBOSE,
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    public static void v(String str, String str2) {
        if (sIsPrintOpen) {
            sPrintLevel.ordinal();
            JoyPrintLevel.VERBOSE.ordinal();
        }
    }

    public static void d(String str, String str2) {
        if (sIsPrintOpen) {
            sPrintLevel.ordinal();
            JoyPrintLevel.DEBUG.ordinal();
        }
    }

    public static void i(String str, String str2) {
        if (sIsPrintOpen) {
            sPrintLevel.ordinal();
            JoyPrintLevel.INFO.ordinal();
        }
    }

    public static void w(String str, String str2) {
        if (sIsPrintOpen) {
            sPrintLevel.ordinal();
            JoyPrintLevel.WARNING.ordinal();
        }
    }

    public static void e(String str, String str2) {
        if (sIsPrintOpen) {
            sPrintLevel.ordinal();
            JoyPrintLevel.ERROR.ordinal();
        }
    }

    public static void openPrint() {
        sIsPrintOpen = true;
    }

    public static void closePrint() {
        sIsPrintOpen = false;
    }

    public static JoyPrintLevel getPrintLevel() {
        return sPrintLevel;
    }

    public static void setPrintLevel(JoyPrintLevel joyPrintLevel) {
        sPrintLevel = joyPrintLevel;
    }
}

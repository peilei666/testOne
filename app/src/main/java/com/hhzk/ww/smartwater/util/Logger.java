package com.hhzk.ww.smartwater.util;

import android.util.Log;

public class Logger {

    private static String mTag = "LoggerTag";
    private static boolean mIsDebug;

    public static void init(String tag, boolean isDebug) {
        if (tag != null) {
            mTag = tag;
        }
        mIsDebug = isDebug;
    }

    public static void v(int msg) {
        v(mTag, msg + "");
    }

    public static void d(int msg) {
        d(mTag, msg + "");
    }

    public static void i(int msg) {
        i(mTag, msg + "");
    }

    public static void w(int msg) {
        w(mTag, msg + "");
    }

    public static void e(int msg) {
        e(mTag, msg + "");
    }

    public static void v(String tag, int msg) {
        v(tag, msg + "");
    }

    public static void d(String tag, int msg) {
        d(tag, msg + "");
    }

    public static void i(String tag, int msg) {
        i(tag, msg + "");
    }

    public static void w(String tag, int msg) {
        w(tag, msg + "");
    }

    public static void e(String tag, int msg) {
        e(tag, msg + "");
    }

    public static void v(String msg) {
        print(Log.VERBOSE, mTag, msg);
    }

    public static void d(String msg) {
        print(Log.DEBUG, mTag, msg);
    }

    public static void i(String msg) {
        print(Log.INFO, mTag, msg);
    }

    public static void w(String msg) {
        print(Log.WARN, mTag, msg);
    }

    public static void e(String msg) {
        print(Log.ERROR, mTag, msg);
    }

    public static void v(String tag, String msg) {
        print(Log.VERBOSE, tag, msg);
    }

    public static void d(String tag, String msg) {
        print(Log.DEBUG, tag, msg);
    }

    public static void i(String tag, String msg) {
        print(Log.INFO, tag, msg);
    }

    public static void w(String tag, String msg) {
        print(Log.WARN, tag, msg);
    }

    public static void e(String tag, String msg) {
        print(Log.ERROR, tag, msg);
    }

    private static void print(int priority, String tag, String msg) {
        final String header = "╔════════════════════════════════════════════════════════════════════════════════════════";
        final String bottom = "╚════════════════════════════════════════════════════════════════════════════════════════";
        final String divide = "╟────────────────────────────────────────────────────────────────────────────────────────";

        println(priority, tag, header);
        println(priority, tag, "║ Thread: " + Thread.currentThread().getName());
        println(priority, tag, divide);
        //打印方法
        StackTraceElement[] traces = Thread.currentThread().getStackTrace();
//        int stackOffset = getStackOffset(traces);
        String level = "";
        for (int i = 5; i >= 4; i--) {
//            int stackIndex = i + stackOffset;
            if (i >= traces.length) {
                continue;
            }
            StackTraceElement e = traces[i];
            StringBuilder perTrace = new StringBuilder("║ ")
                    .append(level)
                    .append(e.getClassName())
                    .append('.')
                    .append(e.getMethodName())
                    .append("  (")
                    .append(e.getFileName())
                    .append(':')
                    .append(e.getLineNumber())
                    .append(")");
            level += "    ";
            println(priority, tag, perTrace.toString());
        }

        println(priority, tag, divide);
        String[] lines = msg.split(System.getProperty("line.separator"));
        for (String line : lines) {
            println(priority, tag, "║ " + line);
        }
        println(priority, tag, bottom);

    }

    private static int getStackOffset(StackTraceElement[] traces) {
        for (int i = 3; i < traces.length; i++) {
            StackTraceElement e = traces[i];
            String name = e.getClassName();
            if (!name.equals(Logger.class.getName())) {
                return --i;
            }
        }
        return -1;
    }

    private static void println(int priority, String tag, String msg) {
        if (mIsDebug) {
            Log.println(priority, tag, msg);
        }
    }

}

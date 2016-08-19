package com.mapleslong.gankio.utils;

/**
 * Created by Mapleslong on 16/8/18.
 */
public class ConvertUtil {
    public static String toString(Object value, String defaultValue) {
        if (value == null || "".equals(value.toString().trim())) {
            return defaultValue;
        }
        try {
            return String.valueOf(value);
        } catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

    public static int toInteger(Object value, int defaultValue) {
        if (value == null || "".equals(value.toString().trim())) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(value.toString().trim());
        } catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

    public static float toFloat(Object value, float defaultValue) {
        if (value == null || "".equals(value.toString().trim())) {
            return defaultValue;
        }
        try {
            return Float.parseFloat(value.toString().trim());
        } catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

    public static boolean toBoolean(Object value, boolean defaultValue) {
        if (value == null || "".equals(value.toString().trim())) {
            return defaultValue;
        }
        try {
            return Boolean.parseBoolean(value.toString().trim());
        } catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

    public static long toLong(Object value, long defaultValue) {
        if (value == null || "".equals(value.toString().trim())) {
            return defaultValue;
        }
        try {
            return Long.parseLong(value.toString().trim());
        } catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

}

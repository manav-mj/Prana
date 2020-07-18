package com.studios.prana.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedValues {
    private static final String SHARED_PREFS = "prana_shared_prefs";
    private static SharedPreferences sharedPreferences;

    public static String getString(String key) {
        String value = sharedPreferences.getString(key, null);
        return value;
    }

    public static Boolean getBoolean(String key, boolean def) {
        boolean value = sharedPreferences.getBoolean(key, def);
        return value;
    }

    public static int getInt(String key) {
        int value = sharedPreferences.getInt(key, -1);
        return value;
    }

    public static long getLong(String key) {
        long value = sharedPreferences.getLong(key, -1);
        return value;
    }

    public static void saveValue(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void saveValue(String key, boolean value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static void saveValue(String key, int value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static void saveValue(String key, long value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public static void resetUserValues() {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(Constants.USER_ID, null);
        editor.putString(Constants.FCM_TOKEN, null);
        editor.putString(Constants.USER_SESSION_TOKEN, null);

        editor.apply();
    }

    public static void resetAllValues() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear().apply();
    }

    public static void initialize(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
    }
}

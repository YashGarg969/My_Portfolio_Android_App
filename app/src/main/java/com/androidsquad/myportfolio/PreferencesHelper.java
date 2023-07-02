package com.androidsquad.myportfolio;

import android.content.Context;
import android.content.SharedPreferences;

import org.jetbrains.annotations.NotNull;

import kotlin.Unit;

public class PreferencesHelper {
    private static final String PREF_NAME = "my_preferences";

    public  void setString(Context context, String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }
    public String getString(Context context, String key, String defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, defaultValue);
    }
}
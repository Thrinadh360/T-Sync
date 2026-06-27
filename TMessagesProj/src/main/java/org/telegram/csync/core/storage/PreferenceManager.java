package org.telegram.csync.core.storage;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {

    private static final String PREF =
            "csync_preferences";

    private final SharedPreferences preferences;

    public PreferenceManager(Context context) {

        preferences =
                context.getSharedPreferences(
                        PREF,
                        Context.MODE_PRIVATE
                );
    }

    public void putString(String key,String value){

        preferences.edit().putString(key,value).apply();

    }

    public String getString(String key){

        return preferences.getString(key,"");

    }

    public void putBoolean(String key,boolean value){

        preferences.edit().putBoolean(key,value).apply();

    }

    public boolean getBoolean(String key){

        return preferences.getBoolean(key,false);

    }

    public void clear(){

        preferences.edit().clear().apply();

    }

}
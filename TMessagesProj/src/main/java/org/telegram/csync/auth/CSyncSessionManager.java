package org.telegram.csync.auth;

import android.content.Context;
import android.content.SharedPreferences;

public class CSyncSessionManager {

    private static final String PREF = "csync";

    public static boolean isRegistered(Context context) {

        SharedPreferences sp =
                context.getSharedPreferences(PREF, Context.MODE_PRIVATE);

        return sp.getBoolean("registered", false);
    }

    public static void setRegistered(Context context, boolean value) {

        SharedPreferences sp =
                context.getSharedPreferences(PREF, Context.MODE_PRIVATE);

        sp.edit().putBoolean("registered", value).apply();
    }

}
package org.telegram.csync.core.auth;

import android.content.Context;

import org.telegram.csync.core.storage.PreferenceManager;

public class SessionManager {

    private final PreferenceManager preferences;

    public SessionManager(Context context){

        preferences=
                new PreferenceManager(context);

    }

    public void saveToken(String token){

        preferences.putString(
                "token",
                token
        );

    }

    public String getToken(){

        return preferences.getString(
                "token"
        );

    }

    public void saveRole(String role){

        preferences.putString(
                "role",
                role
        );

    }

    public String getRole(){

        return preferences.getString(
                "role"
        );

    }

    public void saveUserId(String id){

        preferences.putString(
                "user",
                id
        );

    }

    public String getUserId(){

        return preferences.getString(
                "user"
        );

    }

    public void logout(){

        preferences.clear();

    }

}
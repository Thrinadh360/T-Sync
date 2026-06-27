package org.telegram.csync.core.security;

import android.content.Context;
import android.provider.Settings;

public class DeviceManager {

    private final Context context;

    public DeviceManager(Context context){

        this.context=context;

    }

    public String getDeviceId(){

        return Settings.Secure.getString(

                context.getContentResolver(),

                Settings.Secure.ANDROID_ID

        );

    }

}
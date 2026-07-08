package org.telegram.csync.core.utils;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;

public class DeviceInfo {

    public static String getDeviceName() {
        return Build.MANUFACTURER + " " + Build.MODEL;
    }

    public static String getPlatform() {
        return "Android";
    }

    public static String getAppVersion() {
        return "1.0";
    }

    public static String getAndroidId(Context context) {
        return Settings.Secure.getString(
                context.getContentResolver(),
                Settings.Secure.ANDROID_ID
        );
    }
}
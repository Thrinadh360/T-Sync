package org.telegram.csync.core.utils;

import android.util.Patterns;

public class Validation {

    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean isValidEmail(String email) {
        return email != null &&
                Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isValidMobile(String mobile) {
        return mobile != null &&
                mobile.matches("[6-9][0-9]{9}");
    }
}
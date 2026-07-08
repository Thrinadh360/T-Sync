package org.telegram.csync.core.network;

public final class Endpoints {

    private Endpoints() {}

    public static final String BASE_URL =
            "https://api.csync.top/api/";

    public static final String REGISTER =
            BASE_URL + "register";

    public static final String LOGIN =
            BASE_URL + "login";

    public static final String BOOTSTRAP =
            BASE_URL + "bootstrap";

    public static final String PROFILE =
            BASE_URL + "profile";
}
package org.telegram.csync.core.api;

import org.telegram.csync.core.network.ApiClient;
import org.telegram.csync.core.utils.Constants;

public class BootstrapApi {

    public static String load() throws Exception {

        return ApiClient.get(
                Constants.BOOTSTRAP
        );

    }

}
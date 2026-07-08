package org.telegram.csync.repositories;

import org.json.JSONObject;
import org.telegram.csync.core.network.ApiClient;
import org.telegram.csync.core.network.ApiService;
import org.telegram.csync.core.utils.Constants;
import org.telegram.csync.models.RegisterRequest;
import org.telegram.csync.models.RegisterResponse;

public class UserRepository {

    public static String login(
            String phone,
            String telegramId,
            String deviceId
    ) throws Exception {

        JSONObject body = new JSONObject();

        body.put("phone", phone);
        body.put("telegramId", telegramId);
        body.put("deviceId", deviceId);

        return ApiClient.post(
                Constants.LOGIN,
                body.toString()
        );
    }

    public RegisterResponse register(
            RegisterRequest request
    ) throws Exception {

        return ApiService.register(request);
    }
}
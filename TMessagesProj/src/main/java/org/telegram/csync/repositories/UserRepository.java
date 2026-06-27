package org.telegram.csync.repositories;

import org.json.JSONObject;
import org.telegram.csync.core.network.ApiClient;
import org.telegram.csync.core.utils.Constants;

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

}
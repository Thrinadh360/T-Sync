package org.telegram.csync.core.network;

import com.google.gson.Gson;

import org.telegram.csync.models.RegisterRequest;
import org.telegram.csync.models.RegisterResponse;

public class ApiService {

    private static final Gson gson = new Gson();

    public static RegisterResponse register(RegisterRequest request)
            throws Exception {

        String json =
                gson.toJson(request);

        String response =
                ApiClient.post(
                        Endpoints.REGISTER,
                        json
                );

        return gson.fromJson(
                response,
                RegisterResponse.class
        );
    }
}
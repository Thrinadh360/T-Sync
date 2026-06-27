package org.telegram.csync.core.network;

import org.telegram.csync.core.utils.Constants;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiClient {

    public static String get(String endpoint) throws Exception {

        URL url = new URL(Constants.BASE_URL + endpoint);

        HttpURLConnection connection =
                (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setConnectTimeout(15000);
        connection.setReadTimeout(15000);

        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                connection.getInputStream()));

        StringBuilder builder =
                new StringBuilder();

        String line;

        while ((line = reader.readLine()) != null) {

            builder.append(line);

        }

        reader.close();

        connection.disconnect();

        return builder.toString();

    }

    public static String post(String endpoint,String json)
            throws Exception{

        URL url=new URL(Constants.BASE_URL+endpoint);

        HttpURLConnection connection=
                (HttpURLConnection)url.openConnection();

        connection.setRequestMethod("POST");

        connection.setRequestProperty(
                "Content-Type",
                "application/json"
        );

        connection.setDoOutput(true);

        OutputStream output=
                connection.getOutputStream();

        output.write(json.getBytes());

        output.flush();

        output.close();

        BufferedReader reader=
                new BufferedReader(
                        new InputStreamReader(
                                connection.getInputStream()
                        ));

        StringBuilder builder=
                new StringBuilder();

        String line;

        while((line=reader.readLine())!=null){

            builder.append(line);

        }

        reader.close();

        connection.disconnect();

        return builder.toString();

    }

}
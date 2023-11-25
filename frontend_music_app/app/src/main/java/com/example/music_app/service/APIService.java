package com.example.music_app.service;

public class APIService {
    private static String base_url = "http://192.168.9.27:8080/api/v1/";

    public static DataService getService() {
        return APIRetrofitClient.getClient(base_url).create(DataService.class);
    }
}

package com.example.music_app.service;

public class APISpotifyService {
    private static String base_url = "https://api.spotify.com/v1/";
    private static String auth_url = "https://accounts.spotify.com/api/";
    public static DataService getAuthenticate() {
        return APIRetrofitClient.getClient(auth_url).create(DataService.class);
    }

    public static DataService getService() {
        return APIRetrofitClient.getClient(base_url).create(DataService.class);
    }
}

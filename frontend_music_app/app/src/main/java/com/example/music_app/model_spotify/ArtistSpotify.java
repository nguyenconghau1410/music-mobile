package com.example.music_app.model_spotify;

import java.io.Serializable;

public class ArtistSpotify implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

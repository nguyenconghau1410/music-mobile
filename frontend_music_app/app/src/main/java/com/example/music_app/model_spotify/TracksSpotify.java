package com.example.music_app.model_spotify;

import java.io.Serializable;
import java.util.List;

public class TracksSpotify implements Serializable {
    private List<ItemSpotify> items;

    public List<ItemSpotify> getItems() {
        return items;
    }

    public void setItems(List<ItemSpotify> items) {
        this.items = items;
    }
}

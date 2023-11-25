package com.example.music_app.model_spotify;

import java.io.Serializable;
import java.util.List;

public class PlaylistSpotify implements Serializable {
    private String description;
    private String id;
    private String name;
    private List<ImageSpotify> images;
    private TracksSpotify tracks;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ImageSpotify> getImages() {
        return images;
    }

    public void setImages(List<ImageSpotify> images) {
        this.images = images;
    }

    public TracksSpotify getTracks() {
        return tracks;
    }

    public void setTracks(TracksSpotify tracks) {
        this.tracks = tracks;
    }
}

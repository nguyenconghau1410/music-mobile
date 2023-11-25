package com.example.music_app.model_spotify;

import java.io.Serializable;
import java.util.List;

public class ItemSpotify implements Serializable {
    private TrackSpotify track;


    public TrackSpotify getTrack() {
        return track;
    }

    public void setTrack(TrackSpotify track) {
        this.track = track;
    }
}

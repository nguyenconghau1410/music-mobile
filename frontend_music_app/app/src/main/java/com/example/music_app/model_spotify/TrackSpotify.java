package com.example.music_app.model_spotify;

import java.io.Serializable;
import java.util.List;

public class TrackSpotify implements Serializable {
    private String href;
    private String name;
    private String preview_url;
    private List<ArtistSpotify> artists;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreview_url() {
        return preview_url;
    }

    public void setPreview_url(String preview_url) {
        this.preview_url = preview_url;
    }

    public List<ArtistSpotify> getArtists() {
        return artists;
    }

    public void setArtists(List<ArtistSpotify> artists) {
        this.artists = artists;
    }
}

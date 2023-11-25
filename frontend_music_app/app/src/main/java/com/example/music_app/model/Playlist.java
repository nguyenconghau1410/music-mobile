package com.example.music_app.model;

import java.io.Serializable;

public class Playlist implements Serializable {
    private long playlistid;
    private String name;
    private String image;
    private long userid;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPlaylistid() {
        return playlistid;
    }

    public void setPlaylistid(long playlistid) {
        this.playlistid = playlistid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }
}

package com.example.music_app.model;

public class Advertisement {
    private Long advertiseid;
    private String content;
    private String image;
    private Long songid;

    public Long getAdvertiseid() {
        return advertiseid;
    }

    public void setAdvertiseid(Long advertiseid) {
        this.advertiseid = advertiseid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getSongid() {
        return songid;
    }

    public void setSongid(Long songid) {
        this.songid = songid;
    }
}

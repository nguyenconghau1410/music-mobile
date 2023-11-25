package com.example.music_app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdvertisementDTO {
    private Long advertiseid;
    private String content;
    private String image;
    private Long songid;
}

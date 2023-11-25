package com.example.music_app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlbumDTO {
    private Long albumid;
    private String name;
    private String image;
    private String singer;
}

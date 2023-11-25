package com.example.music_app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SongDTO {
    private Long songid;
    private String name;
    private String singer;
    private String link;
    private Long categoryid;
    private Long albumid;

}

package com.example.music_app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaylistDTO {
    private Long playlistid;
    private String name;
    private String image;
    private Long userid;
}

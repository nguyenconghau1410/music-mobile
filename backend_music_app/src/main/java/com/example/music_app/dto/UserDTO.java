package com.example.music_app.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserDTO {
    private Long userid;
    private String email;
    private String password;
    private String token;
    private Long roleid;
    private String name;
    private List<SongDTO> songs;
    private List<PlaylistDTO> playlists;
}

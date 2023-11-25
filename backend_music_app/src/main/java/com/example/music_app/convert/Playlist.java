package com.example.music_app.convert;

import com.example.music_app.dto.PlaylistDTO;
import com.example.music_app.entity.PlaylistEntity;
import com.example.music_app.entity.UserEntity;

public class Playlist {

    public static PlaylistDTO toDTO(PlaylistEntity playlistEntity) {
        PlaylistDTO playlistDTO = new PlaylistDTO();
        playlistDTO.setPlaylistid(playlistEntity.getPlaylistid());
        playlistDTO.setName(playlistEntity.getName());
        playlistDTO.setImage(playlistEntity.getImage());
        playlistDTO.setUserid(playlistEntity.getUser().getUserid());
        return playlistDTO;
    }

    public static PlaylistEntity toEntity(PlaylistDTO playlistDTO, UserEntity userEntity) {
        PlaylistEntity playlist = new PlaylistEntity();
        playlist.setName(playlistDTO.getName());
        playlist.setImage(playlistDTO.getImage());
        playlist.setUser(userEntity);
        return playlist;
    }
}

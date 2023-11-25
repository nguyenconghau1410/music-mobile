package com.example.music_app.convert;

import com.example.music_app.dto.PlaylistDTO;
import com.example.music_app.dto.SongDTO;
import com.example.music_app.dto.UserDTO;
import com.example.music_app.entity.PlaylistEntity;
import com.example.music_app.entity.SongsEntity;
import com.example.music_app.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class User {

    public static UserDTO toDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserid(userEntity.getUserid());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setRoleid(userEntity.getRoleid());
        userDTO.setName(userEntity.getName());
        List<SongDTO> songs = new ArrayList<>();
        for(SongsEntity song : userEntity.getSongs()) {
            songs.add(Song.toDTO(song));
        }
        userDTO.setSongs(songs);
        List<PlaylistDTO> playlists = new ArrayList<>();
        for(PlaylistEntity playlist : userEntity.getPlaylists()) {
            playlists.add(Playlist.toDTO(playlist));
        }
        userDTO.setPlaylists(playlists);
        return userDTO;
    }
    public static UserEntity toEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setName(userDTO.getName());
        userEntity.setRoleid(1L);
        return userEntity;
    }
}

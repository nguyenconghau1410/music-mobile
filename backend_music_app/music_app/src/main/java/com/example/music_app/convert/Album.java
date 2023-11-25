package com.example.music_app.convert;

import com.example.music_app.dto.AlbumDTO;
import com.example.music_app.entity.AlbumEntity;

public class Album {
    public static AlbumDTO toDTO(AlbumEntity albumEntity) {
        AlbumDTO albumDTO = new AlbumDTO();
        albumDTO.setAlbumid(albumEntity.getAlbumid());
        albumDTO.setName(albumEntity.getName());
        albumDTO.setImage(albumEntity.getImage());
        albumDTO.setSinger(albumEntity.getSinger());
        return albumDTO;
    }
}

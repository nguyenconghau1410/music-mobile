package com.example.music_app.convert;

import com.example.music_app.dto.AlbumDTO;
import com.example.music_app.dto.SongDTO;
import com.example.music_app.entity.AlbumEntity;
import com.example.music_app.entity.CategoryEntity;
import com.example.music_app.entity.SongsEntity;

public class Song {

    public static SongDTO toDTO(SongsEntity songsEntity) {
        SongDTO songDTO = new SongDTO();
        songDTO.setSongid(songsEntity.getSongid());
        songDTO.setName(songsEntity.getName());
        songDTO.setLink(songsEntity.getLink());
        songDTO.setSinger(songsEntity.getSinger());
        songDTO.setAlbumid(songsEntity.getAlbum().getAlbumid());
        songDTO.setCategoryid(songsEntity.getCategory().getCategoryid());
        return songDTO;
    }

    public static SongsEntity toEntity(SongDTO songDTO, AlbumEntity album, CategoryEntity category) {
        SongsEntity songsEntity = new SongsEntity();
        songsEntity.setSongid(songDTO.getSongid());
        songsEntity.setName(songDTO.getName());
        songsEntity.setLink(songDTO.getLink());
        songsEntity.setSinger(songDTO.getSinger());
        songsEntity.setAlbum(album);
        songsEntity.setCategory(category);
        return songsEntity;
    }
}

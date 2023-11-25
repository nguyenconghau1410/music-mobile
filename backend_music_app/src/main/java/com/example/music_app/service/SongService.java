package com.example.music_app.service;

import com.example.music_app.dto.SongDTO;
import com.example.music_app.entity.AlbumEntity;
import com.example.music_app.entity.CategoryEntity;
import com.example.music_app.entity.SongsEntity;
import com.example.music_app.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    @Autowired
    private SongRepository songRepository;

    public List<SongsEntity> findByCategory(CategoryEntity categoryEntity) {
        return songRepository.findByCategory(categoryEntity);
    }
    public List<SongsEntity> findByAlbum(AlbumEntity albumEntity) {
        return songRepository.findByAlbum(albumEntity);
    }

    public List<SongsEntity> findByNameContaining(String keyword) {
        return songRepository.findByNameContaining(keyword);
    }

    public List<SongsEntity> getTop7Favorite() {
        return songRepository.getTop7Favorite();
    }
}

package com.example.music_app.service;

import com.example.music_app.entity.AlbumEntity;
import com.example.music_app.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;
    public List<AlbumEntity> findAll() {
        return albumRepository.findAll();
    }
    public AlbumEntity findOneByAlbumid(Long id) {
        return albumRepository.findOneByAlbumid(id);
    }
}

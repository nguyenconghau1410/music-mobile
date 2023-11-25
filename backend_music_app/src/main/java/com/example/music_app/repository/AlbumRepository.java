package com.example.music_app.repository;

import com.example.music_app.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {
    List<AlbumEntity> findAll();
    AlbumEntity findOneByAlbumid(Long id);
}

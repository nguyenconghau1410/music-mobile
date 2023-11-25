package com.example.music_app.repository;

import com.example.music_app.entity.PlaylistEntity;
import com.example.music_app.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<PlaylistEntity, Long> {
    PlaylistEntity save(PlaylistEntity playlistEntity);
    PlaylistEntity findOneByPlaylistid(Long id);
    PlaylistEntity findOneByUser(UserEntity userEntity);
}

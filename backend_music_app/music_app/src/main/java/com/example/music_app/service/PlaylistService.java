package com.example.music_app.service;

import com.example.music_app.entity.PlaylistEntity;
import com.example.music_app.entity.UserEntity;
import com.example.music_app.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;
    public PlaylistEntity save(PlaylistEntity playlistEntity) {
        return playlistRepository.save(playlistEntity);
    }

    public PlaylistEntity findOneByPlaylistid(Long id) {
        return playlistRepository.findOneByPlaylistid(id);
    }

    public PlaylistEntity findOneByUser(UserEntity userEntity) {
        return playlistRepository.findOneByUser(userEntity);
    }
}

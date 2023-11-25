package com.example.music_app.api;

import com.example.music_app.convert.Playlist;
import com.example.music_app.convert.Song;
import com.example.music_app.dto.PlaylistDTO;
import com.example.music_app.dto.SongDTO;
import com.example.music_app.entity.PlaylistEntity;
import com.example.music_app.entity.SongsEntity;
import com.example.music_app.entity.UserEntity;
import com.example.music_app.service.AlbumService;
import com.example.music_app.service.CategoryService;
import com.example.music_app.service.PlaylistService;
import com.example.music_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/playlist")
public class PlaylistAPI {

    @Autowired
    private PlaylistService playlistService;
    @Autowired
    private UserService userService;
    @Autowired
    private AlbumService albumService;
    @Autowired
    private CategoryService categoryService;
    @PostMapping("/myPlaylist/{id}")
    public ResponseEntity<PlaylistDTO> insertPlaylist(@PathVariable Long id , @RequestBody PlaylistDTO playlistDTO) {
        UserEntity user = userService.findOneByUserid(id);
        PlaylistEntity playlist = playlistService.save(Playlist.toEntity(playlistDTO, user));
        return ResponseEntity.ok(Playlist.toDTO(playlist));
    }

    @PostMapping("/addSong/{id}")
    public ResponseEntity<SongDTO> insertSong(@PathVariable Long id, @RequestBody SongDTO songDTO) {
        PlaylistEntity playlistEntity = playlistService.findOneByPlaylistid(id);
        playlistEntity.getSongs().add(Song.toEntity(songDTO, albumService.findOneByAlbumid(songDTO.getAlbumid()),
                categoryService.findOneByCategoryid(id)));
        playlistService.save(playlistEntity);
        return ResponseEntity.ok(songDTO);
    }

    @PostMapping("/getSong/{id}")
    public ResponseEntity<List<SongDTO>> getSongsInYourPlaylist(@PathVariable Long id) {
        PlaylistEntity playlistEntity = playlistService.findOneByPlaylistid(id);
        List<SongDTO> songs = new ArrayList<>();
        for(SongsEntity song : playlistEntity.getSongs()) {
            songs.add(Song.toDTO(song));
        }
        return ResponseEntity.ok(songs);
    }
}

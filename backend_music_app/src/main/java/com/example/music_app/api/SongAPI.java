package com.example.music_app.api;

import com.example.music_app.convert.Song;
import com.example.music_app.dto.SongDTO;
import com.example.music_app.entity.AlbumEntity;
import com.example.music_app.entity.CategoryEntity;
import com.example.music_app.entity.SongsEntity;
import com.example.music_app.service.AlbumService;
import com.example.music_app.service.CategoryService;
import com.example.music_app.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/song")
public class SongAPI {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SongService songService;
    @Autowired
    private AlbumService albumService;
    @PostMapping("/category/{id}")
    public ResponseEntity<List<SongDTO>> findOneByCategoryid(@PathVariable Long id) {
        CategoryEntity category = categoryService.findOneByCategoryid(id);
        List<SongsEntity> songs = songService.findByCategory(category);
        List<SongDTO> songList = new ArrayList<>();
        for(SongsEntity song : songs) {
            songList.add(Song.toDTO(song));
        }
        return ResponseEntity.ok(songList);
    }

    @PostMapping("/album/{id}")
    public ResponseEntity<List<SongDTO>> findByAlbum(@PathVariable Long id) {
        AlbumEntity album = albumService.findOneByAlbumid(id);
        List<SongsEntity> songs = songService.findByAlbum(album);
        List<SongDTO> songList = new ArrayList<>();
        for(SongsEntity song : songs) {
            songList.add(Song.toDTO(song));
        }
        return ResponseEntity.ok(songList);
    }

    @GetMapping("/search")
    public ResponseEntity<List<SongDTO>> findByNameContaining(@RequestParam String keyword) {
        List<SongsEntity> songsEntities = songService.findByNameContaining(keyword);
        List<SongDTO> songs = new ArrayList<>();
        for(SongsEntity song : songsEntities) {
            songs.add(Song.toDTO(song));
        }
        return ResponseEntity.ok(songs);
    }

    @GetMapping("/top7")
    public ResponseEntity<List<SongDTO>> getTop7Favorite() {
        List<SongsEntity> songList = songService.getTop7Favorite();
        List<SongDTO> songs = new ArrayList<>();
        for (SongsEntity song : songList) {
            songs.add(Song.toDTO(song));
        }
        return ResponseEntity.ok(songs);
    }
}

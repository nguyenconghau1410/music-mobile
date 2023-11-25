package com.example.music_app.api;

import com.example.music_app.convert.Album;
import com.example.music_app.dto.AlbumDTO;
import com.example.music_app.entity.AlbumEntity;
import com.example.music_app.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/album")
public class AlbumAPI {
    @Autowired
    private AlbumService albumService;
    @GetMapping("/all")
    public ResponseEntity<List<AlbumDTO>> findAll() {
        List<AlbumEntity> albums = albumService.findAll();
        List<AlbumDTO> list = new ArrayList<>();
        for(AlbumEntity album : albums) {
            list.add(Album.toDTO(album));
        }
        return ResponseEntity.ok(list);
    }
    @PostMapping("one/{id}")
    public ResponseEntity<AlbumDTO> findOneByAlbumid(@PathVariable Long id) {
        return ResponseEntity.ok(Album.toDTO(albumService.findOneByAlbumid(id)));
    }
}

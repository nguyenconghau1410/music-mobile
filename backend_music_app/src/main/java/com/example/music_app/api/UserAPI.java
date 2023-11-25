package com.example.music_app.api;

import com.example.music_app.convert.Song;
import com.example.music_app.convert.User;
import com.example.music_app.dto.SongDTO;
import com.example.music_app.dto.UserDTO;
import com.example.music_app.entity.UserEntity;
import com.example.music_app.service.AlbumService;
import com.example.music_app.service.CategoryService;
import com.example.music_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class UserAPI {

    @Autowired
    private UserService userService;
    @Autowired
    private AlbumService albumService;
    @Autowired
    private CategoryService categoryService;
    @PostMapping("favorite/{id}")
    public void insert(@PathVariable Long id ,@RequestBody SongDTO songDTO) {
        UserEntity userEntity = userService.findOneByUserid(id);

        userEntity.getSongs().add(Song.toEntity(songDTO, albumService.findOneByAlbumid(songDTO.getAlbumid()),
                categoryService.findOneByCategoryid(id)));
        userService.save(userEntity);
    }
    @DeleteMapping("favorite/{id}")
    public void delete(@PathVariable Long id ,@RequestParam Long songid) {
        UserEntity userEntity = userService.findOneByUserid(id);
        userEntity.getSongs().removeIf(song -> song.getSongid().equals(songid));
        userService.save(userEntity);
    }

}

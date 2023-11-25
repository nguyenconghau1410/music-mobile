package com.example.music_app.api;

import com.example.music_app.convert.User;
import com.example.music_app.dto.UserDTO;
import com.example.music_app.entity.UserEntity;
import com.example.music_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthAPI {
    @Autowired
    private UserService userService;
    @PostMapping("/authenticate")
    public ResponseEntity<UserDTO> authenticate(@RequestBody UserDTO userDTO) {
        UserEntity userEntity = userService.findByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword());
        if(userEntity != null) return ResponseEntity.ok(User.toDTO(userEntity));
        else return null;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) {
        UserEntity user = userService.save(User.toEntity(userDTO));
        return ResponseEntity.ok(User.toDTO(user));
    }
}

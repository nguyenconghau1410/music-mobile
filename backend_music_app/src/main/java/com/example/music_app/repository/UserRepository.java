package com.example.music_app.repository;

import com.example.music_app.entity.SongsEntity;
import com.example.music_app.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmailAndPassword(String email, String password);
    UserEntity save(UserEntity userEntity);
    UserEntity findOneByUserid(Long id);

}

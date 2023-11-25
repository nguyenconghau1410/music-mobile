package com.example.music_app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
    private String email;
    private String password;
    private String name;
    private String token;
    private Long roleid;
    @OneToMany(mappedBy = "user")
    private List<PlaylistEntity> playlists = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "favorite", joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "songid"))
    private List<SongsEntity> songs = new ArrayList<>();
}

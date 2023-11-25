package com.example.music_app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "playlist")
@Getter
@Setter
public class PlaylistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playlistid;
    private String name;
    private String image;
    @ManyToOne
    @JoinColumn(name = "userid")
    private UserEntity user;
    @ManyToMany
    @JoinTable(name = "song_playlist", joinColumns = @JoinColumn(name = "playlistid"),
                                        inverseJoinColumns = @JoinColumn(name = "songid"))
    private List<SongsEntity> songs = new ArrayList<>();


}

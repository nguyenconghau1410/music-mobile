package com.example.music_app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "songs")
@Getter
@Setter
public class SongsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long songid;
    private String name;
    private String link;
    private String singer;
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private CategoryEntity category;
    @ManyToMany(mappedBy = "songs")
    private List<PlaylistEntity> playlist = new ArrayList<>();

    @ManyToMany(mappedBy = "songs")
    private List<UserEntity> users = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "albumid")
    private AlbumEntity album;


}

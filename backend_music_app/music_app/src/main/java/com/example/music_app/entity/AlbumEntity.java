package com.example.music_app.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Album")
@Getter
@Setter
public class AlbumEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long albumid;
    private String name;
    private String image;
    private String singer;
    @OneToMany(mappedBy = "album")
    private List<SongsEntity> songs = new ArrayList<>();
}

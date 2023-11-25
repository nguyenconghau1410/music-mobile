package com.example.music_app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "advertisement")
@Getter
@Setter
public class AdvertisementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advertiseid;
    private String content;
    private String image;
    private Long songid;
}

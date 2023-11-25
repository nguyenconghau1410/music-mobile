package com.example.music_app.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Category")
@Getter
@Setter
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryid;

    private String name;
    private String image;
    @OneToMany(mappedBy = "category")
    private List<SongsEntity> songs = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "topicid")
    private TopicEntity topic;
}

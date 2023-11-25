package com.example.music_app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "topic")
@Getter
@Setter
public class TopicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topicid;
    private String name;
    private String image;
    @OneToMany(mappedBy = "topic")
    private List<CategoryEntity> categories = new ArrayList<>();

}

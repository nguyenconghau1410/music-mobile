package com.example.music_app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {
    private Long categoryid;
    private String name;
    private String image;
    private Long topicid;
}

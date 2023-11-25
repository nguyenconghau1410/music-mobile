package com.example.music_app.convert;

import com.example.music_app.dto.CategoryDTO;
import com.example.music_app.dto.TopicDTO;
import com.example.music_app.entity.TopicEntity;

public class Topic {
    public static TopicDTO toDTO(TopicEntity topicEntity) {
        TopicDTO topicDTO = new TopicDTO();
        topicDTO.setTopicid(topicEntity.getTopicid());
        topicDTO.setName(topicEntity.getName());
        topicDTO.setImage(topicEntity.getImage());
        return topicDTO;
    }

    public static TopicEntity toEntity(TopicDTO topicDTO) {
        TopicEntity topicEntity = new TopicEntity();
        topicEntity.setTopicid(topicDTO.getTopicid());
        topicEntity.setName(topicDTO.getName());
        topicEntity.setImage(topicDTO.getImage());
        return topicEntity;
    }
}

package com.example.music_app.service;

import com.example.music_app.entity.CategoryEntity;
import com.example.music_app.entity.TopicEntity;
import com.example.music_app.entity.UserEntity;
import com.example.music_app.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;
    public List<TopicEntity> findAll() {
        return topicRepository.findAll();
    }

    public TopicEntity findByTopicid(Long id) {
        return topicRepository.findByTopicid(id);
    }

    public List<CategoryEntity> findCategoriesByTopicid(Long topicid) {
        return topicRepository.findCategoriesByTopicid(topicid);
    }
}

package com.example.music_app.repository;

import com.example.music_app.entity.CategoryEntity;
import com.example.music_app.entity.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<TopicEntity, Long> {
    List<TopicEntity> findAll();
    TopicEntity findByTopicid(Long topicid);
    List<CategoryEntity> findCategoriesByTopicid(Long topicid);
}

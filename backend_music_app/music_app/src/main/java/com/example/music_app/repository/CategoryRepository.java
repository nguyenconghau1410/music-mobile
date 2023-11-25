package com.example.music_app.repository;

import com.example.music_app.entity.CategoryEntity;
import com.example.music_app.entity.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    List<CategoryEntity> findByTopic(TopicEntity topic);
    CategoryEntity findOneByCategoryid(Long categoryid);
}

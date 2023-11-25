package com.example.music_app.service;

import com.example.music_app.entity.CategoryEntity;
import com.example.music_app.entity.TopicEntity;
import com.example.music_app.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryEntity> findByTopic(TopicEntity topic) {
        return categoryRepository.findByTopic(topic);
    }

    public CategoryEntity findOneByCategoryid(Long categoryid) {
        return categoryRepository.findOneByCategoryid(categoryid);
    }
}

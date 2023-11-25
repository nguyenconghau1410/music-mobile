package com.example.music_app.api;

import com.example.music_app.convert.Category;
import com.example.music_app.convert.Topic;
import com.example.music_app.dto.CategoryDTO;
import com.example.music_app.dto.TopicDTO;
import com.example.music_app.entity.CategoryEntity;
import com.example.music_app.entity.TopicEntity;
import com.example.music_app.service.CategoryService;
import com.example.music_app.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryAPI {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TopicService topicService;
    @PostMapping("/{id}")
    public ResponseEntity<List<CategoryDTO>> findByTopicid(@PathVariable Long id) {
        TopicEntity topicEntity = topicService.findByTopicid(id);
        List<CategoryEntity> categoryEntityList = categoryService.findByTopic(topicEntity);
        List<CategoryDTO> categories = new ArrayList<>();
        for (CategoryEntity category : categoryEntityList) {
            categories.add(Category.toDTO(category));
        }
        return ResponseEntity.ok(categories);
    }
    @PostMapping("one/{id}")
    public ResponseEntity<CategoryDTO> findOneByCategoryid(@PathVariable Long id) {
        return ResponseEntity.ok(Category.toDTO(categoryService.findOneByCategoryid(id)));
    }
}

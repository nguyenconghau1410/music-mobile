package com.example.music_app.convert;

import com.example.music_app.dto.CategoryDTO;
import com.example.music_app.entity.CategoryEntity;

public class Category {

    public static CategoryDTO toDTO(CategoryEntity categoryEntity) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryid(categoryEntity.getCategoryid());
        categoryDTO.setName(categoryEntity.getName());
        categoryDTO.setImage(categoryEntity.getImage());
        categoryDTO.setTopicid(categoryEntity.getTopic().getTopicid());
        return categoryDTO;
    }
}

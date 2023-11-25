package com.example.music_app.api;

import com.example.music_app.convert.Topic;
import com.example.music_app.dto.TopicDTO;
import com.example.music_app.entity.TopicEntity;
import com.example.music_app.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/topic")
public class TopicAPI {
    @Autowired
    private TopicService topicService;
    @GetMapping("/all")
    public ResponseEntity<List<TopicDTO>> findAll() {
        List<TopicEntity> topics = topicService.findAll();
        List<TopicDTO> list = new ArrayList<>();
        for(TopicEntity topic : topics) {
            list.add(Topic.toDTO(topic));
        }
        return ResponseEntity.ok(list);
    }
}

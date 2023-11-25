package com.example.music_app.api;

import com.example.music_app.convert.Advertisement;
import com.example.music_app.dto.AdvertisementDTO;
import com.example.music_app.entity.AdvertisementEntity;
import com.example.music_app.service.AdvertisementService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/advertise")
public class AdvertisementAPI {
    @Autowired
    private AdvertisementService advertisementService;
    @PostMapping("/{id}")
    public ResponseEntity<AdvertisementDTO> findOneByAdvertiseid(@PathVariable Long id) {
        return ResponseEntity.ok(
          Advertisement.toDTO(advertisementService.findOneByAdvertiseid(id))
        );
    }
    @GetMapping
    public ResponseEntity<List<AdvertisementDTO>> findAll() {
        List<AdvertisementEntity> advertisementEntities = advertisementService.findAll();
        List<AdvertisementDTO> advertises = new ArrayList<>();
        for(AdvertisementEntity adver : advertisementEntities) {
            advertises.add(Advertisement.toDTO(adver));
        }
        return ResponseEntity.ok(advertises);
    }
}

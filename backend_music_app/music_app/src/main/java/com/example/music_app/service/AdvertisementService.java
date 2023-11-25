package com.example.music_app.service;

import com.example.music_app.entity.AdvertisementEntity;
import com.example.music_app.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementService {

    @Autowired
    private AdvertisementRepository advertisementRepository;
    public AdvertisementEntity findOneByAdvertiseid(Long id) {
        return advertisementRepository.findOneByAdvertiseid(id);
    }

    public List<AdvertisementEntity> findAll() {
        return advertisementRepository.findAll();
    }
}

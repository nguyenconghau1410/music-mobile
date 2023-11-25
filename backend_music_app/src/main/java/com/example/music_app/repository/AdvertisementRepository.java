package com.example.music_app.repository;

import com.example.music_app.entity.AdvertisementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<AdvertisementEntity, Long> {
    AdvertisementEntity findOneByAdvertiseid(Long id);
    List<AdvertisementEntity> findAll();
}

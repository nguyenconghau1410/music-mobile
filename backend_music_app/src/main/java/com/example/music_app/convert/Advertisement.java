package com.example.music_app.convert;

import com.example.music_app.dto.AdvertisementDTO;
import com.example.music_app.entity.AdvertisementEntity;

public class Advertisement {
    public static AdvertisementDTO toDTO(AdvertisementEntity advertisement) {
        AdvertisementDTO adver = new AdvertisementDTO();
        adver.setSongid(advertisement.getSongid());
        adver.setAdvertiseid(advertisement.getAdvertiseid());
        adver.setContent(advertisement.getContent());
        adver.setImage(advertisement.getImage());
        return adver;
    }
}

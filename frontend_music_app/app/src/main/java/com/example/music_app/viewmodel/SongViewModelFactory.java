package com.example.music_app.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class SongViewModelFactory implements ViewModelProvider.Factory {
    private final Long playlistid;
    public SongViewModelFactory(Long playlistId) {
        this.playlistid = playlistId;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(SongViewModel.class)) {
            return (T) new SongViewModel(playlistid);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}

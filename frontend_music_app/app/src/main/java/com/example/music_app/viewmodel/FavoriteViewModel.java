package com.example.music_app.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.music_app.model.Song;
import com.example.music_app.utils.Utility;

import java.util.ArrayList;
import java.util.List;

public class FavoriteViewModel extends ViewModel {
    private MutableLiveData<List<Song>> songFavoriteListLiveData = new MutableLiveData<>();

    public FavoriteViewModel() {
        this.songFavoriteListLiveData.setValue(Utility.favoriteSong);
    }

    public LiveData<List<Song>> getSongFavoriteListLiveData() {
        return this.songFavoriteListLiveData;
    }

    public void addFavoriteSong(Song song) {
        List<Song> currentList = songFavoriteListLiveData.getValue();
        currentList.add(song);
        songFavoriteListLiveData.setValue(currentList);
    }
}

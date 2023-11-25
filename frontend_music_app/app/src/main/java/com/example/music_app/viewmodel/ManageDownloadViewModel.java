package com.example.music_app.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.music_app.model.Song;
import com.example.music_app.utils.Utility;

import java.util.List;

public class ManageDownloadViewModel extends ViewModel {
    private static MutableLiveData<List<Song>> songLiveData;
    public static List<Song> mSongList;

    public ManageDownloadViewModel() {
        songLiveData = new MutableLiveData<>();
        songLiveData.setValue(Utility.downloadFavorite);
    }

    public MutableLiveData<List<Song>> getSongLiveData() {
        return songLiveData;
    }

    public static void addSong(Song song) {
        Utility.downloadFavorite.add(song);
        songLiveData.setValue(Utility.downloadFavorite);
    }

    public static void deleteSong(int position) {
        Utility.downloadFavorite.remove(position);
        songLiveData.setValue(Utility.downloadFavorite);
    }
}

package com.example.music_app.viewmodel;

import android.app.Activity;
import android.app.Application;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.example.music_app.model.Playlist;
import com.example.music_app.utils.Utility;

import java.util.ArrayList;
import java.util.List;

public class PlaylistViewModel extends ViewModel {
    private static MutableLiveData<List<Playlist>> playlistsLiveData = new MutableLiveData<>();
    private static List<Playlist> mList;
    public static PlaylistViewModel instance;
    public PlaylistViewModel() {
        this.playlistsLiveData = new MutableLiveData<>();
        Playlist playlist = new Playlist();
        playlist.setName("Tạo playlist");
        Utility.playlists.add(0, playlist);
        this.playlistsLiveData.setValue(Utility.playlists);
    }

    public static PlaylistViewModel getInstance(Activity activity) {
        if(instance == null) {
            instance = new ViewModelProvider((ViewModelStoreOwner) activity).get(PlaylistViewModel.class);
        }
        return instance;
    }

    public MutableLiveData<List<Playlist>> getPlaylistsLiveData() {
        return playlistsLiveData;
    }

    public static void addPlaylist(Playlist playlist) {
        Utility.playlists.add(playlist);
        playlistsLiveData.setValue(Utility.playlists);
    }
}

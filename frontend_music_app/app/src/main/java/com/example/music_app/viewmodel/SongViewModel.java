package com.example.music_app.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.music_app.model.Song;
import com.example.music_app.service.APIService;
import com.example.music_app.service.DataService;
import com.example.music_app.utils.Utility;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SongViewModel extends ViewModel {
    private static MutableLiveData<List<Song>> songLiveData;
    public static List<Song> mSongList;

    public SongViewModel(Long id) {
        songLiveData = new MutableLiveData<>();
        GetData(id);
    }

    public SongViewModel() {
        songLiveData = new MutableLiveData<>();
        songLiveData.setValue(Utility.favoriteSong);
    }

    public MutableLiveData<List<Song>> getSongLiveData() {
        return songLiveData;
    }

    public static void addSong(Song song) {
        mSongList.add(song);
        songLiveData.setValue(mSongList);
    }

    public static void deleteSong(int id) {
        Utility.favoriteSong.remove(id);
        songLiveData.setValue(Utility.favoriteSong);
    }

    private void GetData(Long id) {
        DataService dataService = APIService.getService();
        Call<List<Song>> call = dataService.getSongsInYourPlaylis(id);
        call.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                if(response.isSuccessful()) {
                    if(response.body().size() != 0) {
                        mSongList = response.body();
                        songLiveData.setValue(mSongList);
                    }
                    else {
                        mSongList = new ArrayList<>();
                        songLiveData.setValue(mSongList);
                    }
                }
                else {
                    Log.e("API ERROR", "CCCCCCCCCCCCCCCCCCCC");
                }
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {
                Log.e("API ERROR", t.getMessage());
            }
        });
    }
}

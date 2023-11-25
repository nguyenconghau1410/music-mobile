package com.example.music_app.utils;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.music_app.model.Playlist;
import com.example.music_app.model.Song;
import com.example.music_app.service.APIService;
import com.example.music_app.service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Utility {

    public static String ClientID = "55a427d5cafc44a4bb404ef60006b926";
    public static String ClientSecret = "cc595eccdc964f35ad835245ffe74681";
    public static Long userid;
    public static List<Song> favoriteSong = null;
    public static List<Playlist> playlists = new ArrayList<>();

    public static List<Song> downloadFavorite = new ArrayList<>();


    public static List<Song> getSongsInYourPlaylist(Long id) {
        DataService dataService = APIService.getService();
        Call<List<Song>> call = dataService.getSongsInYourPlaylis(id);
        List<Song> songs = new ArrayList<>();
        call.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                if(response.isSuccessful()) {
                    for (Song song : response.body()) {
                        songs.add(song);
                    }
                }
                else {
                    Log.e("API ERRORRRRR", "cccccccccccccc");
                }
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {
                Log.e("API ERRORRRRRR", t.getMessage());
            }
        });
        return songs;
    }

    public static void insertFavorite(Long id, Song song, Context context) {
        DataService dataService = APIService.getService();
        Call<Void> call = dataService.insertFavorite(id, song);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(context, "Đã thích", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    public static void deleteFavorite(Long id, Long songid, Context context) {
        DataService dataService = APIService.getService();
        Call<Void> call = dataService.deleteFavorite(id, songid);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()) {

                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = listView.getPaddingTop() + listView.getPaddingBottom();
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);

            if(listItem != null){
                // This next line is needed before you call measure or else you won't get measured height at all. The listitem needs to be drawn first to know the height.
                listItem.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
                listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
                totalHeight += listItem.getMeasuredHeight();

            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}

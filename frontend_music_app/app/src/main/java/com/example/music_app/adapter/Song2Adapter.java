package com.example.music_app.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.music_app.MySongPlaylist;
import com.example.music_app.R;
import com.example.music_app.model.Song;
import com.example.music_app.service.APIService;
import com.example.music_app.service.DataService;
import com.example.music_app.viewmodel.SongViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Song2Adapter extends ArrayAdapter<Song> {
    public Song2Adapter(@NonNull Context context, int resource, @NonNull List<Song> objects) {
        super(context, resource, objects);
    }

    class ViewHolder {
        ImageView background, adding;
        TextView name, singer;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(viewHolder == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.song2, null);
            viewHolder = new ViewHolder();
            viewHolder.background = convertView.findViewById(R.id.imageViewBackgroundTheSong);
            viewHolder.adding = convertView.findViewById(R.id.imageViewAddingSong);
            viewHolder.name = convertView.findViewById(R.id.textViewNameSongAdding);
            viewHolder.singer = convertView.findViewById(R.id.textViewSingerAdding);
            convertView.setTag(viewHolder);
        }
        else {
            convertView.getTag();
        }
        Song song = getItem(position);
        viewHolder.background.setImageResource(R.drawable.zing1);
        viewHolder.name.setText(song.getName());
        viewHolder.singer.setText(song.getSinger());


        viewHolder.adding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = false;
                for(Song song1 : SongViewModel.mSongList) {
                    if(song1.getSongid().equals(song.getSongid())) {
                        check = true;
                        Toast.makeText(getContext(), "Bài hát này đã có trong playlist này", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                if (check == false) {
                    fetchAPI(MySongPlaylist.playlistid, song);
                }
            }
        });
        return convertView;
    }

    private void fetchAPI(Long id, Song song) {
        DataService dataService = APIService.getService();
        Call<Song> call = dataService.insertSongOnPlaylist(id, song);
        call.enqueue(new Callback<Song>() {
            @Override
            public void onResponse(Call<Song> call, Response<Song> response) {
                if(response.body() != null) {
                    SongViewModel.addSong(song);
                    Toast.makeText(getContext(), "Đã thêm vào playlist", Toast.LENGTH_SHORT).show();
                }
                else {
                    Log.e("API ERROR", "ccccccccccccccccccccccc");
                }
            }

            @Override
            public void onFailure(Call<Song> call, Throwable t) {
                Log.e("API ERROR", t.getMessage());
            }
        });
    }
}

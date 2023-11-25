package com.example.music_app.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music_app.PlayMusic;
import com.example.music_app.R;
import com.example.music_app.model.Song;
import com.example.music_app.utils.Utility;
import com.example.music_app.viewmodel.SongViewModel;

import java.io.Serializable;
import java.util.List;

public class Song3Adapter extends RecyclerView.Adapter<Song3Adapter.ViewHolder> {

    private Context context;
    private List<Song> songs;

    public Song3Adapter(Context context, List<Song> songs) {
        this.context = context;
        this.songs = songs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.song1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = songs.get(position);

        int pos = position;

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlayMusic.class);
                intent.putExtra("song", song);
                intent.putExtra("songList", (Serializable) songs);
                intent.putExtra("signal", "itself");
                if(context instanceof Activity) {
                    ((Activity)context).startActivity(intent);
                }
                else {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            }
        });
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SongViewModel.deleteSong(pos);
                Utility.deleteFavorite(Utility.userid, song.getSongid(), context);
            }
        });



        holder.stt.setText((position + 1) + "");
        holder.name.setText(song.getName());
        holder.singer.setText(song.getSinger());
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView stt, name, singer;
        ImageView remove;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            stt = itemView.findViewById(R.id.textViewSTT);
            name = itemView.findViewById(R.id.textViewNameSong);
            singer = itemView.findViewById(R.id.textViewSinger);
            remove = itemView.findViewById(R.id.imageViewDeleteFavoriteSong);
        }
    }
}

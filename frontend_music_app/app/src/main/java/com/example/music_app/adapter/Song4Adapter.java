package com.example.music_app.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music_app.PlayMusic;
import com.example.music_app.R;
import com.example.music_app.model.Song;
import com.example.music_app.utils.Utility;

import java.io.Serializable;
import java.util.List;

public class Song4Adapter extends RecyclerView.Adapter<Song4Adapter.ViewHolder> {
    private Context context;
    private List<Song> songs;

    public Song4Adapter(Context context, List<Song> songs) {
        this.context = context;
        this.songs = songs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.song3, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = songs.get(position);

        holder.background.setImageResource(R.drawable.zing);
        holder.name.setText(song.getName());
        holder.singer.setText(song.getSinger());

        boolean check = false;
        for (Song song1 : Utility.favoriteSong) {
            if(song1.getSongid().equals(song.getSongid())) {
                check = true;
                break;
            }
        }
        if(check == true)
            holder.adding.setImageResource(R.drawable.baseline_favorite_24_true);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlayMusic.class);
                intent.putExtra("song", song);
                intent.putExtra("songList", (Serializable) songs);
                if(context instanceof Activity) {
                    ((Activity)context).startActivity(intent);
                }
                else {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView background, adding;
        TextView name, singer;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            background = itemView.findViewById(R.id.imageViewBackgroundTheSong3);
            adding = itemView.findViewById(R.id.imageViewAddingSong3);
            name = itemView.findViewById(R.id.textViewNameSongAdding3);
            singer = itemView.findViewById(R.id.textViewSingerAdding3);

            adding.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Song song = songs.get(position);
                    boolean check = false;
                    for(Song song1 : Utility.favoriteSong) {
                        if(song1.getSongid().equals(song.getSongid())) {
                            Toast.makeText(context, "Bạn đã thích bài hát này!", Toast.LENGTH_SHORT).show();
                            check = true;
                            break;
                        }
                    }
                    if(!check) {
                        Utility.insertFavorite(Utility.userid, song, context);
                        Utility.favoriteSong.add(song);
                        Toast.makeText(context, "Đã thích", Toast.LENGTH_SHORT).show();
                        adding.setImageResource(R.drawable.baseline_favorite_24_true);
                    }
                }
            });
        }
    }
}

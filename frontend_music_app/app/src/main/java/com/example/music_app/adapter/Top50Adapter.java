package com.example.music_app.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music_app.PlayMusic;
import com.example.music_app.R;
import com.example.music_app.model.Song;
import com.example.music_app.model_spotify.TrackSpotify;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Top50Adapter extends RecyclerView.Adapter<Top50Adapter.ViewHolder> {
    private Context context;
    private List<TrackSpotify> trackSpotifies;

    public Top50Adapter(Context context, List<TrackSpotify> trackSpotifies) {
        this.context = context;
        this.trackSpotifies = trackSpotifies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.song6, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TrackSpotify trackSpotify = trackSpotifies.get(position);
        holder.stt.setText(position + 1 + "");
        holder.name.setText(trackSpotify.getName());
        holder.singer.setText(trackSpotify.getArtists().get(0).getName());
        int pos = position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Song> songs = new ArrayList<>();
                for(TrackSpotify track : trackSpotifies) {
                    Song song = new Song();
                    song.setName(track.getName());
                    song.setSinger(track.getArtists().get(0).getName());
                    song.setLink(track.getPreview_url());
                    songs.add(song);
                }
                Intent intent = new Intent(context, PlayMusic.class);
                intent.putExtra("song", songs.get(pos));
                intent.putExtra("songList", (Serializable) songs);
                if(context instanceof Activity) {
                    ((Activity) context).startActivity(intent);
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
        return trackSpotifies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView stt, name, singer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            stt = itemView.findViewById(R.id.textViewSTTTop50);
            name = itemView.findViewById(R.id.textViewNameSongTop50);
            singer = itemView.findViewById(R.id.textViewSingerTop50);
        }
    }
}

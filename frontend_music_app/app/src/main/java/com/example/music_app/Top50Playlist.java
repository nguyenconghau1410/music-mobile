package com.example.music_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.music_app.adapter.Top50Adapter;
import com.example.music_app.model.Song;
import com.example.music_app.model_spotify.ItemSpotify;
import com.example.music_app.model_spotify.PlaylistSpotify;
import com.example.music_app.model_spotify.TrackSpotify;
import com.example.music_app.model_spotify.TracksSpotify;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Top50Playlist extends AppCompatActivity {

    private ImageView back, background;
    private TextView title;
    private CardView cardView;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top50_playlist);

        back = findViewById(R.id.imageViewPlaylistTop50Back);
        background = findViewById(R.id.imageViewPlaylistTop50);
        title = findViewById(R.id.textViewPlaylistTop50Title);
        cardView = findViewById(R.id.cardViewPlaylistTop50);
        recyclerView = findViewById(R.id.recyclerViewTop50);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        Intent intent = getIntent();
        if(intent != null) {
            PlaylistSpotify spotify = (PlaylistSpotify) intent.getSerializableExtra("spotify");
            if(spotify.getImages().get(0) != null)
                Picasso.with(getApplicationContext()).load(spotify.getImages().get(0).getUrl()).into(background);
            title.setText(spotify.getName());
            TracksSpotify tracksSpotify = spotify.getTracks();
            List<TrackSpotify> list = new ArrayList<>();
            for (ItemSpotify item : tracksSpotify.getItems()) {
                list.add(item.getTrack());
            }
            Top50Adapter adapter = new Top50Adapter(getApplicationContext(), list);
            recyclerView.setAdapter(adapter);
        }
    }


}
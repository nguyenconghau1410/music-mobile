package com.example.music_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.music_app.adapter.Song4Adapter;
import com.example.music_app.model.Playlist;
import com.example.music_app.model.Song;
import com.example.music_app.utils.Utility;
import com.example.music_app.viewmodel.SongViewModel;
import com.example.music_app.viewmodel.SongViewModelFactory;

import java.util.List;

public class MySongPlaylist extends AppCompatActivity {
    private ImageView imageView, back;
    private TextView textView;
    private CardView cardView;
    private RecyclerView recyclerView;
    private SongViewModel songViewModel;
    private Song4Adapter adapter;
    public static Long playlistid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_song_playlist);
        imageView = findViewById(R.id.imageViewMySongPlaylist);
        back = findViewById(R.id.imageViewMySongPlaylistBack);
        textView = findViewById(R.id.textViewMySongPlaylistTitle);
        cardView = findViewById(R.id.cardViewMySongPlaylist);
        recyclerView = findViewById(R.id.recyclerViewMySongPlaylist);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        Intent intent = getIntent();
        if(intent != null) {
            Playlist playlist = (Playlist) intent.getSerializableExtra("playlist");
            this.playlistid = playlist.getPlaylistid();
            textView.setText(playlist.getName());

            SongViewModelFactory factory = new SongViewModelFactory(playlist.getPlaylistid());
            songViewModel = new ViewModelProvider(this, factory).get(SongViewModel.class);
            songViewModel.getSongLiveData().observe(this, new Observer<List<Song>>() {
                @Override
                public void onChanged(List<Song> songs) {
                    adapter = new Song4Adapter(getApplicationContext(), songs);
                    recyclerView.setAdapter(adapter);
                }
            });
        }

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), AddingSong.class);
                startActivity(it);
            }
        });


        imageView.setImageResource(R.drawable.playlist);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
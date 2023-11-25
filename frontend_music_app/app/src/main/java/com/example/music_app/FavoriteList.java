package com.example.music_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.music_app.adapter.Song1Apdater;
import com.example.music_app.adapter.Song3Adapter;
import com.example.music_app.fragments.SongsFragment;
import com.example.music_app.model.Song;
import com.example.music_app.utils.DownloadTask;
import com.example.music_app.utils.Utility;
import com.example.music_app.viewmodel.SongViewModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FavoriteList extends AppCompatActivity {

    private androidx.appcompat.widget.Toolbar toolbar;
    private RecyclerView recyclerView;

    private CardView cardView;

    private TextView total;
    private Song3Adapter apdater;

    private SongViewModel songViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_list);

        init();

    }

    private void init() {
        toolbar = findViewById(R.id.toolbarFavoriteList);
        recyclerView = findViewById(R.id.recyclerViewFavoriteList);
        cardView = findViewById(R.id.cardViewFavoriteList);

        total = findViewById(R.id.textViewFavoriteListTotal);
        total.setText("Tất cả (" +  Utility.favoriteSong.size() + ")");

        toolbar.setNavigationIcon(R.drawable.baseline_keyboard_backspace_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PlayMusic.class);
                intent.putExtra("songList", (Serializable) Utility.favoriteSong);
                intent.putExtra("song", Utility.favoriteSong.get(0));
                startActivity(intent);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        songViewModel = new ViewModelProvider(this).get(SongViewModel.class);
        songViewModel.getSongLiveData().observe(this, new Observer<List<Song>>() {
            @Override
            public void onChanged(List<Song> songs) {
                apdater = new Song3Adapter(getApplicationContext(), Utility.favoriteSong);
                recyclerView.setAdapter(apdater);
            }
        });
    }
}
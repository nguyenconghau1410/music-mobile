package com.example.music_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.Manifest;
import android.widget.TextView;
import android.widget.Toast;

import com.example.music_app.adapter.Song6Adapter;
import com.example.music_app.model.Song;
import com.example.music_app.utils.DownloadTask;
import com.example.music_app.utils.Utility;
import com.example.music_app.viewmodel.ManageDownloadViewModel;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DownloadSong extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView textView;
    private CardView cardView;
    private RecyclerView recyclerView;

    private ManageDownloadViewModel viewModel;

    private Song6Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_song);

        toolbar = findViewById(R.id.toolbarDownloadList);
        textView = findViewById(R.id.textViewDownloadListTotal);
        cardView = findViewById(R.id.cardViewDownloadList);
        recyclerView = findViewById(R.id.recyclerViewDownloadList);

        toolbar.setNavigationIcon(R.drawable.baseline_keyboard_backspace_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        DownloadTask.getSongFile(getApplicationContext(), DownloadSong.this);

        textView.setText("(" + Utility.downloadFavorite.size() + ")");
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        viewModel = new ViewModelProvider(this).get(ManageDownloadViewModel.class);
        viewModel.getSongLiveData().observe(DownloadSong.this, new Observer<List<Song>>() {
            @Override
            public void onChanged(List<Song> songs) {
                adapter = new Song6Adapter(getApplicationContext(), songs, DownloadSong.this);
                recyclerView.setAdapter(adapter);
            }
        });

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PlayMusic.class);
                intent.putExtra("song", Utility.downloadFavorite.get(0));
                intent.putExtra("songList", (Serializable) Utility.downloadFavorite);
                startActivity(intent);
            }
        });

    }

}
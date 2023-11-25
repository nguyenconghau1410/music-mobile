package com.example.music_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.music_app.adapter.AllAlbumAdapter;
import com.example.music_app.model.Album;
import com.example.music_app.service.APIService;
import com.example.music_app.service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllAlbum extends AppCompatActivity {

    private RecyclerView recyclerViewAllAlbum;
    private androidx.appcompat.widget.Toolbar toolbar;
    private AllAlbumAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_album);
        toolbar = findViewById(R.id.toolbar2);
        recyclerViewAllAlbum = findViewById(R.id.recycleViewAllAlbum);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tất cả Album");
        toolbar.getNavigationIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        GetData();

    }
    private void GetData() {
        DataService dataService = APIService.getService();
        Call<List<Album>> call = dataService.getAllAlbum();
        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                List<Album> albums = response.body();
                adapter = new AllAlbumAdapter(getApplicationContext(), albums);
                recyclerViewAllAlbum.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
                recyclerViewAllAlbum.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }
}
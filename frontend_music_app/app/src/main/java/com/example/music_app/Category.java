package com.example.music_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.music_app.adapter.CategoryAdapter;
import com.example.music_app.model.Album;
import com.example.music_app.service.APIRetrofitClient;
import com.example.music_app.service.APIService;
import com.example.music_app.service.DataService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Category extends AppCompatActivity {
    private androidx.appcompat.widget.Toolbar toolbar;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        toolbar = findViewById(R.id.toolbar5);
        recyclerView = findViewById(R.id.recycleViewCategory);

        Bundle bundle = getIntent().getBundleExtra("topic");
        String topic = bundle.getString("topic");
        Long id = bundle.getLong("topicid");

        GetData(id);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(topic);
        toolbar.getNavigationIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void GetData(Long id) {
        DataService dataService = APIService.getService();
        Call<List<com.example.music_app.model.Category>> call = dataService.getCategoryByTopic(id);
        call.enqueue(new Callback<List<com.example.music_app.model.Category>>() {
            @Override
            public void onResponse(Call<List<com.example.music_app.model.Category>> call, Response<List<com.example.music_app.model.Category>> response) {
                List<com.example.music_app.model.Category> categories = response.body();
                CategoryAdapter adapter = new CategoryAdapter(getApplicationContext(), categories);
                recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<com.example.music_app.model.Category>> call, Throwable t) {
                Log.e("API ERRORRR", t.getMessage());
            }
        });
    }
}
package com.example.music_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.music_app.adapter.Song2Adapter;
import com.example.music_app.model.Song;
import com.example.music_app.service.APIService;
import com.example.music_app.service.DataService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddingSong extends AppCompatActivity {

    private ImageButton close;
    private EditText editText;
    private ListView listView;
    private Song2Adapter adapter;
    private List<Song> songs = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_song);
        close = findViewById(R.id.imageButtonAddingSongClose);
        editText = findViewById(R.id.editTextSearch);
        listView = findViewById(R.id.listViewSongAdding);


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String searchText = s.toString();
                GetData(searchText);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        GetData("");

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void GetData(String keyword) {
        DataService dataService = APIService.getService();
        Call<List<Song>> call = dataService.getSongsByKeyword(keyword);
        call.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                if(response.isSuccessful()) {
                    songs = response.body();
                    adapter = new Song2Adapter(getApplicationContext(), android.R.layout.simple_list_item_1, response.body());
                    listView.setAdapter(adapter);
                }
                else {
                    Log.e("API ERRORRRRRRR", "ccccccccccccccccc");
                }
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {
                Log.e("API ERRORRRRRRRRR", t.getMessage());
            }
        });
    }
}
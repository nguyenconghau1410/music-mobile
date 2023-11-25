package com.example.music_app.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.music_app.PlayMusic;
import com.example.music_app.R;
import com.example.music_app.adapter.Song2Adapter;
import com.example.music_app.adapter.Song5Adapter;
import com.example.music_app.model.Song;
import com.example.music_app.service.APIService;
import com.example.music_app.service.DataService;
import com.example.music_app.utils.DownloadTask;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {

    private EditText editText;
    private ListView listView;
    private View view;

    private List<Song> songs = new ArrayList<>();

    private Song5Adapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);
        editText = view.findViewById(R.id.editTextSearch1);
        listView = view.findViewById(R.id.listViewSearchFragment);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = s.toString();
                GetData(text);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        GetData("");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(getContext(), PlayMusic.class);
                Song song = songs.get(position);
                it.putExtra("song", song);
                List songList = new ArrayList();
                songList.add(song);
                it.putExtra("songList", (Serializable) songList);
                startActivity(it);
            }
        });

        return view;
    }
    private void GetData(String keyword) {
        DataService dataService = APIService.getService();
        Call<List<Song>> call = dataService.getSongsByKeyword(keyword);
        call.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                if(response.isSuccessful()) {
                    songs = response.body();
                    adapter = new Song5Adapter(getContext(), android.R.layout.simple_list_item_1, response.body());
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        DownloadTask.onRequestPermissionsResult(requestCode, permissions, grantResults, getContext());
    }
}
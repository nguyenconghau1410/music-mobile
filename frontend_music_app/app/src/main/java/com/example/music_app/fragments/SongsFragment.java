package com.example.music_app.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.music_app.R;
import com.example.music_app.adapter.SongsAdapter;
import com.example.music_app.model.Song;
import com.example.music_app.service.APIService;
import com.example.music_app.service.DataService;
import com.example.music_app.utils.Utility;
import com.example.music_app.viewmodel.FavoriteViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SongsFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private FavoriteViewModel favoriteViewModel;
    private SongsAdapter adapter;
    public static List<Song> songs = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_songs, container, false);
        recyclerView = view.findViewById(R.id.recycleViewSongs);


        Intent intent = getActivity().getIntent();
        Long categoryid = (Long) intent.getSerializableExtra("categoryid");
        if(categoryid != null) {
            GetData(categoryid, "category");
        }
        else {
            Long albumid = (Long) intent.getSerializableExtra("albumid");
            GetData(albumid, "album");
        }
        return view;
    }

    private void GetData(Long id, String text) {
        DataService dataService = APIService.getService();
        Call<List<Song>> call;
        if(text == "category") {
            call = dataService.getSongByCategory(id);
        }
        else {
            call = dataService.getSongByAlbum(id);
        }
        call.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                songs = response.body();
                adapter = new SongsAdapter(getContext(), songs);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {

            }
        });
    }
}
package com.example.music_app.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.music_app.PlayMusic;
import com.example.music_app.R;
import com.example.music_app.adapter.ExtraAdapter;
import com.example.music_app.model.Song;
import com.example.music_app.service.APIService;
import com.example.music_app.service.DataService;
import com.example.music_app.utils.Utility;
import com.google.android.material.snackbar.Snackbar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExtraFragment extends Fragment {
    private View view;
    private ListView listView;
    private ExtraAdapter adapter;

    private List<Song> list;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_extra, container, false);
        listView = view.findViewById(R.id.listViewExtra);
        GetData();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), PlayMusic.class);
                intent.putExtra("song", list.get(position));
                List<Song> songs = new ArrayList<>();
                songs.add(list.get(position));
                intent.putExtra("songList", (Serializable) songs);
                startActivity(intent);
            }
        });
        return view;
    }
    private void GetData() {
        DataService dataService = APIService.getService();
        Call<List<Song>> call = dataService.getTop7Favorite();
        call.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                list = new ArrayList<>();
                list.addAll(response.body());
                adapter = new ExtraAdapter(getContext(), android.R.layout.simple_list_item_1, response.body());
                listView.setAdapter(adapter);
                Utility.setListViewHeightBasedOnChildren(listView);
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {

            }
        });
    }
}
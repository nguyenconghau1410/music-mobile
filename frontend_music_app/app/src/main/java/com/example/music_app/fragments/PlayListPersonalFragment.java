package com.example.music_app.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.music_app.CreatingPlaylist;
import com.example.music_app.MySongPlaylist;
import com.example.music_app.R;
import com.example.music_app.adapter.PlaylistPersonalAdapter;
import com.example.music_app.model.Playlist;
import com.example.music_app.utils.Utility;
import com.example.music_app.viewmodel.PlaylistViewModel;

import java.util.ArrayList;
import java.util.List;

public class PlayListPersonalFragment extends Fragment {
    private View view;

    private ListView listView;

    private List<Playlist> list;

    private PlaylistViewModel viewModel;

    private  PlaylistPersonalAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_play_list_personal, container, false);
        listView = view.findViewById(R.id.listViewPlaylistPersonal);

        viewModel = PlaylistViewModel.getInstance(getActivity());
        viewModel.getPlaylistsLiveData().observe(getViewLifecycleOwner(), new Observer<List<Playlist>>() {
            @Override
            public void onChanged(List<Playlist> playlists) {
                adapter = new PlaylistPersonalAdapter(getContext(), android.R.layout.simple_list_item_1, playlists);
                listView.setAdapter(adapter);
                Utility.setListViewHeightBasedOnChildren(listView);
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    Intent intent = new Intent(getContext(), CreatingPlaylist.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(getContext(), MySongPlaylist.class);
                    intent.putExtra("playlist", Utility.playlists.get(position));
                    startActivity(intent);
                }
            }
        });
        return view;
    }

}
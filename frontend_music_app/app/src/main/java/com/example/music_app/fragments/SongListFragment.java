package com.example.music_app.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music_app.PlayMusic;
import com.example.music_app.R;
import com.example.music_app.adapter.Song1Apdater;
import com.example.music_app.model.Album;
import com.example.music_app.model.Category;
import com.example.music_app.service.APIService;
import com.example.music_app.service.DataService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SongListFragment extends Fragment {
    private View view;
    private TextView song, album, singer, category;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, container, false);

        recyclerView = view.findViewById(R.id.recycleViewListFragment);
        song = view.findViewById(R.id.textViewListFragmentSong);
        album = view.findViewById(R.id.textViewListFragmentAlbum);
        singer = view.findViewById(R.id.textViewListFragmentSinger);
        category = view.findViewById(R.id.textViewListFragmentCategory);

        song.setText(PlayMusic.save.getName());
        singer.setText(PlayMusic.save.getSinger());
        if(PlayMusic.save.getAlbumid() == null || PlayMusic.save.getCategoryid() == null) {
            album.setText("Unknown");
            category.setText("Unknown");
        }
        GetData1(PlayMusic.save.getAlbumid());
        GetData2(PlayMusic.save.getCategoryid());


        Song1Apdater apdater = new Song1Apdater(getContext(), PlayMusic.songs);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(apdater);

        return view;
    }

    public void setInfoSong() {
        song.setText(PlayMusic.save.getName());
        singer.setText(PlayMusic.save.getSinger());
        GetData1(PlayMusic.save.getAlbumid());
        GetData2(PlayMusic.save.getCategoryid());
    }

    public void GetData1(Long id) {
        DataService dataService = APIService.getService();
        Call<Album> call = dataService.findOneByAlbumid(id);
        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                Album album1 = response.body();
                album.setText(album1.getName());
            }

            @Override
            public void onFailure(Call<Album> call, Throwable t) {
                Log.e("API ERRORRRRRRRR", t.getMessage());
            }
        });
    }
    public void GetData2(Long id) {
        DataService dataService = APIService.getService();
        Call<Category> call = dataService.findOneByCategoryid(id);
        call.enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                Category category1 = response.body();
                category.setText(category1.getName());
            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                Log.e("API ERRORRRRRRRR", t.getMessage());
            }

        });
    }
}

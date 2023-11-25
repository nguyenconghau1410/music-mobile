package com.example.music_app.fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.music_app.R;
import com.example.music_app.Top50Playlist;
import com.example.music_app.adapter.PlaylistAdapter;
import com.example.music_app.model.Playlist;
import com.example.music_app.model_spotify.PlaylistSpotify;
import com.example.music_app.model_spotify.Token;
import com.example.music_app.service.APISpotifyService;
import com.example.music_app.service.DataService;
import com.example.music_app.utils.Utility;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import okhttp3.Credentials;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlaylistFragment extends Fragment {

    private View view;

    private ListView listView;
    private TextView title, more;
    private PlaylistAdapter playlistAdapter;
    private String token;
    List<Playlist> playlists = new ArrayList<>();
    List<PlaylistSpotify> playlistSpotifies = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_playlist, container, false);
        listView = view.findViewById(R.id.listViewPlaylist);
        title = view.findViewById(R.id.textViewPlaylist);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), Top50Playlist.class);
                intent.putExtra("spotify", (Serializable) playlistSpotifies.get(position));
                startActivity(intent);
            }
        });

        GetData();
        return view;
    }

    private void GetData() {
        DataService dataService = APISpotifyService.getAuthenticate();
        String credentials = Credentials.basic(Utility.ClientID, Utility.ClientSecret);
        Call<Token> call = dataService.getAccessToken(credentials, "client_credentials");
        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                token = response.body().getAccess_token();
                Log.e("access_token", token);
                String[] ids = {"37i9dQZF1DX3e9b2XMiQ6I", "37i9dQZEVXbLdGSmz6xilI", "37i9dQZEVXbMDoHDwVN2tF",
                                "37i9dQZF1DX0F4i7Q9pshJ", "37i9dQZF1DX5HzXEElAlcz", "37i9dQZF1DWT2oR9BciC32"};
                int x = -1, y = -1;
                int cnt = 0;
                while (true){
                    Random random = new Random();
                    int rand = random.nextInt(6);
                    if(x == -1) {
                        x = rand;
                        ++cnt;
                        GetData1(ids[x]);
                    }
                    else {
                        if(x != rand && y == -1) {
                            y = rand;
                            GetData1(ids[y]);
                            ++cnt;
                        }
                        else if(x != y && y != rand && y != -1) {
                            GetData1(ids[rand]);
                            ++cnt;
                        }
                    }
                    if(cnt == 3) break;
                }
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Log.e("API ERRORRRRRRRRRRR", t.getMessage());
            }
        });
    }
    private void GetData1(String id) {
        DataService dataService = APISpotifyService.getService();
        Call<PlaylistSpotify> call = dataService.getPlaylistSpotify("Bearer " + token, id);
        call.enqueue(new Callback<PlaylistSpotify>() {
            @Override
            public void onResponse(Call<PlaylistSpotify> call, Response<PlaylistSpotify> response) {
                if(response.isSuccessful()) {
                    playlistSpotifies.add(response.body());
                    Playlist playlist = new Playlist();
                    playlist.setName(response.body().getName());
                    playlist.setImage(response.body().getImages().get(0).getUrl());
                    playlist.setDescription(response.body().getDescription());
                    playlists.add(playlist);
                    Log.e("top 50", playlists.size() + "");
                    if(playlists.size() == 3) {
                        playlistAdapter = new PlaylistAdapter(getContext(), android.R.layout.simple_list_item_1, playlists);
                        listView.setAdapter(playlistAdapter);
                        Utility.setListViewHeightBasedOnChildren(listView);
                    }
                }
                else {
                    Log.e("top 50", response.code() + "    " + response.message());
                }
            }

            @Override
            public void onFailure(Call<PlaylistSpotify> call, Throwable t) {
                Log.e("API ERRORRRR", t.getMessage());
            }
        });
    }

}
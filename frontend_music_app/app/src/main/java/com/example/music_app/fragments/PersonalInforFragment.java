package com.example.music_app.fragments;

import static android.content.Intent.getIntent;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.music_app.DownloadSong;
import com.example.music_app.FavoriteList;
import com.example.music_app.R;
import com.example.music_app.model.User;
import com.example.music_app.utils.Utility;

public class PersonalInforFragment extends Fragment {
    private View view;
    private androidx.appcompat.widget.Toolbar toolbar;
    private CardView favorite, download;
    private TextView textEmail, textName;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_personal_infor, container, false);
        toolbar = view.findViewById(R.id.toolbar4);
        textEmail = view.findViewById(R.id.textViewPersonalEmail);
        textName = view.findViewById(R.id.textViewPersonalName);
        favorite = view.findViewById(R.id.cardViewFavorite);
        download = view.findViewById(R.id.cardViewDownload);

        Intent intent = getActivity().getIntent();
        if(intent != null) {
            User user = (User) intent.getSerializableExtra("myUser");
            Utility.favoriteSong = user.getSongs();
            Utility.userid = user.getUserid();
            Utility.playlists = user.getPlaylists();
            textEmail.setText(user.getEmail());
            textName.setText(user.getName());
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getContext(), FavoriteList.class);
                startActivity(intent1);
            }
        });
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getContext(), DownloadSong.class);
                startActivity(intent1);
            }
        });

        return view;
    }

}
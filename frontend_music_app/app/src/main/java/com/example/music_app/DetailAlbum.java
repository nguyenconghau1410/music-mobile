package com.example.music_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.music_app.fragments.SongsFragment;
import com.example.music_app.model.Album;
import com.example.music_app.model.Song;
import com.example.music_app.viewmodel.FavoriteViewModel;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

public class DetailAlbum extends AppCompatActivity {
    private ImageView background, back;
    private TextView name, singer;
    private CardView play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_album);

        init();


        Album album = (Album) getIntent().getSerializableExtra("item");
        name.setText(album.getName());
        singer.setText(album.getSinger());
        if(album.getImage() != null)
            Picasso.with(getApplicationContext()).load(album.getImage()).into(background);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PlayMusic.class);
                intent.putExtra("songList", (Serializable) SongsFragment.songs);
                intent.putExtra("song", SongsFragment.songs.get(0));
                intent.putExtra("image", album.getImage());
                startActivity(intent);
            }
        });


    }

    public void init() {
        background = findViewById(R.id.imageViewDetailAlbum);
        back = findViewById(R.id.imageViewDetailAlbumBack);
        name = findViewById(R.id.textViewDetailAlbumSong);
        singer = findViewById(R.id.textViewDetailAlbumSinger);
        play = findViewById(R.id.cardViewDetailAlbum);
    }
}
package com.example.music_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.music_app.R;
import com.example.music_app.adapter.SongsAdapter;
import com.example.music_app.fragments.SongsFragment;
import com.example.music_app.model.Song;
import com.example.music_app.service.APIService;
import com.example.music_app.service.DataService;
import com.example.music_app.utils.Utility;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlaylistCategory extends AppCompatActivity {
    private ImageView imageView, back;
    private TextView textView;
    private CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_category);
        init();

        com.example.music_app.model.Category category = (com.example.music_app.model.Category) getIntent().getSerializableExtra("category");

        if(category.getImage() != null)
            Picasso.with(getApplicationContext()).load(category.getImage()).into(imageView);
        textView.setText(category.getName());

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PlayMusic.class);
                intent.putExtra("songList", (Serializable) Utility.favoriteSong);
                intent.putExtra("song", Utility.favoriteSong.get(0));
                startActivity(intent);
            }
        });
    }
    private void init() {
        imageView = findViewById(R.id.imageViewPlaylistCategory);
        back = findViewById(R.id.imageViewPlaylistCategoryBack);
        textView = findViewById(R.id.textViewPlaylistCategoryTitle);
        cardView = findViewById(R.id.cardViewPlaylistCategory);
    }

}
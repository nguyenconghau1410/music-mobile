package com.example.music_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.music_app.adapter.PlaylistPersonalAdapter;
import com.example.music_app.fragments.PersonalFragment;
import com.example.music_app.fragments.PersonalInforFragment;
import com.example.music_app.fragments.PlayListPersonalFragment;
import com.example.music_app.model.Playlist;
import com.example.music_app.service.APIService;
import com.example.music_app.service.DataService;
import com.example.music_app.utils.Utility;
import com.example.music_app.viewmodel.PlaylistViewModel;

import java.security.Provider;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreatingPlaylist extends AppCompatActivity {

    private ImageButton imageButton;
    private EditText editText;
    private CardView cardView;
    private PlaylistViewModel playlistViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creating_playlist);

        imageButton = findViewById(R.id.imageButtonClose);
        editText = findViewById(R.id.editTextPlaylist);
        cardView = findViewById(R.id.cardViewCreatingPlaylist);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString() == "") {
                    Toast.makeText(getApplicationContext(), "Hãy nhập tên playlist", Toast.LENGTH_SHORT).show();
                }
                else {
                    Playlist playlist = new Playlist();
                    playlist.setName(editText.getText().toString());
                    GetData(Utility.userid, playlist);
                }
            }
        });
    }

    private void GetData(Long id, Playlist playlist) {
        DataService dataService = APIService.getService();
        Call<Playlist> call = dataService.insertPlaylist(id, playlist);
        call.enqueue(new Callback<Playlist>() {
            @Override
            public void onResponse(Call<Playlist> call, Response<Playlist> response) {
                if(response.isSuccessful()) {
                    PlaylistViewModel.addPlaylist(response.body());
                    Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            finish();
                        }
                    }, 1000);
                }
            }

            @Override
            public void onFailure(Call<Playlist> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Không có kết nối internet", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
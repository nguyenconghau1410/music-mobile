package com.example.music_app.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.music_app.AllAlbum;
import com.example.music_app.DetailAlbum;
import com.example.music_app.R;
import com.example.music_app.model.Album;
import com.example.music_app.model.Topic;
import com.example.music_app.service.APIService;
import com.example.music_app.service.DataService;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumFragment extends Fragment {
    private View view;
    private HorizontalScrollView horizontalScrollView;
    private TextView viewMore;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_album, container, false);
        horizontalScrollView = view.findViewById(R.id.horizontalScrollViewAlbum);
        viewMore = view.findViewById(R.id.textViewAlbumMore);

        GetData();
        viewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AllAlbum.class);
                startActivity(intent);
            }
        });
        return view;
    }
    private void GetData() {
        DataService dataService = APIService.getService();
        Call<List<Album>> call = dataService.getAllAlbum();
        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                if(response.isSuccessful()) {
                    List<Album> albums = response.body();
                    LinearLayout linearLayout = new LinearLayout(getContext());
                    linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                    LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(410, 510);
                    layout.setMargins(10, 20, 20, 30);
                    for(int i = albums.size() - 1; i >= albums.size() - 7 && i >= 0; i--) {
                        Album album = albums.get(i);
                        CardView cardView = new CardView(getContext());
                        cardView.setRadius(10);
                        LinearLayout childLayout = new LinearLayout(getContext());
                        childLayout.setOrientation(LinearLayout.VERTICAL);

                        LinearLayout.LayoutParams imageParam = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                380
                        );
                        imageParam.setMargins(8, 8, 8, 5);
                        ImageView imageView = new ImageView(getContext());
                        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        imageView.setLayoutParams(imageParam);
                        if(album.getImage() != null) {
                            Picasso.with(getActivity()).load(album.getImage()).into(imageView);
                        }

                        LinearLayout.LayoutParams textParam = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.WRAP_CONTENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT
                        );
                        textParam.setMargins(8, 4, 0, 5);
                        TextView textView = new TextView(getContext());
                        textView.setText(album.getName());
                        textView.setMaxLines(1);
                        textView.setEllipsize(TextUtils.TruncateAt.END);
                        textView.setTextSize(18);
                        textView.setTextColor(Color.BLACK);
                        textView.setLayoutParams(textParam);

                        TextView textView1 = new TextView(getContext());
                        textView1.setText(album.getSinger());
                        textView1.setMaxLines(1);
                        textView1.setEllipsize(TextUtils.TruncateAt.END);
                        textView1.setTextSize(14);
                        textView1.setTextColor(Color.GRAY);
                        textView1.setLayoutParams(textParam);

                        childLayout.addView(imageView);
                        childLayout.addView(textView);
                        childLayout.addView(textView1);

                        cardView.setLayoutParams(layout);
                        cardView.addView(childLayout);
                        cardView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(getContext(), DetailAlbum.class);
                                intent.putExtra("item", album);
                                intent.putExtra("albumid", album.getAlbumid());
                                startActivity(intent);
                            }
                        });
                        linearLayout.addView(cardView);
                    }
                    horizontalScrollView.addView(linearLayout);
                }
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                Log.e("API ERROR", "ccccccccccccccccccccc");
            }
        });
    }
}
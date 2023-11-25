package com.example.music_app.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.music_app.DetailAlbum;
import com.example.music_app.R;
import com.example.music_app.model.Advertisement;
import com.example.music_app.model.Album;
import com.example.music_app.model.Song;
import com.example.music_app.service.APIService;
import com.example.music_app.service.DataService;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BannerAdapter extends PagerAdapter {

    private Context context;
    private List<Advertisement> advertisementList;
    private Album album;
    public BannerAdapter(Context context, List<Advertisement> advertisementList) {
        this.context = context;
        this.advertisementList = advertisementList;
    }

    @Override
    public int getCount() {
        return advertisementList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.banner, null);

        ImageView imgBackgroundBanner = view.findViewById(R.id.imageViewBackgroundBanner);
        ImageView imgSongBanner = view.findViewById(R.id.imageViewBanner);
        TextView title = view.findViewById(R.id.titleBanner);
        TextView content = view.findViewById(R.id.contentBanner);

        Advertisement advertisement = advertisementList.get(position);
        DataService dataService = APIService.getService();
        album = new Album();
        Call<Album> call = dataService.findOneByAlbumid(advertisement.getSongid());
        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                album = response.body();
                title.setText(response.body().getName());
                if(response.body().getImage() != null)
                    Picasso.with(context).load(response.body().getImage()).into(imgBackgroundBanner);
            }

            @Override
            public void onFailure(Call<Album> call, Throwable t) {

            }
        });
        if(advertisement.getImage() != null)
            Picasso.with(context).load(advertisement.getImage()).into(imgSongBanner);
        content.setText(advertisement.getContent());
        container.addView(view);
        imgBackgroundBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailAlbum.class);
                intent.putExtra("item", album);
                intent.putExtra("albumid", album.getAlbumid());
                if(context instanceof Activity) {
                    ((Activity) context).startActivity(intent);
                }
                else {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            }
        });
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

}

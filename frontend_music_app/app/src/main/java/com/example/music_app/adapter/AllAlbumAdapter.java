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
import androidx.recyclerview.widget.RecyclerView;

import com.example.music_app.DetailAlbum;
import com.example.music_app.R;
import com.example.music_app.model.Album;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AllAlbumAdapter extends RecyclerView.Adapter<AllAlbumAdapter.ViewHolder> {

    private Context context;
    private List<Album> albums;
    public AllAlbumAdapter(Context context, List<Album> albums) {
        this.context = context;
        this.albums = albums;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.all_album, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album = albums.get(position);
        if(album.getImage() != null)
            Picasso.with(context).load(album.getImage()).into(holder.imageView);
        holder.name.setText(album.getName());
        holder.singer.setText(album.getSinger());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailAlbum.class);
                intent.putExtra("item", album);
                intent.putExtra("albumid", album.getAlbumid());
                if(context instanceof Activity) {
                    ((Activity)context).startActivity(intent);
                }
                else {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name, singer;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewAllAlbumImg);
            name = itemView.findViewById(R.id.textViewAllAlbumName);
            singer = itemView.findViewById(R.id.textViewAllAlbumSinger);
        }
    }
}

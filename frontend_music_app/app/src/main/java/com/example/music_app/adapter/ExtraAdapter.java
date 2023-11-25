package com.example.music_app.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.music_app.R;
import com.example.music_app.model.Song;
import com.example.music_app.utils.Utility;

import java.util.List;

public class ExtraAdapter extends ArrayAdapter<Song> {

    public ExtraAdapter(@NonNull Context context, int resource, @NonNull List<Song> objects) {
        super(context, resource, objects);
    }

    class ViewHolder {
        ImageView icon;
        TextView stt, name, singer;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.song, null);
            viewHolder = new ViewHolder();
            viewHolder.stt = convertView.findViewById(R.id.textViewSTT);
            viewHolder.name = convertView.findViewById(R.id.textViewNameSong);
            viewHolder.singer = convertView.findViewById(R.id.textViewSinger);
            viewHolder.icon = convertView.findViewById(R.id.imageViewFavoriteSong);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Song song = getItem(position);
        viewHolder.stt.setText(position + 1 + "");
        viewHolder.name.setText(song.getName());
        viewHolder.singer.setText(song.getSinger());

        boolean check = false;
        for(Song song1 : Utility.favoriteSong) {
            if(song1.getSongid().equals(song.getSongid())) {
                viewHolder.icon.setImageResource(R.drawable.baseline_favorite_24_true);
                break;
            }
        }

        ViewHolder finalViewHolder = viewHolder;
        viewHolder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = false;
                for(Song song1 : Utility.favoriteSong) {
                    if(song1.getSongid().equals(song.getSongid())) {
                        Toast.makeText(getContext(), "Bạn đã thích bài hát này!", Toast.LENGTH_SHORT).show();
                        check = true;
                        break;
                    }
                }
                if(!check) {
                    Utility.insertFavorite(Utility.userid, song, getContext());
                    Utility.favoriteSong.add(song);
                    Toast.makeText(getContext(), "Đã thích", Toast.LENGTH_SHORT).show();
                    finalViewHolder.icon.setImageResource(R.drawable.baseline_favorite_24_true);
                }
            }
        });
        return convertView;
    }
}

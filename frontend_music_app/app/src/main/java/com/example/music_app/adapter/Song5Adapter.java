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

import com.example.music_app.DownloadSong;
import com.example.music_app.R;
import com.example.music_app.model.Song;
import com.example.music_app.utils.DownloadTask;

import java.util.List;

public class Song5Adapter extends ArrayAdapter<Song> {

    public Song5Adapter(@NonNull Context context, int resource, @NonNull List<Song> objects) {
        super(context, resource, objects);
    }

    class ViewHolder {
        ImageView background, download;
        TextView name, singer;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.song5, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.background = convertView.findViewById(R.id.imageViewBackgroundSearch);
            viewHolder.download = convertView.findViewById(R.id.imageViewDownload);
            viewHolder.name = convertView.findViewById(R.id.textViewNameSongSearch);
            viewHolder.singer = convertView.findViewById(R.id.textViewSingerSearch);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Song song = getItem(position);

        viewHolder.background.setImageResource(R.drawable.zing1);
        viewHolder.name.setText(song.getName());
        viewHolder.singer.setText(song.getSinger());

        viewHolder.download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadTask.startDownloading(getContext(), song.getLink(), song.getName() + " - " + song.getSinger());
                Toast.makeText(getContext(), "Downloading", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

}


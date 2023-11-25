package com.example.music_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.music_app.R;
import com.example.music_app.model.Playlist;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlaylistAdapter extends ArrayAdapter<Playlist> {

    public PlaylistAdapter(@NonNull Context context, int resource, @NonNull List<Playlist> objects) {
        super(context, resource, objects);
    }
    class ViewHolder {
        TextView title, description;
        ImageView background, playlist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.playlist, null);
            viewHolder = new ViewHolder();
            viewHolder.title = convertView.findViewById(R.id.textViewNamePlaylist);
            viewHolder.background = convertView.findViewById(R.id.imageViewBackgroundPlaylist);
            viewHolder.playlist = convertView.findViewById(R.id.imageViewPlaylist);
            viewHolder.description = convertView.findViewById(R.id.textViewDescriptionPlaylist);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Playlist playlist = getItem(position);
        viewHolder.title.setText(playlist.getName());
        if(playlist.getImage() != null) {
            Picasso.with(getContext()).load(playlist.getImage()).into(viewHolder.playlist);
            Picasso.with(getContext()).load(playlist.getImage()).into(viewHolder.background);
        }
        viewHolder.description.setText(playlist.getDescription());
        return convertView;
    }
}

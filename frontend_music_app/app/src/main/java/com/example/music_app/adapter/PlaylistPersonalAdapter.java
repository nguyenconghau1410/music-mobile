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

public class PlaylistPersonalAdapter extends ArrayAdapter<Playlist> {

    public PlaylistPersonalAdapter(@NonNull Context context, int resource, @NonNull List<Playlist> objects) {
        super(context, resource, objects);
    }

    class ViewHolder {
        TextView textView;
        ImageView imageView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.playlist1, null);
            viewHolder = new ViewHolder();
            viewHolder.textView = convertView.findViewById(R.id.textViewItemPersonal);
            viewHolder.imageView = convertView.findViewById(R.id.imageViewItemPersonal);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Playlist playlist = getItem(position);

        viewHolder.textView.setText(playlist.getName());
        if(position == 0) {
            viewHolder.imageView.setImageResource(R.drawable.addbox);
        }
        else {
            viewHolder.imageView.setImageResource(R.drawable.playlist);
        }

        return convertView;
    }
}

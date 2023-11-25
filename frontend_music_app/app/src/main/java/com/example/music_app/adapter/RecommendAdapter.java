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

import java.util.List;

public class RecommendAdapter extends ArrayAdapter<String> {

    public RecommendAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
    }
    class ViewHolder {
        ImageView imageViewImage;
        TextView textViewExtraTitle, textViewExtraName;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.extra1, null);
            viewHolder = new ViewHolder();
            viewHolder.imageViewImage = convertView.findViewById(R.id.imageViewItemExtra1);
            viewHolder.textViewExtraTitle = convertView.findViewById(R.id.textViewExtraTitle1);
            viewHolder.textViewExtraName = convertView.findViewById(R.id.textViewExtraName1);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }
}

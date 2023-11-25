package com.example.music_app.adapter;


import static java.security.AccessController.getContext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.music_app.R;

public class PersonalAdapter extends BaseAdapter {
    Context context;

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    class ViewHolder {
        TextView email, name;
        ImageView imgProfile;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.fragment_personal_infor, null);
            viewHolder.email = convertView.findViewById(R.id.textViewPersonalEmail);
            viewHolder.name = convertView.findViewById(R.id.textViewPersonalName);
            viewHolder.imgProfile = convertView.findViewById(R.id.imageViewPersonal);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }
}

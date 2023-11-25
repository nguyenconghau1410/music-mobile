package com.example.music_app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.music_app.R;
import com.example.music_app.adapter.RecommendAdapter;
import com.example.music_app.utils.Utility;

import java.util.ArrayList;
import java.util.List;

public class RecommendFragment extends Fragment {
    private View view;
    private ListView listView;

    private List<String> list;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_recommend, container, false);
        listView = view.findViewById(R.id.listViewRecommended);
        list = new ArrayList<>();
        list.add("ccc");
        list.add("dsads");
        RecommendAdapter recommendAdapter = new RecommendAdapter(getContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(recommendAdapter);
        Utility.setListViewHeightBasedOnChildren(listView);
        return view;
    }
}
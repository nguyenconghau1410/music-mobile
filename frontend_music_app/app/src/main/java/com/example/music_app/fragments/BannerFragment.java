package com.example.music_app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

import com.example.music_app.R;
import com.example.music_app.adapter.BannerAdapter;
import com.example.music_app.model.Advertisement;
import com.example.music_app.service.APIService;
import com.example.music_app.service.DataService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BannerFragment extends Fragment {

    private View view;
    private ViewPager viewPager;

    private BannerAdapter bannerAdapter;
    private Handler handler;
    private Runnable runnable;
    int currentItem;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_banner, container, false);
        viewPager = view.findViewById(R.id.viewPagerBanner);
        DataService dataService = APIService.getService();
        Call<List<Advertisement>> call = dataService.findAll();
        call.enqueue(new Callback<List<Advertisement>>() {
            @Override
            public void onResponse(Call<List<Advertisement>> call, Response<List<Advertisement>> response) {
                List<Advertisement> advertisementList = response.body();
                bannerAdapter = new BannerAdapter(getActivity(), advertisementList);
                viewPager.setAdapter(bannerAdapter);

                handler = new Handler();
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        currentItem = viewPager.getCurrentItem();
                        currentItem++;
                        if(currentItem >= viewPager.getAdapter().getCount()) {
                            currentItem = 0;
                        }
                        viewPager.setCurrentItem(currentItem, true);
                        handler.postDelayed(runnable, 4500);
                    }
                };
                handler.postDelayed(runnable, 4500);
            }

            @Override
            public void onFailure(Call<List<Advertisement>> call, Throwable t) {

            }
        });

        return view;
    }

}
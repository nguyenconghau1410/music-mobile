package com.example.music_app.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.music_app.fragments.HomepageFragment;
import com.example.music_app.fragments.PersonalFragment;
import com.example.music_app.fragments.SearchFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1:
                return new HomepageFragment();
            case 2:
                return new SearchFragment();
            default:
                return new PersonalFragment();

        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}

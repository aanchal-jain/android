package com.aanchal.godric.tabbedapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        DemoFragment fragment = new DemoFragment();
        i=i+1;
        Bundle bundle = new Bundle();
        bundle.putString("msg","Fragment "+i);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String[] titles = {"Home","Dashboard","Notifications"};
        return titles[position];
    }
}

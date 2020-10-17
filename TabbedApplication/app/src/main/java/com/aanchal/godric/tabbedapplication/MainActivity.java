package com.aanchal.godric.tabbedapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager pager;
    private ViewPagerAdapter adapter;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        setSupportActionBar(toolbar);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

        tabLayout.setupWithViewPager(pager);

    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        pager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tab_layout);
    }
}

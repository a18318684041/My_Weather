package com.example.administrator.my_weather;

import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeRefreshLayout;
    private BottomNavigationView bottom;
    private ViewPager vp;
    private List<Fragment> fragments;
    private FragmentAdpter adpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottom = (BottomNavigationView) findViewById(R.id.bottom);
        vp = (ViewPager) findViewById(R.id.vp);
        fragments =  new ArrayList<>();
        fragments.add(new tab1());
        fragments.add(new tab2());
        fragments.add(new tab3());
        fragments.add(new tab4());
        adpter = new FragmentAdpter(getSupportFragmentManager(),fragments);
        bottom.setBackgroundColor(Color.LTGRAY);
        vp.setAdapter(adpter);
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                for (int i = 0;i<3;i++){
                    if(i!=position){
                        bottom.getMenu().getItem(i).setChecked(false);
                    }else {
                        bottom.getMenu().getItem(i).setChecked(true);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        vp.setCurrentItem(0);
                        bottom.setBackgroundColor(Color.LTGRAY);
                        break;
                    case R.id.service:
                        vp.setCurrentItem(1);
                        bottom.setBackgroundColor(Color.parseColor("#33ff0000"));
                        break;
                    case R.id.message:
                        vp.setCurrentItem(2);
                        bottom.setBackgroundColor(Color.CYAN);
                        break;
                    case R.id.personal:
                        vp.setCurrentItem(3);
                        bottom.setBackgroundColor(Color.GRAY);
                        break;
                }
                return false;
            }
        });
    }

}

package com.example.administrator.my_weather;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.powyin.scroll.widget.ISwipe;
import com.powyin.scroll.widget.SwipeRefresh;


public class tab2 extends Fragment {
    //自定义实现下拉刷新
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.tab2, container, false);
        final SwipeRefresh swipeRefresh = (SwipeRefresh) view.findViewById(R.id.SwipeRefresh);
        swipeRefresh.setOnRefreshListener(new ISwipe.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefresh.setFreshStatue(ISwipe.FreshStatus.SUCCESS);
                        Toast.makeText(view.getContext(), "刷新完成", Toast.LENGTH_LONG).show();
                    }
                }, 6000);
            }

            @Override
            public void onLoading(boolean isLoadViewShow) {

            }
        });
        return view;
    }
}

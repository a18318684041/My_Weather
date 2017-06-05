package com.example.administrator.my_weather;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;


public class tab3 extends Fragment {
    //实现魅族轮播图
    MZBannerView mzBannerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.tab3, container, false);
        List<Integer> img = new ArrayList<>();
        img.add(R.drawable.t8);
        img.add(R.drawable.t9);
        img.add(R.drawable.t10);
        img.add(R.drawable.t11);

         mzBannerView = (MZBannerView) view.findViewById(R.id.banner);
        mzBannerView.setPages(img, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mzBannerView.start();//开始轮播
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

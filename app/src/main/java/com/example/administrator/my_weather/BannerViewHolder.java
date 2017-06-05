package com.example.administrator.my_weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.zhouwei.mzbanner.holder.MZViewHolder;

/**
 * Created by Administrator on 2017/6/4 0004.
 */
public class BannerViewHolder implements MZViewHolder<Integer> {

        private ImageView mImageView;
        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item,null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }
    @Override
    public void onBind(Context context, int i, Integer data) {
        mImageView.setImageResource(data);
    }
}

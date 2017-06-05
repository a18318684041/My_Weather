package com.example.administrator.my_weather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Request;


public class tab4 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.tab4, container, false);
        Button btn = (Button) view.findViewById(R.id.btn);
        final TextView tv = (TextView) view.findViewById(R.id.tv);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://free-api.heweather.com/v5/weather?city=guangzhou&key="+"3b8db1ea026e496ca02ef804a7dfe39a";
                OkHttpUtils
                        .get()
                        .url(url)
                        .build()
                        .execute(new StringCallback()
                        {
                            @Override
                            public void onError(Call call, Exception e, int id) {
                                Toast.makeText(view.getContext(),"请求失败",Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onResponse(String response, int id) {
                                String res = response.toString();
                                Gson gson = new Gson();
                                data d = gson.fromJson(res.trim(), data.class);
                                String result = "";
                                for (int i = 0 ;i<d.getHeWeather5().size();i++){
                                     result += d.getHeWeather5().get(i).getNow().getCond().getTxt()+"\n";
                                }
                                tv.setText("广州:"+result);
                            }
                        });
            }
        });
        return view;
    }
}

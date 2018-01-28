package com.example.hello.myapplicationmvp.model;

import com.example.hello.myapplicationmvp.presenter.Denglup_i;
import com.example.hello.myapplicationmvp.util.OkHttp3Util;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static com.example.hello.myapplicationmvp.util.API.denglu_api;

/**
 * Created by 韦作铭 on 2018/1/12.
 */

public class Denglu_m {

    private Denglup_i denglup_i;

    public Denglu_m(Denglup_i denglup_i) {
        this.denglup_i=denglup_i;
    }

    public void getdata(String dengluApi, String name, String password) {
        HashMap<String,String> map=new HashMap<>();
        map.put("mobile",name);
        map.put("password",password);
        OkHttp3Util.doPost(denglu_api, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    String s = response.body().string();
                    denglup_i.success(s);
                }
            }
        });
    }
}

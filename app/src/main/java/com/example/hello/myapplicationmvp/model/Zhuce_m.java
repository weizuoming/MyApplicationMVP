package com.example.hello.myapplicationmvp.model;

import com.example.hello.myapplicationmvp.presenter.ZhuceP_I;
import com.example.hello.myapplicationmvp.util.OkHttp3Util;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static com.example.hello.myapplicationmvp.util.API.zhuce_api;

/**
 * Created by 韦作铭 on 2018/1/11.
 */

public class Zhuce_m {

    private ZhuceP_I zhuceP_i;

    public Zhuce_m(ZhuceP_I zhuceP_i) {
        this.zhuceP_i = zhuceP_i;
    }

    public void getdata(String zhuceApi, String name, String password) {

        HashMap<String, String> map = new HashMap<>();
        map.put("mobile", name);
        map.put("password", password);
        OkHttp3Util.doPost(zhuce_api, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String string = response.body().string();
                    //获取到数据之后回传给 P层
                    zhuceP_i.success(string);
                }
            }
        });
    }
}

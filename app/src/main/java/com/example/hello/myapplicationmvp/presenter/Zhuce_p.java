package com.example.hello.myapplicationmvp.presenter;

import com.example.hello.myapplicationmvp.model.Zhuce_m;
import com.example.hello.myapplicationmvp.view.ZhuceV_I;

import static com.example.hello.myapplicationmvp.util.API.zhuce_api;

/**
 * Created by 韦作铭 on 2018/1/11.
 */

public class Zhuce_p implements ZhuceP_I {

    private final Zhuce_m zhuce_p;
    private ZhuceV_I zhuceV_i;

    public Zhuce_p(ZhuceV_I zhuceV_i) {
        this.zhuceV_i = zhuceV_i;
        zhuce_p = new Zhuce_m(this);
    }

    public void getdata(String zhuceApi, String name, String password) {
        zhuce_p.getdata(zhuce_api, name, password);
    }

    @Override
    public void success(String s) {
        zhuceV_i.success(s);
    }
}

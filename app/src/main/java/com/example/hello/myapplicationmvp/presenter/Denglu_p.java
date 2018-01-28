package com.example.hello.myapplicationmvp.presenter;

import com.example.hello.myapplicationmvp.model.Denglu_m;
import com.example.hello.myapplicationmvp.view.DengluV_i;

import static com.example.hello.myapplicationmvp.util.API.denglu_api;

/**
 * Created by 韦作铭 on 2018/1/12.
 */

public class Denglu_p implements Denglup_i{

    private final Denglu_m denglu_m;
    private DengluV_i dengluV_i;

    public Denglu_p(DengluV_i dengluV_i) {
        this.dengluV_i=dengluV_i;
        denglu_m = new Denglu_m(this);
    }




    public void getdeat(String dengluApi, String name, String password) {
        denglu_m.getdata(denglu_api,name,password);
    }

    @Override
    public void success(String s) {
        dengluV_i.success(s);
    }
}

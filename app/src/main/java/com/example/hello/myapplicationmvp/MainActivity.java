package com.example.hello.myapplicationmvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hello.myapplicationmvp.model.Deng_bean;
import com.example.hello.myapplicationmvp.presenter.Denglu_p;
import com.example.hello.myapplicationmvp.util.API;
import com.example.hello.myapplicationmvp.view.DengluV_i;
import com.example.hello.myapplicationmvp.view.Main2Activity;
import com.example.hello.myapplicationmvp.view.Main3Activity;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements DengluV_i {

    private EditText pas;
    private EditText ph;
    private Button ligon;
    private Button reg;
    private Denglu_p denglu_p;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ph = (EditText) findViewById(R.id.phone);
        pas = (EditText) findViewById(R.id.password);
        ligon = (Button) findViewById(R.id.ligon);
        reg = (Button) findViewById(R.id.reg);
        denglu_p = new Denglu_p(this);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(in);
            }
        });
        ligon.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                String name = ph.getText().toString();
                String password = pas.getText().toString();

                denglu_p.getdeat(API.denglu_api, name, password);

            }
        });
    }

    @Override
    public void success(String s) {
        Gson g = new Gson();
        Deng_bean deng_bean = g.fromJson(s, Deng_bean.class);
        msg = deng_bean.getMsg();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                if (msg.equals("登录注册")) {
                    Intent in = new Intent(MainActivity.this, Main3Activity.class);
                    startActivity(in);
                }

            }
        });
    }

    @Override
    public void jumpactivity() {


    }


}

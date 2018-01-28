package com.example.hello.myapplicationmvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hello.myapplicationmvp.R;
import com.example.hello.myapplicationmvp.model.Zhuce_bean;
import com.example.hello.myapplicationmvp.presenter.Zhuce_p;
import com.example.hello.myapplicationmvp.util.API;
import com.google.gson.Gson;

public class Main2Activity extends AppCompatActivity implements ZhuceV_I {
    private EditText pas;
    private EditText ph;
    private Button reg;

    private Zhuce_p zhuce_p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ph = (EditText) findViewById(R.id.phone);
        pas = (EditText) findViewById(R.id.password);
        reg = (Button) findViewById(R.id.reg);

        zhuce_p = new Zhuce_p(this);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ph.getText().toString();
                String password = pas.getText().toString();

                zhuce_p.getdata(API.zhuce_api, name, password);

            }
        });

    }

    @Override
    public void success(String s) {

          Gson gson = new Gson();
        Zhuce_bean zhuce_bean = gson.fromJson(s, Zhuce_bean.class);
        final String msg = zhuce_bean.getMsg();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(Main2Activity.this,msg,Toast.LENGTH_SHORT).show();
            }
        });

    }
}

package com.example.fancx.day08_service_demo.demo01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.fancx.day08_service_demo.R;

public class ServiceActivity01 extends AppCompatActivity {

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service01);

        intent = new Intent(this,MyService01.class);
    }

    //启动服务
    public void start(View view) {
        startService(intent);
    }

    //停止服务
    public void stop(View view) {
        stopService(intent);
    }
}

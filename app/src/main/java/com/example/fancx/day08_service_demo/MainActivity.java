package com.example.fancx.day08_service_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.fancx.day08_service_demo.demo01.ServiceActivity01;
import com.example.fancx.day08_service_demo.demo02.ServiceActivity02;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.but_01:
                //启动服务的页面
                startActivity(new Intent(this,ServiceActivity01.class));
                break;
            case R.id.but_02:
                startActivity(new Intent(this,ServiceActivity02.class));
                break;
        }
    }
}

package com.example.fancx.day08_service_demo.demo02;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.fancx.day08_service_demo.R;

public class ServiceActivity02 extends AppCompatActivity {

    //声明绑定服务后, 返回的数据接口
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // 服务绑定成功的回调方法
            MyService02.MyBind myBind = (MyService02.MyBind) service;
            int count = myBind.getCount();
            Toast.makeText(ServiceActivity02.this, "获取服务返回的数据: " + count, Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {}
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service02);
    }

    public void bind(View view) {
        //Intent 意图对象,  接口 绑定服务的返回结果 -- 实现类, 标记  BIND_AUTO_CREATE(绑定后,立即创建服务)
        Intent intent = new Intent(this,MyService02.class);
        bindService(intent,connection,BIND_AUTO_CREATE);
    }

    public void unbind(View view) {
        unbindService(connection);
    }
}

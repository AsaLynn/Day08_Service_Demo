package com.example.fancx.day08_service_demo.demo01;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService01 extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG","---onCreate---");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("TAG","---onStartCommand---");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e("TAG","---onDestroy---");
        super.onDestroy();
    }

    //TODO 必须要重写的方法
    @Override
    public IBinder onBind(Intent intent) {
       return  null;
    }
}

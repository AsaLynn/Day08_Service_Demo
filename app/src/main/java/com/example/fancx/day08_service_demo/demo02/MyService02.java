package com.example.fancx.day08_service_demo.demo02;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;


public class MyService02 extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG","-----onCreate----");
    }

   //定义一个内部类, 继承Binder
    class  MyBind extends Binder
   {
       public int getCount()
       {
           return  9999;
       }
   }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("TAG","-----onBind----");
        return new MyBind();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("TAG","-----onUnbind----");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("TAG","-----onDestroy----");
    }
}

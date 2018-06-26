package com.example.fancx.aidl_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * 3, 创建Service , 返回Stub 对象
 * 4, 在清单文件中,注册Service  --- 提供action动作
 */

public class MyService extends Service {

    MyDataAidl.Stub stub = new MyDataAidl.Stub() {
        @Override
        public String getInfo() throws RemoteException {
            return "鹅鹅鹅,曲项向天歌,白毛浮绿水, 红掌拨清波....";
        }
        @Override
        public int getCount() throws RemoteException {
            return 888;
        }
    };
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }
}

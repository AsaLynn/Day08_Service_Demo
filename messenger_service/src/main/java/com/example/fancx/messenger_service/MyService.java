package com.example.fancx.messenger_service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2018/4/17.
 */
//TODO 6, 在清单文件中, 注册Service , 并且提供一个action 动作
public class MyService extends Service {

    //TODO 3, 定义一个处理器, 处理客户端发送过来的数据
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //TODO 5, 处理客户端发送过来的数据
          String info = msg.getData().getString("info");
            Log.e("TAG","客户端发送的消息 ---- " + info);
        }
    };

    //TODO 2, 创建一个服务器端的信使对象 -- 对象
    private Messenger messenger = new Messenger(handler);

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        //TODO 4, 将创建的信使对象(地址) , 通过绑定服务的onBind() 方法, 返回给客户端
        return messenger.getBinder();
    }
}

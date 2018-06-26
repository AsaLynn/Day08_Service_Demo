package com.example.fancx.messenger_client;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //TODO 4, 得到服务器端的信使对象
    private Messenger serverMessenger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //TODO 3, 服务的绑定结果的连接
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            //TODO 得到服务器端的信使对象
            serverMessenger  = new Messenger(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    //TODO 1,绑定服务
    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent("com.bw.messenger");
        intent.setPackage("com.example.fancx.messenger_service");
        bindService(intent,connection,BIND_AUTO_CREATE);
    }

    //TODO 2,解绑服务
    @Override
    protected void onStop() {
        super.onStop();
        unbindService(connection);
    }

    //向客户端写信
    public void send(View view) {
        try {
            //TODO 5, 通过信使对象, 向服务器端写入数据
            Message msg = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putString("info","我想大声的告诉你, 键盘是不是你的, 敲个没完.......");
            msg.setData(bundle);
            serverMessenger.send(msg);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

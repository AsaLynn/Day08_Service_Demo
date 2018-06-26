package com.example.fancx.aidl_db_client;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.fancx.aidl_db_service.MyDbAidl;

public class MainActivity extends AppCompatActivity {

    //TODO 5, 得到 aidl 对用的java 对象
    private MyDbAidl myDbAidl;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTv = (TextView) findViewById(R.id.tv_id);
    }

    //TODO 绑定服务的结果回调方法
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //TODO --- 得到 aidl 对用的java 对象
            myDbAidl = MyDbAidl.Stub.asInterface(service);
            try {
                String info = myDbAidl.getDbInfo();
                mTv.setText(info);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {}
    };

    //TODO 3, 绑定服务
    @Override
    protected void onStart() {
        super.onStart();
        //TODO 提供服务器端的内容  action , package
        Intent intent = new Intent("com.bw.aidl.db");
        intent.setPackage("com.example.fancx.aidl_db_service");//5.0 以后必须要提供
        bindService(intent,connection,BIND_AUTO_CREATE);
    }
    //TODO 4, 解绑服务
    @Override
    protected void onStop() {
        super.onStop();
        unbindService(connection);
    }
}

package com.example.fancx.aidl_clicent;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.fancx.aidl_service.MyDataAidl;

/**
 * aidl  --  绑定服务
 * 客户端:
 *  1, 复制"服务端" src/main 文件夹下的aidl 文件夹, 复制到客户端的同级目录下 src/main
 *  2, 编译生成同名的.java文件
 *  3, 绑定服务
 *  4, 解绑服务
 *  5, 服务绑定成功后, 得到aidl 对用的java 对象
 *  6, 取值
 *
 */
public class MainActivity extends AppCompatActivity {

    private MyDataAidl myDataAidl;//TODO aidl 对应的接口,  --- 绑定服务成功后, 才能得到该对象

    //服务是否绑定成功
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            myDataAidl = MyDataAidl.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //TODO 3, 绑定服务
    @Override
    protected void onStart() {
        super.onStart();
        //Intent intent = new Intent(this,MyService.class);  只适用于 同一个app中
        Intent intent = new Intent("com.bw.aidl.data");//todo  服务器端, 注册service 提供的action完全一致
        intent.setPackage("com.example.fancx.aidl_service");//todo 5.0 以后, 必须提供, 服务器端的包名
        bindService(intent,connection,BIND_AUTO_CREATE);
    }

    //TODO 4, 解绑服务
    @Override
    protected void onStop() {
        super.onStop();
        unbindService(connection);
    }

    //获取服务器端aidl返回数据
    public void getData(View view) {
        try {
            String info = myDataAidl.getInfo();
            int count = myDataAidl.getCount();

            Toast.makeText(this, "info = " + info +", count = " + count, Toast.LENGTH_SHORT).show();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}

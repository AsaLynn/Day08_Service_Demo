package com.example.fancx.aidl_db_service;

import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

public class MyService extends Service {

    MyDbAidl.Stub stub = new MyDbAidl.Stub() {
        @Override
        public String getDbInfo() throws RemoteException {

            //TODO 查询数据库中的所有内容, 并且返回
            //getApplicationContext()得到上下文对象  -- 除了对话框, 其他都可以使用
            DbOpenHelper dbOpenHelper = new DbOpenHelper(getApplicationContext());
            //得到数据库的操作类
            SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
           Cursor cursor =  db.rawQuery("select * from user",null);
           StringBuilder sBuilder = new StringBuilder();
           while (cursor.moveToNext())
           {
               String uName = cursor.getString(cursor.getColumnIndex("uName"));
               String uAge = cursor.getString(cursor.getColumnIndex("uAge"));

               sBuilder.append("姓名: " + uName ).append(", 年龄:  " + uAge +"\n");
           }
           return  sBuilder.toString();
           // return "确认过眼神, 是不想理的人.......";
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }
}

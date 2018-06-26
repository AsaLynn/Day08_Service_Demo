package com.example.fancx.aidl_db_service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 数据库的帮助类
 * 1, 定义一个类, 继承SQLiteOpenHelper
 * 2, 提供构造方法 -- 提供数据库的内容
 * 3, 提供2个方法
 *      onCreate ()  只执行一次, 初始化的工作
 *      onUpgrade()  版本更新的方法, 执行多次, ---- 版本号发生了多少次变化
 *
 *
 * SQLiteOpenHelper 数据库的创建和版本的更新
 * SQLiteDatabase  数据库的操作类   执行sql 语句 ,  执行增删改查数据库的方法
 */

public class DbOpenHelper  extends SQLiteOpenHelper{

    public DbOpenHelper(Context context) {
        super(context, "bw.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table  if not exists user(_id integer primary key autoincrement,uName,uAge)");

        db.execSQL("insert into user(uName,uAge) values('小志','3')");
        db.execSQL("insert into user(uName,uAge) values('团子','18')");
        db.execSQL("insert into user(uName,uAge) values('袁林浩','20')");
        db.execSQL("insert into user(uName,uAge) values('小钫','19')");
        db.execSQL("insert into user(uName,uAge) values('福庆','21')");
        db.execSQL("insert into user(uName,uAge) values('王宁','18')");
        db.execSQL("insert into user(uName,uAge) values('大白','23')");
        db.execSQL("insert into user(uName,uAge) values('嘉泰','20')");
        db.execSQL("insert into user(uName,uAge) values('祥龙','24')");
        db.execSQL("insert into user(uName,uAge) values('成群','18')");
        db.execSQL("insert into user(uName,uAge) values('昌达','7')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

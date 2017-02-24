package com.forzhihu.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tc on 2017/2/22.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATA_BASE_NAME = "MyDataBase";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        //CursorFactory设置为null,使用默认值
        super(context, DATA_BASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建用户表
        db.execSQL("CREATE TABLE IF NOT EXISTS user ( personid integer primary key autoincrement, user varchar(20)," +
                "email varchar(20)," +
                " password varchar(20)) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

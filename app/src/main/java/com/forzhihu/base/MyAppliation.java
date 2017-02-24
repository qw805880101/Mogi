package com.forzhihu.base;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.forzhihu.db.DBHelper;

/**
 * Created by tc on 2017/2/14.
 */

public class MyAppliation extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DBHelper db = new DBHelper(this);
        SQLiteDatabase database = db.getWritableDatabase();
    }
}

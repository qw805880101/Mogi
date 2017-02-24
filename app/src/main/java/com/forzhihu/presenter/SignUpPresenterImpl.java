package com.forzhihu.presenter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.forzhihu.bean.UserBean;
import com.forzhihu.db.DBHelper;
import com.forzhihu.model.SingUpView;

/**
 * Created by tc on 2017/2/23.
 */

public class SignUpPresenterImpl implements SignUpPresenter {

    private SingUpView mUserView;
    private Context context;

    public SignUpPresenterImpl(Context context, SingUpView mUserView) {
        this.context = context;
        this.mUserView = mUserView;
    }

    @Override
    public void singUp(String user, String email, String password) {
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        if (isFieldExist(database, email)) {
            mUserView.showSingUpFail("用户已存在");
        } else {
            String sql = "insert into user (user,email,password) values(?,?,?)";
            database.execSQL(sql, new String[]{user, email, password});
            if (isFieldExist(database, email)) {
                mUserView.showSingUpSuccess(new UserBean(email, password));
            }
        }
    }

    private boolean isFieldExist(SQLiteDatabase db, String email) {
        String sql = "SELECT * FROM user WHERE email = '" + email + "'";
        Cursor cr = db.rawQuery(sql, null);
        if (cr.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
}

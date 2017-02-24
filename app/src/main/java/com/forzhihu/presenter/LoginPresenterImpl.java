package com.forzhihu.presenter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.forzhihu.bean.UserBean;
import com.forzhihu.db.DBHelper;
import com.forzhihu.model.LoginView;

/**
 * Model负责数据的处理和业务逻辑
 * Created by tc on 2017/2/22.
 */

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView mUserView;
    private UserBean mUserBean;
    private Context context;

    public LoginPresenterImpl(Context context, LoginView view) {
        this.context = context;
        this.mUserView = view;
    }

    @Override
    public void login(String email, String password) {

        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        String sql = "SELECT * FROM user WHERE email = '" + email + "' AND password = '" + password + "'";
        System.out.println("sql = " + sql);
        Cursor cr = database.rawQuery(sql, null);
        if (cr.getCount() > 0) {
            String userName = "";
            while (cr.moveToNext()) {
                //根据列名获取列索引
                int nameColumnIndex = cr.getColumnIndex("user");
                userName = cr.getString(nameColumnIndex);
            }
            mUserBean = new UserBean(email, password);
            mUserBean.setUserName(userName);
            mUserView.showLoginSuccess(mUserBean);
        } else {
            mUserView.showLoginFail("邮箱或密码不正确！");
        }
    }
}
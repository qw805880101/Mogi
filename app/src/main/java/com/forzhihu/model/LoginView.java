package com.forzhihu.model;

import com.forzhihu.bean.UserBean;

/**
 * View负责展示数据
 * Created by tc on 2017/2/22.
 */

public interface LoginView {

    void showLoginSuccess(UserBean loginUser);

    void showLoginFail(String errorMsg);

}

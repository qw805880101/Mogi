package com.forzhihu.model;

import com.forzhihu.bean.UserBean;

/**
 * Created by tc on 2017/2/23.
 */

public interface SingUpView {
    void showSingUpSuccess(UserBean loginUser);

    void showSingUpFail(String errorMsg);
}

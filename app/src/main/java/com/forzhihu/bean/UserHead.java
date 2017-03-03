package com.forzhihu.bean;

import com.forzhihu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tc on 2017/2/27.
 */

public class UserHead {
    public static List<UserBean> getUserHead() {
        List<UserBean> list = new ArrayList<>();
        list.add(new UserBean("qw805880101@qq.com", "qw123456", R.mipmap.main_bg));
        list.add(new UserBean("qw805880101@qq.com", "qw123456", R.mipmap.main_bg));
        list.add(new UserBean("qw805880101@qq.com", "qw123456", R.mipmap.main_bg));
        list.add(new UserBean("qw805880101@qq.com", "qw123456", R.mipmap.main_bg));
        list.add(new UserBean("qw805880101@qq.com", "qw123456", R.mipmap.main_bg));
        list.add(new UserBean("qw805880101@qq.com", "qw123456", R.mipmap.main_bg));
        list.add(new UserBean("qw805880101@qq.com", "qw123456", R.mipmap.main_bg));
        return list;
    }
}

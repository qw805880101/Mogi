package com.forzhihu.base;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.forzhihu.utils.SystemBarTintManager;

/**
 * Created by tc on 2017/2/14.
 */

public abstract class BaseActivity extends Activity {

    public SystemBarTintManager tintManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        StatusBarUtils.initStatusBar(this, R.color.colorAccent);
        setTranslucentStatus(true);
        tintManager = new SystemBarTintManager(this);
//        //设置是否透明显示状态栏
//        tintManager.setStatusBarTintEnabled(true);
//        //设置状态栏颜色
//        tintManager.setStatusBarTintResource(R.color.colorAccent);
//        // 设置状态栏的文字颜色
//        tintManager.setStatusBarDarkMode(true, this);
        setContextView();
        findyView();
        setTitleColor(tintManager);
    }


    public abstract void setContextView();

    public abstract void findyView();

    public abstract void setTitleColor(SystemBarTintManager tintManager);

    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

}

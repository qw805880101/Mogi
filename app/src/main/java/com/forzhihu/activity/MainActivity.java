package com.forzhihu.activity;

import android.os.Bundle;
import android.view.View;

import com.forzhihu.R;
import com.forzhihu.base.BaseActivity;
import com.forzhihu.utils.SystemBarTintManager;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import static com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.TOUCHMODE_FULLSCREEN;

/**
 * Created by tc on 2017/2/17.
 */

public class MainActivity extends BaseActivity implements View.OnClickListener, SlidingMenu.OnOpenedListener {

    private SlidingMenu menu; //侧滑

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContextView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void findyView() {

    }

    /**
     * 侧滑栏初始化
     */
    private void menuInit() {
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.shadow);
        // 设置菜单触摸
        menu.setTouchModeBehind(TOUCHMODE_FULLSCREEN);
        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        menu.setOffsetFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setOnOpenedListener(this);
        //为侧滑菜单设置布局
//        menu.setMenu(view);
    }

    @Override
    public void setTitleColor(SystemBarTintManager tintManager) {
//        tintManager.setStatusBarTintResource(R.color.color_000000);
//        tintManager.setStatusBarTintEnabled(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }

    @Override
    public void onOpened() {

    }
}

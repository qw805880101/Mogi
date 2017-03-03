package com.forzhihu.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.forzhihu.R;
import com.forzhihu.adapter.MainContentAdatper;
import com.forzhihu.base.BaseActivity;
import com.forzhihu.utils.SystemBarTintManager;
import com.forzhihu.view.LeftView;
import com.forzhihu.view.MainHeadView;
import com.forzhihu.view.TitleView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import static com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.TOUCHMODE_FULLSCREEN;

/**
 * Created by tc on 2017/2/17.
 */

public class MainActivity extends BaseActivity implements View.OnClickListener, SlidingMenu.OnOpenedListener,
        TitleView.TitleInterface {

    private int width;

    private SlidingMenu menu; //侧滑

    private LeftView mLeftView;

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContextView() {
        setContentView(R.layout.activity_main);
        width = getWindowManager().getDefaultDisplay().getWidth();
    }

    @Override
    public void findyView() {
        new TitleView(this).setTitleInterface(this).initTitleView();
        MainContentAdatper mainContentAdatper = new MainContentAdatper(this);
        mainContentAdatper.addHeaderView(new MainHeadView(this).getHeadView());
        mRecyclerView = (RecyclerView) findViewById(R.id.rlview_main);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mainContentAdatper);
        menuInit();
    }

    /**
     * 侧滑栏初始化
     */
    private void menuInit() {
        mLeftView = new LeftView(this);
        View view = mLeftView.initLeftView();
        mLeftView.setLoginState(LeftView.LoginState.ON_LINE);
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
//        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.shadow);
//        // 设置菜单触摸
        menu.setTouchModeBehind(TOUCHMODE_FULLSCREEN);
//        // 设置滑动菜单视图的宽度
        menu.setBehindOffset(width - mLeftView.getViewWidth());
//        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        menu.setOffsetFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT, true);
        menu.setOnOpenedListener(this);
        //为侧滑菜单设置布局
        menu.setMenu(view);
    }

    @Override
    public void setTitleColor(SystemBarTintManager tintManager) {
//        tintManager.initStatusBar(this, R.color.colorPrimaryDark);
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

    @Override
    public void setTitleBuilder(Toolbar mToolbar, TextView titleName) {
        mToolbar.setLogo(R.mipmap.to_left);
        mToolbar.setTitleTextColor(this.getResources().getColor(R.color.color_ffffffff));
        mToolbar.setTitle("Back");
        titleName.setText("Profile");
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

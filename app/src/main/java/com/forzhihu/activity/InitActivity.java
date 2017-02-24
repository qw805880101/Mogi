package com.forzhihu.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.forzhihu.R;
import com.forzhihu.adapter.ViewPagerAdapter;
import com.forzhihu.base.BaseActivity;
import com.forzhihu.utils.SystemBarTintManager;

import java.util.ArrayList;

/**
 * Created by tc on 2017/2/24.
 */

public class InitActivity extends BaseActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private ViewPager mViewPager;

    // 定义ViewPager适配器
    private ViewPagerAdapter vpAdapter;

    // 定义一个ArrayList来存放View
    private ArrayList<View> views;

    // 引导图片资源
    private static final int[] pics = {R.mipmap.init_01, R.mipmap.init_02,
            R.mipmap.init_03};

    // 底部小点的图片
    private ImageView[] points;

    // 记录当前选中位置
    private int currentIndex;

    private Button SignUpBtn;
    private Button SignInBtn;
    private LinearLayout linInit;

    @Override
    public void setContextView() {
        setContentView(R.layout.activity_init);
    }

    @Override
    public void findyView() {
        linInit = (LinearLayout) findViewById(R.id.lin_init);
        SignUpBtn = (Button) findViewById(R.id.btn_init_singup);
        SignUpBtn.setOnClickListener(this);
        SignInBtn = (Button) findViewById(R.id.btn_init_singin);
        SignInBtn.setOnClickListener(this);
        // 实例化ArrayList对象
        views = new ArrayList<View>();

        // 实例化ViewPager
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        // 实例化ViewPager适配器
        vpAdapter = new ViewPagerAdapter(views);
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        // 定义一个布局并设置参数
        LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.FILL_PARENT);

        // 初始化引导图片列表
        for (int i = 0; i < pics.length; i++) {
            ImageView iv = new ImageView(this);
            iv.setLayoutParams(mParams);
            iv.setImageResource(pics[i]);
            views.add(iv);
        }

        // 设置数据
        //前面的views中没有数据 在前面的循环中才插入数据 而此时vpAdapter中已经有数据说明
        //初始化adapter的时候 参数传递是传引用
        mViewPager.setAdapter(vpAdapter);
        // 设置监听
        mViewPager.setOnPageChangeListener(this);

        // 初始化底部小点
        initPoint();
    }

    /**
     * 初始化底部小点
     */
    private void initPoint() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        points = new ImageView[pics.length];

        // 循环取得小点图片
        for (int i = 0; i < pics.length; i++) {
            // 得到一个LinearLayout下面的每一个子元素
            points[i] = (ImageView) linearLayout.getChildAt(i);
            // 默认都设为灰色
            points[i].setEnabled(true);
            // 给每个小点设置监听
            points[i].setOnClickListener(this);
            // 设置位置tag，方便取出与当前位置对应
            points[i].setTag(i);
        }

        // 设置当面默认的位置
        currentIndex = 0;
        // 设置为白色，即选中状态
        points[currentIndex].setEnabled(false);
    }


    @Override
    public void setTitleColor(SystemBarTintManager tintManager) {
        tintManager.setStatusBarTintEnabled(false);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_init_singup:
                intent = new Intent(this, SignUpActivity.class);
                this.startActivity(intent);
                break;
            case R.id.btn_init_singin:
                intent = new Intent(this, LoginActivity.class);
                this.startActivity(intent);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == 2) {
            linInit.setVisibility(View.VISIBLE);
        } else {
            linInit.setVisibility(View.GONE);
        }
        // 设置底部小点选中状态
        setCurDot(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    /**
     * 设置当前页面的位置
     */
    private void setCurView(int position) {
        // 排除异常情况
        if (position < 0 || position >= pics.length) {
            return;
        }
        mViewPager.setCurrentItem(position);
    }

    /**
     * 设置当前的小点的位置
     */
    private void setCurDot(int positon) {
        // 排除异常情况
        if (positon < 0 || positon > pics.length - 1 || currentIndex == positon) {
            return;
        }
        points[positon].setEnabled(false);
        points[currentIndex].setEnabled(true);

        currentIndex = positon;
    }
}

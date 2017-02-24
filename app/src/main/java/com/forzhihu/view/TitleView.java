package com.forzhihu.view;

import android.app.Activity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.forzhihu.R;

/**
 * Created by tc on 2017/2/23.
 */

public class TitleView {
    private Activity mActivity;
    private TitleInterface titleInterface;

    public TitleView(Activity mActivity) {
        this.mActivity = mActivity;
    }

    public TitleView setTitleInterface(TitleInterface titleInterface) {
        this.titleInterface = titleInterface;
        return this;
    }

    public void initTitleView() {
        View view = mActivity.getWindow().getDecorView();
        Toolbar mToolbar = (Toolbar) view.findViewById(R.id.toobar);
        TextView titleName = (TextView) view.findViewById(R.id.txt_title);
        titleInterface.setTitleBuilder(mToolbar, titleName);
    }

    public interface TitleInterface {
        /**
         * 设置标题栏参数
         *
         * @param titleName 标题栏名称
         */
        void setTitleBuilder(Toolbar mToolbar, TextView titleName);
    }
}

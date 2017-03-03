package com.forzhihu.adapter;

import android.content.Context;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.forzhihu.R;
import com.forzhihu.bean.UserProfileInfo;
import com.forzhihu.bean.UserProfileItem;

import java.util.Map;
import java.util.Set;

/**
 * Created by tc on 2017/3/1.
 */

public class MainContentAdatper extends BaseQuickAdapter<UserProfileInfo, BaseViewHolder> implements View
        .OnClickListener {

    private Context context;

    private Set<Map<String, String>> map;

    public MainContentAdatper(Context context) {
        super(R.layout.item_main_content, UserProfileItem.getUserProfile());
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, UserProfileInfo item) {
        System.out.println("convert");
        helper.setText(R.id.txt_user_name, item.getName()).setImageResource(R.id.head_image, item.getImg()).setText(R
                .id.txt_date, item.getDate()).setText(R.id.txt_content, item.getProfile());

        helper.getView(R.id.btn_share).setOnClickListener(this);
        helper.getView(R.id.btn_like).setOnClickListener(this);
        helper.getView(R.id.btn_msg).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_share:
                break;
            case R.id.btn_like:



                break;
            case R.id.btn_msg:
                break;
        }
    }
}

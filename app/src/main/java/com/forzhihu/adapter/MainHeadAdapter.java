package com.forzhihu.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.forzhihu.R;
import com.forzhihu.bean.UserBean;
import com.forzhihu.bean.UserHead;

/**
 * Created by tc on 2017/2/27.
 */

public class MainHeadAdapter extends BaseQuickAdapter<UserBean, BaseViewHolder> {

    public MainHeadAdapter() {
        super(R.layout.item_main_image, UserHead.getUserHead());
    }

    @Override
    protected void convert(BaseViewHolder helper, UserBean item) {
        System.out.println("convert");
        helper.setImageResource(R.id.main_headview, item.getImg());
    }

}

package com.forzhihu.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.forzhihu.R;
import com.forzhihu.bean.LeftItem;
import com.forzhihu.bean.LeftItemInfo;

/**
 * Created by tc on 2017/2/27.
 */

public class ListItemAdapter extends BaseQuickAdapter<LeftItemInfo, BaseViewHolder> {
    public ListItemAdapter() {
        super(R.layout.item_left, LeftItem.getItemBeans());
    }

    @Override
    protected void convert(BaseViewHolder helper, LeftItemInfo item) {
        System.out.println("convert");
        if (helper.getLayoutPosition() == 5) {
            helper.getView(R.id.txt_item_name).setVisibility(View.INVISIBLE);
            helper.getView(R.id.img_item_icon).setVisibility(View.INVISIBLE);
        }
        helper.setText(R.id.txt_item_name, item.getTitle()).setImageResource(R.id.img_item_icon, item.getImg());
    }
}

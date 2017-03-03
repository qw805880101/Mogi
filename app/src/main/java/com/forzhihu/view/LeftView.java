package com.forzhihu.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.forzhihu.R;
import com.forzhihu.adapter.ListItemAdapter;

/**
 * Created by tc on 2017/2/27.
 */

public class LeftView {

    private View view;
    private Context context;

    private RecyclerView mRecyclerView;

    private HeadView mHeadView;

    public enum LoginState {
        /*在线*/  /*隐身*/   /*离开*/  /*离线*/
        ON_LINE, IN_VISBLE, LEAVE, OFF_LINE
    }

    public LeftView(Context context) {
        this.context = context;
    }

    public View initLeftView() {
        ListItemAdapter itemAdapter = new ListItemAdapter();
//        itemAdapter.addHeaderView(LayoutInflater.from(context).inflate(R.layout.item_left_head, null));
        view = LayoutInflater.from(context).inflate(R.layout.view_main_left, null);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.left_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.setAdapter(itemAdapter);
        mRecyclerView.addOnItemTouchListener(mOnItemLongClickListener);

        mHeadView = (HeadView) view.findViewById(R.id.my_headview);
        mHeadView.addState(true);
        mHeadView.setViewW(getViewWidth());
        mHeadView.setOnClickListener(mOnClickListener);

        return view;
    }

    public int getViewWidth() {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec
                .makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        return view.getMeasuredWidth();
    }

    public void setLoginState(LoginState state) {
        switch (state) {
            case ON_LINE:
                mHeadView.setColor(R.color.color_2a982f);
                break;
            case IN_VISBLE:
                mHeadView.setColor(R.color.color_c0d60a);
                break;
            case LEAVE:
                mHeadView.setColor(R.color.color_d5eef6);
                break;
            case OFF_LINE:
                mHeadView.setColor(R.color.color_a0a7aa);
                break;
        }

    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(context, "点击头像", Toast.LENGTH_SHORT).show();
        }
    };


    OnItemClickListener mOnItemLongClickListener = new OnItemClickListener() {
        @Override
        public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
            if (position == 5)
                return;
            Toast.makeText(context, "" + Integer.toString(position), Toast.LENGTH_SHORT).show();
        }
    };

}

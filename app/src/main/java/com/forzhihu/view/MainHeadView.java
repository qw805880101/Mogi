package com.forzhihu.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.forzhihu.R;
import com.forzhihu.adapter.MainHeadAdapter;

/**
 * Created by tc on 2017/3/1.
 */

public class MainHeadView {
    private Context context;

    public MainHeadView(Context context) {
        this.context = context;
    }

    public View getHeadView() {
        View view = LayoutInflater.from(context).inflate(R.layout.item_main_head, null);

        RecyclerView mRecycler = (RecyclerView) view.findViewById(R.id.rlview_main_head);
        mRecycler.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        mRecycler.setAdapter(new MainHeadAdapter());

        return view;
    }
}

package com.forzhihu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.forzhihu.R;
import com.forzhihu.base.BaseActivity;
import com.forzhihu.utils.SystemBarTintManager;

/**
 * Created by tc on 2017/2/17.
 */

public class MainActivity extends BaseActivity implements View.OnClickListener {

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
        findViewById(R.id.button).setOnClickListener(this);

    }

    @Override
    public void setTitleColor(SystemBarTintManager tintManager) {
//        tintManager.setStatusBarTintResource(R.color.color_000000);
//        tintManager.setStatusBarTintEnabled(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, MainActivity.class);
                this.startActivity(intent);
                break;
        }
    }
}

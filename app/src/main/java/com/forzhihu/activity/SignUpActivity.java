package com.forzhihu.activity;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.forzhihu.R;
import com.forzhihu.base.BaseActivity;
import com.forzhihu.bean.UserBean;
import com.forzhihu.model.SingUpView;
import com.forzhihu.presenter.SignUpPresenterImpl;
import com.forzhihu.utils.SystemBarTintManager;
import com.forzhihu.utils.Utils;
import com.forzhihu.view.TitleView;

/**
 * Created by tc on 2017/2/23.
 */

public class SignUpActivity extends BaseActivity implements View.OnClickListener, TitleView.TitleInterface, SingUpView {

    private static final int MATCHING = 0; //密码匹配
    private static final int NO_MATCHING = 1; //密码不匹配

    private EditText userEdt;
    private EditText emailEdt;
    private EditText passwordEdt;
    private EditText conPasEdt;
    private EditText edt;
    private Button singUpBtn;

    private SignUpPresenterImpl mSingUpPresenter;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == MATCHING) {
                System.out.println("密码匹配");
                Drawable nav_up = getResources().getDrawable(R.mipmap.icon_ok);
                nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
                conPasEdt.setCompoundDrawables(null, null, nav_up, null);
                singUpBtn.setClickable(true);
                singUpBtn.setBackground(getResources().getDrawable(R.drawable.button_selector));
            } else if (msg.what == NO_MATCHING) {
                System.out.println("密码不匹配");
                Drawable nav_up = getResources().getDrawable(R.mipmap.icon_no_ok);
                nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
                conPasEdt.setCompoundDrawables(null, null, nav_up, null);
                singUpBtn.setClickable(false);
                singUpBtn.setBackground(getResources().getDrawable(R.drawable.button_checked_false));
            }
        }
    };

    @Override
    public void setContextView() {
        setContentView(R.layout.activity_signup);
        mSingUpPresenter = new SignUpPresenterImpl(this, this);
    }

    @Override
    public void findyView() {
        new TitleView(this).setTitleInterface(this).initTitleView();
        userEdt = (EditText) findViewById(R.id.edt_user_name);
        emailEdt = (EditText) findViewById(R.id.edt_mail);
        passwordEdt = (EditText) findViewById(R.id.edt_password);
        passwordEdt.addTextChangedListener(mTextWatcher);
        passwordEdt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                edt = conPasEdt;
            }
        });
        conPasEdt = (EditText) findViewById(R.id.edt_confirm_password);
        conPasEdt.addTextChangedListener(mTextWatcher);
        conPasEdt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                edt = passwordEdt;
            }
        });
        edt = conPasEdt;
        singUpBtn = (Button) findViewById(R.id.btn_signup);
        singUpBtn.setOnClickListener(this);
    }

    @Override
    public void setTitleColor(SystemBarTintManager tintManager) {
        tintManager.setStatusBarTintEnabled(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_signup:
                String userName = userEdt.getText().toString().trim();
                String email = emailEdt.getText().toString().trim();
                String password = passwordEdt.getText().toString().trim();
                if (userName.isEmpty()) {
                    Toast.makeText(this, "用户名不能为空!", Toast.LENGTH_SHORT).show();
                    return;
                } else if (email.isEmpty()) {
                    Toast.makeText(this, "邮箱不能为空!", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!Utils.isEmailCorrect(email)) {
                    Toast.makeText(this, "邮箱格式不正确，请重新输入!", Toast.LENGTH_SHORT).show();
                    return;
                } else if (password.isEmpty()) {
                    Toast.makeText(this, "密码不能为空!", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!Utils.isPasswordCorrect(password)) {
                    Toast.makeText(this, "密码必须以字母开头!", Toast.LENGTH_SHORT).show();
                    return;
                } else if (password.length() <= 6 && password.length() >= 20) {
                    Toast.makeText(this, "密码长度必须大于6位小于20位!", Toast.LENGTH_SHORT).show();
                    return;
                }
                mSingUpPresenter.singUp(userName, email, password);
                break;
        }
    }

    @Override
    public void setTitleBuilder(Toolbar mToolbar, TextView titleName) {
        mToolbar.setNavigationIcon(R.mipmap.to_left);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        titleName.setText("");
    }

    @Override
    public void showSingUpSuccess(UserBean loginUser) {
        Toast.makeText(this, loginUser.getUserName() + "注册成功", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    @Override
    public void showSingUpFail(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }

    TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (!s.toString().isEmpty()) {
                    /* 判断密码是否输入匹配 */
                if (s.toString().equals(edt.getText().toString().trim())) {
                    mHandler.sendEmptyMessage(MATCHING);
                } else {
                    mHandler.sendEmptyMessage(NO_MATCHING);
                }
            } else {
                mHandler.sendEmptyMessage(NO_MATCHING);
            }
        }
    };

}

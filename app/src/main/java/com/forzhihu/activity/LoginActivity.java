package com.forzhihu.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.forzhihu.R;
import com.forzhihu.base.BaseActivity;
import com.forzhihu.bean.UserBean;
import com.forzhihu.model.LoginView;
import com.forzhihu.presenter.LoginPresenterImpl;
import com.forzhihu.utils.SystemBarTintManager;
import com.forzhihu.utils.Utils;
import com.forzhihu.view.TitleView;

/**
 * Created by tc on 2017/2/22.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener, LoginView, TitleView.TitleInterface {

    private EditText emailEdt;
    private EditText passwordEdt;
    private Button signInBtn;
    private TextView singUpTxt;

    private LoginPresenterImpl mUserPresenter;

    @Override
    public void setContextView() {
        setContentView(R.layout.activity_login);
        mUserPresenter = new LoginPresenterImpl(this, this);
    }

    @Override
    public void findyView() {
        new TitleView(this).setTitleInterface(this).initTitleView();
        emailEdt = (EditText) findViewById(R.id.edt_mail);
        passwordEdt = (EditText) findViewById(R.id.edt_password);
        signInBtn = (Button) findViewById(R.id.btn_signin);
        signInBtn.setOnClickListener(this);
        singUpTxt = (TextView) findViewById(R.id.txt_singup);
        singUpTxt.setOnClickListener(this);
    }

    @Override
    public void setTitleColor(SystemBarTintManager tintManager) {
        tintManager.setStatusBarTintEnabled(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_signin:
                String email = emailEdt.getText().toString().trim();
                String password = passwordEdt.getText().toString().trim();
                if (email.isEmpty()) {
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
                mUserPresenter.login(email, password);
                break;
            case R.id.txt_singup:
                Intent intent = new Intent(this, SignUpActivity.class);
                this.startActivity(intent);
                break;
        }
    }

    @Override
    public void showLoginSuccess(UserBean loginUser) {
        Toast.makeText(this, loginUser.getUserName() + "登录成功", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        this.startActivity(intent);
        this.finish();
    }

    @Override
    public void showLoginFail(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
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
}

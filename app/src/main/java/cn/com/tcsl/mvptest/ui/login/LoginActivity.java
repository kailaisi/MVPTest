package cn.com.tcsl.mvptest.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.com.tcsl.mvptest.R;
import cn.com.tcsl.mvptest.base.BaseActivity;
import cn.com.tcsl.mvptest.bean.LoginRequest;
import cn.com.tcsl.mvptest.ui.main.MainActivity;

/**
 * Created by wjx on 2016/7/15.
 */
public class LoginActivity extends BaseActivity<LoginContract.Presenter> implements LoginContract.View {

    @BindView(R.id.iv_cancel)
    ImageView ivCancel;
    @BindView(R.id.tv_phone)
    EditText tvPhone;
    @BindView(R.id.tv_password)
    EditText tvPassword;
    @BindView(R.id.cb_remember)
    CheckBox cbRemember;
    @BindView(R.id.linearlayout)
    LinearLayout linearlayout;
    @BindView(R.id.linearlayout2)
    LinearLayout linearlayout2;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_regist)
    Button btnRegist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mPresenter = new LoginPresenter(this);
        mPresenter.start();
    }


    @OnClick({R.id.cb_remember, R.id.btn_login, R.id.btn_regist})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cb_remember:
                break;
            case R.id.btn_login:
                LoginRequest request = new LoginRequest("GBLHPLD", "1314", "123456789");
                mPresenter.login(request);
                break;
            case R.id.btn_regist:
                break;
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void navigateToMain() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToRegister() {

    }


}

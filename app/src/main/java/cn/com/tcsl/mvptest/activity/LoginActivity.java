package cn.com.tcsl.mvptest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.com.tcsl.mvptest.R;

/**
 * Created by wjx on 2016/7/15.
 */
public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.iv_cancel)
    ImageView ivCancel;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_password)
    TextView tvPassword;
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
    }

    @OnClick({R.id.cb_remember, R.id.btn_login, R.id.btn_regist})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cb_remember:
                break;
            case R.id.btn_login:
                break;
            case R.id.btn_regist:
                break;
        }
    }
}

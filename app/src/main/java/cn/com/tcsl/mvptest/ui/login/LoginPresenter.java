package cn.com.tcsl.mvptest.ui.login;

import cn.com.tcsl.mvptest.http.HttpMethods;
import cn.com.tcsl.mvptest.http.model.Login;
import cn.com.tcsl.mvptest.http.model.LoginRequest;
import cn.com.tcsl.mvptest.service.ProgressSubcriber;

/**
 * Created by wjx on 2016/7/19.
 */
public class LoginPresenter implements LoginContract.Presenter {
    @Override
    public void login(LoginRequest request) {
        HttpMethods.getInstance().getLogin(new ProgressSubcriber<Login>());
    }

    @Override
    public void onDestroy() {

    }
}

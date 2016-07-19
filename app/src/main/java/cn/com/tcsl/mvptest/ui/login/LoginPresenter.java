package cn.com.tcsl.mvptest.ui.login;

import cn.com.tcsl.mvptest.http.HttpMethods;
import cn.com.tcsl.mvptest.http.model.LoginRequest;

/**
 * Created by wjx on 2016/7/19.
 */
public class LoginPresenter implements LoginContract.Presenter {
    @Override
    public void login(LoginRequest request) {
        HttpMethods.getInstance().getLogin();
    }

    @Override
    public void onDestroy() {

    }
}

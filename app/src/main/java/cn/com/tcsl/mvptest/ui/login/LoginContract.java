package cn.com.tcsl.mvptest.ui.login;

import cn.com.tcsl.mvptest.base.BasePresenter;
import cn.com.tcsl.mvptest.base.BaseView;
import cn.com.tcsl.mvptest.bean.User;
import cn.com.tcsl.mvptest.http.model.LoginRequest;

/**
 * Created by wjx on 2016/7/15.
 */
public interface LoginContract {
    interface View extends BaseView {
        void showProgress();
        void hideProgress();
        void showError(String error);

        /**
         * 跳转到主界面
         */
        void navigateToMain();

        /**
         * 跳转到注册界面
         */
        void navigateToRegister();
    }
    interface Presenter extends BasePresenter {
        void login(LoginRequest loginRequest);
        void onDestroy();
    }
    interface Model{
        void saveUserInfo(User user);
        void saveLoginState(boolean isLogin);
        void saveRememberPass(User user);
    }
}

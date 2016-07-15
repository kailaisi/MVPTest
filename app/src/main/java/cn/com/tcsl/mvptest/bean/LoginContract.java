package cn.com.tcsl.mvptest.bean;

import cn.com.tcsl.mvptest.base.BasePresenter;
import cn.com.tcsl.mvptest.base.BaseView;

/**
 * Created by wjx on 2016/7/15.
 */
public interface LoginContract {
    interface View extends BaseView {
        void showProgress();
        void hideProgress();
        void showError(String error);
        void navigateToMain();
        void navigateToRegister();
    }
    interface Presenter extends BasePresenter {
        void login(String username,String password);
        void onDestroy();
    }
    interface Model{
        void saveUserInfo(User user);
        void saveLoginState(boolean isLogin);
        void saveRememberPass(User user);
    }
}

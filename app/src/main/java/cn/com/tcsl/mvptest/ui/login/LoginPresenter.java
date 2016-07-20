package cn.com.tcsl.mvptest.ui.login;

import android.content.Context;

import cn.com.tcsl.mvptest.base.ProgressSubscriber;
import cn.com.tcsl.mvptest.http.HttpMethods;
import cn.com.tcsl.mvptest.http.model.Login;
import cn.com.tcsl.mvptest.http.model.LoginRequest;
import cn.com.tcsl.mvptest.interfaces.SubscriberOnNextListener;

/**
 * Created by wjx on 2016/7/19.
 */
public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View mView;
    private LoginContract.Model mModel;

    private Context mContext;
    public LoginPresenter(LoginContract.View view) {
        this.mView = view;
        mContext= (Context) view;
        mModel =new LoginModel();
    }

    @Override
    public void login(LoginRequest request) {
        SubscriberOnNextListener listener=new SubscriberOnNextListener<Login>() {
            @Override
            public void onNext(Login login) {
                mView.navigateToMain();
            }
        };
        HttpMethods.getInstance().getLogin(new ProgressSubscriber<Login>(listener, mContext,false),request);
    }

    @Override
    public void onDestroy() {

    }
}

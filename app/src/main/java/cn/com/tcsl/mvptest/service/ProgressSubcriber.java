package cn.com.tcsl.mvptest.service;

import android.content.Context;

import cn.com.tcsl.mvptest.interfaces.ProgressCancelListener;
import rx.Subscriber;

/**
 * 带有progress的观察者
 * Created by wjx on 2016/7/19.
 */
public class ProgressSubcriber<T> extends Subscriber<T> implements ProgressCancelListener {
    Context mContext;



    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onCancelProgress() {

    }
}

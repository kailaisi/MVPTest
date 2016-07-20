package cn.com.tcsl.mvptest.interfaces;

/**
 * Created by wu on 2016/7/20.
 */
public interface SubscriberOnNextListener<T> {
    void onNext(T t);
}

package cn.com.tcsl.mvptest.http.interfaces;

/**
 * 将subscriber的onNext通过该接口进行回传
 * Created by wu on 2016/7/20.
 */
public interface SubscriberOnNextListener<T> {
    void onNext(T t);
}

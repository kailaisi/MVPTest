package cn.com.tcsl.mvptest.base;

/**
 * Created by wjx on 2016/7/15.
 */
public interface BasePresenter {
    /**
     * 控制activity的初始化
     */
    void start();

    /**
     * 控制activity的销毁
     */
    void onDestroy();
}

package cn.com.tcsl.mvptest.ui;

import com.google.gson.Gson;

import cn.com.tcsl.mvptest.bean.Login;
import cn.com.tcsl.mvptest.bean.LoginRequest;
import cn.com.tcsl.mvptest.http.RetrofitHttpUtils;
import cn.com.tcsl.mvptest.http.interfaces.DownProgressListener;
import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by wjx on 2016/7/28.
 */
public class APIFactory extends RetrofitHttpUtils {

    private APIFactory() {
        super();
    }

    private APIFactory(DownProgressListener listener){
        super(listener);
    }

    public static APIFactory getInstance(){
        return SingletonHolder.INSTANCE;
    }
    /**
     * 提供下载的单例模式，需要传入下载进度监听的回调
     *
     * @param listener
     * @return
     */
    public static APIFactory getDownInstance(DownProgressListener listener) {
        downInstance = new RetrofitHttpUtils(listener);
        return downInstance;
    }

    private static class SingletonHolder{
        private static final APIFactory INSTANCE =new APIFactory();
    }

    private static class SingetonHolder{
        private static final  APIFactory DOWNINSTANCE=new APIFactory(do)
    }


    /**
     * 获取登录信息
     *
     * @param subscriber 调用者传过来的观察者对象
     * @param request    请求的登陆类
     */
    public void getLogin(Subscriber<Login> subscriber, LoginRequest request) {
        Observable<Login> observable = requestService.userLogin(new Gson().toJson(request));
        toSubcriber(subscriber, observable);
    }

    public void downLoad(Subscriber<ResponseBody> subscriber, String url) {
        Observable<ResponseBody> observable = requestService.downLoad(url);
        toSubcriber(subscriber, observable);
    }
}

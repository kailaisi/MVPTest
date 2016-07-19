package cn.com.tcsl.mvptest.http;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import cn.com.tcsl.mvptest.http.model.Login;
import cn.com.tcsl.mvptest.http.model.LoginRequest;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wjx on 2016/7/19.
 */
public class HttpMethods {
    private static HttpMethods ourInstance = new HttpMethods();
    private final String baseUrl="http://cs.wuuxiang.com:666/api/";
    Retrofit retrofit;
    RequestService requestService;
    /**
     * okhttp拦截器
     */
    private static OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor
            (new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build();
    /**
     * 连接超时时间
     */
    private int default_timeout = 5;

    public static HttpMethods getInstance() {
        return ourInstance;
    }

    private HttpMethods() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(default_timeout, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder().client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build();
        requestService=retrofit.create(RequestService.class);
    }

    /**
     * 获取登录信息
     * @param subscriber 调用者传过来的观察者对象
     * @param request 请求的登陆类
     */
    public void getLogin(Subscriber<Login> subscriber, LoginRequest request){
        Observable<Login> observable=requestService.userLogin(new Gson().toJson(request));
        toSubcriber(subscriber, observable);
    }

    /**
     * 添加线程管理并订阅
     * @param subscriber 观察者
     * @param observable 被观察者
     */
    private void toSubcriber(Subscriber subscriber, Observable observable) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


}

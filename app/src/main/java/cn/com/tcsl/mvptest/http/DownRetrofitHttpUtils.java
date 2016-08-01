package cn.com.tcsl.mvptest.http;

import android.content.Context;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cn.com.tcsl.mvptest.BuildConfig;
import cn.com.tcsl.mvptest.http.Utils.AppUtil;
import cn.com.tcsl.mvptest.http.interfaces.DownProgressListener;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * retrofit网络请求工具类，封装了retrofit的初始化等相关方法
 * Created by wjx on 2016/7/19.
 */
public class DownRetrofitHttpUtils {
    private static DownRetrofitHttpUtils ourInstance = new DownRetrofitHttpUtils();
    private static DownRetrofitHttpUtils downInstance;
    private final String baseUrl = "http://cs.wuuxiang.com:666/api/";
    private static Retrofit retrofit;
    public RequestService requestService;
    /**
     * okhttp打印数据拦截器
     */
    private static OkHttpClient okHttpClient;
    private static DownloadProgressInterceptor downloadProgressInterceptor;
    /**
     * 连接超时时间
     */
    private int default_timeout = 5;
    private Context mContext;
    private boolean isUseCache;
    private int maxCacheTime=60;

    public static DownRetrofitHttpUtils getInstance() {
        return ourInstance;
    }

    /**
     * 提供下载的单例模式，需要传入下载进度监听的回调
     *
     * @param listener
     * @return
     */
    public static DownRetrofitHttpUtils getDownInstance(DownProgressListener listener) {
        downInstance = new DownRetrofitHttpUtils(listener);
        return downInstance;
    }


    /**
     * 带下载上传进度回调的构造函数
     *
     * @param listener 回调接口
     */
    public DownRetrofitHttpUtils(DownProgressListener listener) {
        downloadProgressInterceptor = new DownloadProgressInterceptor(listener);
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(downloadProgressInterceptor)
                .build();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(default_timeout, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder().client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build();
        requestService = retrofit.create(RequestService.class);
    }

    /**
     * 普通的网络请求
     */
    public DownRetrofitHttpUtils() {
        okHttpClient = new OkHttpClient.Builder().addInterceptor
                (new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(default_timeout, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder().client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build();
        requestService = retrofit.create(RequestService.class);
    }





    public RequestService getRequestService(){
        if(requestService==null && retrofit!=null){
            requestService=retrofit.create(RequestService.class);
        }
        return requestService;
    }

    public void init(Context context){
        this.mContext=context;
        initOkHttp();
        initRetrofit();
        if(requestService==null){
            requestService=retrofit.create(RequestService.class);
        }
    }

    public void initOkHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {//log显示
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }
        //设置网络超时时间
        builder.connectTimeout(default_timeout, TimeUnit.SECONDS)
                .readTimeout(default_timeout, TimeUnit.SECONDS)
                .writeTimeout(default_timeout, TimeUnit.SECONDS);
        //设置缓存
        File cacheFile = new File(AppUtil.getCacheDir(mContext), "httpCache");
        Cache cache = new Cache(cacheFile, 20);
        Interceptor cacheInterceptor = new cacheInterceptor();
        builder.addInterceptor(cacheInterceptor);//添加本地缓存拦截器，拦截本地缓存
        builder.addNetworkInterceptor(cacheInterceptor);//添加网络拦截器，拦截网络数据
        builder.retryOnConnectionFailure(true);
        okHttpClient=builder.build();
    }



    private void initRetrofit(){
        retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
    /**
     * 缓存拦截器
     */
    class cacheInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!AppUtil.isNetworkConnected(mContext) || isUseCache) {//网络不可用或者设置只使用缓存
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            } else if (AppUtil.isNetworkConnected(mContext) && !isUseCache) {//网络可用，并且设置不实用缓存
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_NETWORK)
                        .build();
            }
            Response response = chain.proceed(request);
            if (AppUtil.isNetworkConnected(mContext)) {
                response = response.newBuilder()
                        .header("Cache-Control", "public,max-age=" + maxCacheTime)
                        .removeHeader("Pragma")
                        .build();
            }
            return response;
        }
    }
    /**
     * 添加线程管理并订阅
     *
     * @param subscriber 观察者
     * @param observable 被观察者
     */
    public void toSubcriber(Subscriber subscriber, Observable observable) {
        observable.subscribeOn(Schedulers.io())
                .all(new Func1() {
                    @Override
                    public Object call(Object o) {
                        return null;
                    }
                })
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}

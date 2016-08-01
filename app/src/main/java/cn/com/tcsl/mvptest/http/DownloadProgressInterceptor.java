package cn.com.tcsl.mvptest.http;

import java.io.IOException;

import cn.com.tcsl.mvptest.http.interfaces.DownProgressListener;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * 下载进度的拦截器，能够拦截到相关的下载进度，并通过下载进度接口回传给监听者
 * Created by wu on 2016/7/20.
 */
public class DownloadProgressInterceptor implements Interceptor {
    DownProgressListener mListener;

    public DownloadProgressInterceptor(DownProgressListener mListener) {
        this.mListener = mListener;
    }


    @Override
    public Response intercept(Chain chain) throws IOException {
        okhttp3.Response originalResponse = chain.proceed(chain.request());
        return originalResponse.newBuilder().body(
                new ProgressResponseBody( mListener,originalResponse.body()))
                .build();
    }
}

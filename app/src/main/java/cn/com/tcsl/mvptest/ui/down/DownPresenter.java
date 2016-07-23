package cn.com.tcsl.mvptest.ui.down;

import android.content.Intent;
import android.net.Uri;

import java.io.File;

import cn.com.tcsl.mvptest.http.HttpMethods;
import cn.com.tcsl.mvptest.http.interfaces.DownProgressListener;
import okhttp3.ResponseBody;
import rx.Subscriber;

/**
 * Created by wjx on 2016/7/23.
 */
public class DownPresenter implements DownContract.Presenter {
    DownContract.View view;
    DownContract.Model model;

    public DownPresenter(DownContract.View view) {
        this.view = view;
        model=new DownModel();
    }

    @Override
    public void downLoad(String url) {
        view.showProgress();
        DownProgressListener mListeren=new DownProgressListener() {
            @Override
            public void update(long current, long total, boolean isCompleted) {
                view.updateProgress((int)(100l*current/total));
            }
        };

        Subscriber<ResponseBody> subscriber=new Subscriber<ResponseBody>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ResponseBody responseBody) {
                view.dismisProgress();
                File file=model.writeToSD(responseBody.byteStream());
                view.intallAPK(file);
            }
        };
        HttpMethods.getDownInstance(mListeren).downLoad(subscriber,"http://hengdawb-app.oss-cn-hangzhou.aliyuncs.com/app-debug.apk");
    }



    @Override
    public void start() {

    }

    @Override
    public void onDestroy() {

    }
}

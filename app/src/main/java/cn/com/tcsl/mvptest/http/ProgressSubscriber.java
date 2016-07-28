package cn.com.tcsl.mvptest.http;

import android.content.Context;
import android.widget.Toast;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import cn.com.tcsl.mvptest.http.Utils.Constant;
import cn.com.tcsl.mvptest.http.interfaces.ProgressCancelListener;
import cn.com.tcsl.mvptest.http.interfaces.SubscriberOnNextListener;
import cn.com.tcsl.mvptest.service.ProgressDialogHandler;
import rx.Subscriber;

/**
 * 带有进度条的网络请求
 * Created by wu on 2016/7/20.
 */
public class ProgressSubscriber<T> extends Subscriber<T> implements ProgressCancelListener {
    ProgressDialogHandler mHandler;
    SubscriberOnNextListener mListener;
    Context mContext;

    /**
     * @param mListener
     * @param mContext
     * @param cancelable
     */
    public ProgressSubscriber(SubscriberOnNextListener mListener, Context mContext, boolean cancelable) {
        this.mListener = mListener;
        this.mContext = mContext;
        mHandler = new ProgressDialogHandler(mContext, this, cancelable);
    }


    @Override
    public void onStart() {
        super.onStart();
        showProgressDialog();
    }

    @Override
    public void onCompleted() {
        dismissProgressDialog();
    }


    @Override
    public void onError(Throwable e) {
        dismissProgressDialog();
        Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
        if(mListener!=null) {
            if (e instanceof SocketTimeoutException) {
                    mListener.onError("网络错误,，请检测网络状态", Constant.NETERROR);
            } else if (e instanceof ConnectException) {
                mListener.onError("网络错误,，请检测网络状态", Constant.NETERROR);
            }else if(e instanceof APIException){
                mListener.onError(((APIException)e).getMessage(),((APIException)e).getCode());
            }else {
                mListener.onError(e.getMessage(),Constant.UNKONWERROR);
            }
        }
    }

    @Override
    public void onNext(T t) {
        mListener.onNext(t);
    }

    @Override
    public void onCancelProgress() {
        if (this.isUnsubscribed()) {
            this.unsubscribe();
        }
    }

    /**
     * 关闭dialog
     */
    private void dismissProgressDialog() {
        if(mHandler!=null){
            mHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            mHandler=null;
        }
    }

    /**
     * 显示dialog
     */
    private void showProgressDialog() {
        if(mHandler!=null){
            mHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }


}

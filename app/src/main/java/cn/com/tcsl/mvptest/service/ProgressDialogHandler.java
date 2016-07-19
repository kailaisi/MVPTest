package cn.com.tcsl.mvptest.service;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.jakewharton.rxbinding.view.RxView;

import cn.com.tcsl.mvptest.interfaces.ProgressCancelListener;

/**
 * Created by wjx on 2016/7/19.
 */
public class ProgressDialogHandler extends Handler {
    public static final int SHOW_PROGRESS_DIALOG = 1;
    public static final int DISMISS_PROGRESS_DIALOG = 2;

    private ProgressDialog pd;
    private Context mContext;
    private ProgressCancelListener mListener;
    private boolean cancelable;

    public ProgressDialogHandler(Context mContext, ProgressCancelListener mListener, boolean cancelable) {
        super();
        this.mContext = mContext;
        this.mListener = mListener;
        this.cancelable = cancelable;
    }


    @Override
    public void handleMessage(Message msg) {
        switch (msg.what){
            case SHOW_PROGRESS_DIALOG:
                initProgressDialog();
                break;
            case DISMISS_PROGRESS_DIALOG:
                dismissProgressDialog();
        }
    }

    /**
     * 显示dialog
     */
    private void initProgressDialog() {
        if(pd==null){
            pd=new ProgressDialog(mContext);
            pd.setCancelable(cancelable);
            if(cancelable){
                rx.clicks(pd).
            }
        }
    }
}

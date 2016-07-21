package cn.com.tcsl.mvptest.service;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;

import cn.com.tcsl.mvptest.http.interfaces.ProgressCancelListener;

/**
 * 显示圆圈的进度条
 * Created by wjx on 2016/7/19.
 */
public class ProgressDialogHandler extends Handler {
    public static final int SHOW_PROGRESS_DIALOG = 1;
    public static final int DISMISS_PROGRESS_DIALOG = 2;

    private ProgressDialog pd;
    private Context mContext;
    private Activity context;
    private ProgressCancelListener mListener;
    private boolean cancelable;

    public ProgressDialogHandler(Context mContext, ProgressCancelListener mListener, boolean cancelable) {
        super();
        this.mContext = mContext;
        this.context= (Activity) mContext;
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
     * 关闭dialog
     */
    private void dismissProgressDialog() {
        if(pd!=null){
            pd.dismiss();
            pd=null;
        }

    }

    /**
     * 显示dialog
     */
    private void initProgressDialog() {
        if(pd==null && !context.isFinishing()){
            pd=new ProgressDialog(context);
            pd.setCancelable(cancelable);
            if(cancelable){
                pd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        mListener.onCancelProgress();
                    }
                });
            }
            if (!pd.isShowing()) {
                pd.show();
            }
        }
    }
}

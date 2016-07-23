package cn.com.tcsl.mvptest.http.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import cn.com.tcsl.mvptest.R;

/**
 * 下载进度的dialog
 * Created by wu on 2016/7/20.
 */
public class DownProgressDialog  extends ProgressDialog{
    public DownProgressDialog(Context context) {
        super(context);
    }

    public DownProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        setCancelable(false);
       setContentView(android.R.layout.);
    }

    @Override
    public void setProgress(int value) {
        super.setProgress(value);
    }
}

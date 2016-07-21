package cn.com.tcsl.mvptest.service;


import android.os.Handler;
import android.os.Message;

import com.daimajia.numberprogressbar.NumberProgressBar;

/**
 * Created by wu on 2016/7/20.
 */
public class DownProgressDialogHandler extends Handler {
    public static int DOWNLOAD_PROGRESS=1;
    NumberProgressBar progressBar;
    @Override
    public void handleMessage(Message msg) {
        switch (msg.what){
            case DOWNLOAD_PROGRESS:

        }
    }
}

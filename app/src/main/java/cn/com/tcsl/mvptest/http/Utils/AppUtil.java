package cn.com.tcsl.mvptest.http.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;

import java.io.File;

/**
 * 辅助类
 * Created by wjx on 2016/7/28.
 */
public class AppUtil {
    /**
     * 获取缓存路径
     *
     * @param context 上下文
     * @return 缓存的路径 如果存在SD卡，则缓存写入SD卡，否则写入手机内存
     */
    public static String getCacheDir(Context context) {
        if (context.getExternalCacheDir() != null && ExistSDCard()) {
            return context.getExternalCacheDir().toString();//sd/data/xx/data/下
        } else {
            return context.getCacheDir().toString();
        }
    }

    /**
     * 判断SD卡是否可用
     *
     * @return
     */
    private static boolean ExistSDCard() {
        return android.os.Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * 判断网络是否可以连接
     *
     * @param context
     * @return
     */
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (manager != null) {
                NetworkInfo info = manager.getActiveNetworkInfo();
                if (info != null && info.isConnected()) {
                    if (info.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


}

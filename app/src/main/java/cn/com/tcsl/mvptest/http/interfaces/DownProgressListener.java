package cn.com.tcsl.mvptest.http.interfaces;

/**
 * 下载或者上传的进度接口，用于更新UI进度
 * Created by wu on 2016/7/20.
 */
public interface DownProgressListener {
    /**
     *
     * @param current 当前进度
     * @param total 总进度
     * @param isCompleted 是否完成标志位
     */
    void update(long current, long total, boolean isCompleted);
}

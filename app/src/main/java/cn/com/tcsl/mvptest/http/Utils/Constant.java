package cn.com.tcsl.mvptest.http.Utils;

/**
 * 网络返回码信息
 * Created by wjx on 2016/7/28.
 */
public class Constant {
    /**
     * 成功
     */
    public static final int SUCCESS = 0;
    /**
     * 没有数据
     */
    public static final int EMPTY = -3;
    /**
     * 没有更多数据
     */
    public static final int NOMORE= -4;

    /**
     * 网络中断，请检查您的网络状态
     */
    public static final int NETERROR= -1000;
    /**
     * 未知错误
     */
    public static final int UNKONWERROR= -1001;
}

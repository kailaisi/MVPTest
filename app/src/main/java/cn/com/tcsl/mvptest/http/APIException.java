package cn.com.tcsl.mvptest.http;

/**
 * 自定义的异常情况,用于捕捉网络请求时的异常情况
 * Created by wjx on 2016/7/28.
 */
public class APIException extends RuntimeException{
    String msg;
    int code;

    public APIException(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}

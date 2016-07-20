package cn.com.tcsl.mvptest.http;

/**
 * http请求统一返回的数据，外层报过了对应的code和msg信息。data是所需要的json信息
 * Created by wu on 2016/7/20.
 */
public class HttpResult<T> {
    /**
     *
     */
    private String msg;
    /**
     *
     */
    private int resltCode;
    /**
     *
     */
    private T data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getResltCode() {
        return resltCode;
    }

    public void setResltCode(int resltCode) {
        this.resltCode = resltCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

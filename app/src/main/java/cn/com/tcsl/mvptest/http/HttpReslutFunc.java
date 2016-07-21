package cn.com.tcsl.mvptest.http;

import rx.functions.Func1;

/**
 * 将返回的包装进行解析，获取到具体的实体类，对于异常情况，改如何解析，有待研究
 * Created by wu on 2016/7/20.
 */
public class  HttpReslutFunc<T> implements Func1<HttpResult<T>,T>{

    @Override
    public T call(HttpResult<T> result) {
        if(result.getResltCode()==2000){
            return result.getData();
        }else{
            return null;
        }

    }
}
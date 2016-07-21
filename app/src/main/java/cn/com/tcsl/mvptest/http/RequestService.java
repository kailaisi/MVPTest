package cn.com.tcsl.mvptest.http;



import cn.com.tcsl.mvptest.bean.Login;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 所有的网络请求的函数
 * Created by wjx on 2016/7/19.
 */
public interface RequestService {
    @GET("MerchantLogin.htm")
    Observable<Login> userLogin(@Query("data") String data);
@GET
    Observable<ResponseBody> downLoad();
}

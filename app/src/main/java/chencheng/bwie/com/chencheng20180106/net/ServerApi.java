package chencheng.bwie.com.chencheng20180106.net;

import chencheng.bwie.com.chencheng20180106.Bean.GetCartdBean;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dell on 2018/1/6.
 */

public interface ServerApi {
    @GET("getCarts")
    Flowable<GetCartdBean> getCart(@Query("uid") int uid,@Query("source") String source);

}

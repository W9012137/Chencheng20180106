package chencheng.bwie.com.chencheng20180106.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dell on 2018/1/6.
 */

public class RetrofitUtils {

    private static OkHttpClient client;
    private static ServerApi serverApi;
    static {
        initRetro();
    }
    public static OkHttpClient initRetro(){
        if (client==null){
            synchronized (RetrofitUtils.class){
                if (client==null){
                    client=new OkHttpClient.Builder()
                            .connectTimeout(3000, TimeUnit.MILLISECONDS)
                            .build();
                }
            }
        }
        return client;
    }
    public static ServerApi getServerApi(){
        if (serverApi==null){
            synchronized (OkHttpClient.class){
                if (serverApi==null){
                    serverApi=onCreate(ServerApi.class,Api.HOST);
                }
            }
        }
        return  serverApi;
    }
    public static <T> T onCreate(Class<T> tClass ,String url){
        final Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .baseUrl(url)
                .build();
        return  retrofit.create(tClass);
    }
}

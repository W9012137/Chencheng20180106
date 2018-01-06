package chencheng.bwie.com.chencheng20180106.net;

/**
 * Created by dell on 2018/1/6.
 */

public interface NetonListent<T> {
    //成功
    void onSccess(T t);
    //失败
    void onFailuce(Exception e);
}

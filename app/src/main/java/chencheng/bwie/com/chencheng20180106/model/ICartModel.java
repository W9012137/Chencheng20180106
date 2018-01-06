package chencheng.bwie.com.chencheng20180106.model;

import chencheng.bwie.com.chencheng20180106.Bean.GetCartdBean;
import chencheng.bwie.com.chencheng20180106.net.NetonListent;

/**
 * Created by dell on 2018/1/6.
 */

public interface ICartModel {
    public void getCart(int uid, String str, final NetonListent<GetCartdBean> netonListent);
}

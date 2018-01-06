package chencheng.bwie.com.chencheng20180106.model;


import android.util.Log;

import chencheng.bwie.com.chencheng20180106.Bean.GetCartdBean;
import chencheng.bwie.com.chencheng20180106.net.NetonListent;
import chencheng.bwie.com.chencheng20180106.net.RetrofitUtils;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by dell on 2018/1/6.
 */

public class CarModel implements ICartModel {


    @Override
    public void getCart(int uid, String str, final NetonListent<GetCartdBean> netonListent) {
        Flowable flowable = RetrofitUtils.getServerApi().getCart(uid,str);
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<GetCartdBean>() {
                    @Override
                    public void accept(GetCartdBean cartBean) throws Exception {
                        netonListent.onSccess(cartBean);
                        Log.i("TAG",""+cartBean);
                    }
                });
    }
}

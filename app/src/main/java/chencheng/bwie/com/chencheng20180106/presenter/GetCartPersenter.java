package chencheng.bwie.com.chencheng20180106.presenter;

import java.util.ArrayList;
import java.util.List;

import chencheng.bwie.com.chencheng20180106.Bean.GetCartdBean;
import chencheng.bwie.com.chencheng20180106.model.CarModel;
import chencheng.bwie.com.chencheng20180106.model.ICartModel;
import chencheng.bwie.com.chencheng20180106.net.NetonListent;
import chencheng.bwie.com.chencheng20180106.view.IMainActivity;

/**
 * Created by dell on 2018/1/6.
 */

public class GetCartPersenter {
    private IMainActivity iMainActivity;
    private final ICartModel iCartModel;

    public GetCartPersenter(IMainActivity iMainActivity){
        this.iMainActivity=iMainActivity;
        iCartModel = new CarModel();
    }
    public void getCart(){
        iCartModel.getCart(71, "android", new NetonListent<GetCartdBean>() {
            @Override
            public void onSccess(GetCartdBean getCartdBean) {
                final List<GetCartdBean.DataBean> group = getCartdBean.getData();
                List<List<GetCartdBean.DataBean.ListBean>> child=new ArrayList<>();
                for (int i=0;i<group.size();i++){
                     GetCartdBean.DataBean dataBean = group.get(i);
                     List<GetCartdBean.DataBean.ListBean> list=dataBean.getList();
                     child.add(list);
                }
                iMainActivity.ShowList(group,child);
            }

            @Override
            public void onFailuce(Exception e) {
            }
        });
    }
}

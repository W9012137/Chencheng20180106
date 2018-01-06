package chencheng.bwie.com.chencheng20180106.view;

import java.util.List;

import chencheng.bwie.com.chencheng20180106.Bean.GetCartdBean;

/**
 * Created by dell on 2018/1/6.
 */

public interface IMainActivity {
    public void ShowList(List<GetCartdBean.DataBean> group,List<List<GetCartdBean.DataBean.ListBean>> child);
}

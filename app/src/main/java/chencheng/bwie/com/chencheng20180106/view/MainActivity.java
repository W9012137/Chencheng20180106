package chencheng.bwie.com.chencheng20180106.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.List;

import chencheng.bwie.com.chencheng20180106.Adapter;
import chencheng.bwie.com.chencheng20180106.Bean.GetCartdBean;
import chencheng.bwie.com.chencheng20180106.R;
import chencheng.bwie.com.chencheng20180106.presenter.GetCartPersenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,IMainActivity{

    private ExpandableListView mExView;
    /**
     * 全选
     */
    private CheckBox mCheckBox;
    /**
     * ￥0.0
     */
    private TextView mTextView;
    /**
     * 删除
     */
    private Button mButton;
    /**
     * 购买
     */
    private Button mButton2;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetCartPersenter persenter=new GetCartPersenter(this);
        persenter.getCart();
        initView();
    }

    private void initView() {
        mExView = (ExpandableListView) findViewById(R.id.exView);
        mCheckBox = (CheckBox) findViewById(R.id.checkBox);
        mTextView = (TextView) findViewById(R.id.textView);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
        mButton2 = (Button) findViewById(R.id.button2);
        mButton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.button:
                break;
            case R.id.button2:
                break;
        }
    }

    @Override
    public void ShowList(List<GetCartdBean.DataBean> group, List<List<GetCartdBean.DataBean.ListBean>> child) {
        adapter = new Adapter(group, child, MainActivity.this);
        mExView.setAdapter(adapter);
        for (int i=0;i<group.size();i++){
            mExView.expandGroup(i);
        }
    }
}

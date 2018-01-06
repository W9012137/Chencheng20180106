package chencheng.bwie.com.chencheng20180106;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import chencheng.bwie.com.chencheng20180106.Bean.GetCartdBean;

/**
 * Created by dell on 2018/1/6.
 */

public class Adapter extends BaseExpandableListAdapter {
    List<GetCartdBean.DataBean> group;
    List<List<GetCartdBean.DataBean.ListBean>> child;
    private Context context;

    public Adapter(List<GetCartdBean.DataBean> group, List<List<GetCartdBean.DataBean.ListBean>> child, Context context) {
        this.group = group;
        this.child = child;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return group.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return child.get(i).size();
    }

    @Override
    public Object getGroup(int i) {
        return group.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return child.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
         GroupView holder;
         if (view==null){
             view=View.inflate(context,R.layout.group,null);
               holder=new GroupView();
               holder.group_cb=view.findViewById(R.id.gx_group);
               holder.tv_group =  view.findViewById(R.id.tv_group);
               view.setTag(holder);
         }else{
             holder= (GroupView) view.getTag();
         }
        final GetCartdBean.DataBean dataBean = group.get(i);
         String str=dataBean.getSellerName();
         holder.group_cb.setChecked(dataBean.isIscheck());

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ChildView holder;
        if (view==null){
            view=View.inflate(context,R.layout.child,null);
            holder=new ChildView();
            holder.tv_title= view.findViewById(R.id.title);
            holder.price= view.findViewById(R.id.price);                //价格
            holder.child_cb= view.findViewById(R.id.gouxuan_child);   //子勾选
            holder.sdv= view.findViewById(R.id.title_img);
          /*  holder.jian= (ImageView) convertView.findViewById(R.id.jia);     //加加
            holder.del= (ImageView) convertView.findViewById(R.id.del);      //删除
            holder.add= (ImageView) convertView.findViewById(R.id.jian);    //减
            holder.tv_num= (TextView) convertView.findViewById(R.id.tv_num);  //数量
            holder.yanse= (TextView) convertView.findViewById(R.id.yanse);*/
            view.setTag(holder);
        }else{
            holder= (ChildView) view.getTag();
        }
        final GetCartdBean.DataBean.ListBean listBean = child.get(i).get(i1);
        int price=listBean.getPscid();
        holder.child_cb.setChecked(listBean.isIscheck());
        holder.price.setText("￥"+price);
        holder.tv_title.setText(listBean.getTitle());
        String images = listBean.getImages();
        String[] split = images.split("\\|");
        String s = split[0];
        Uri uri=Uri.parse(s);
        holder.sdv.setImageURI(uri);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
    class GroupView {
        CheckBox group_cb;
        TextView tv_group;
    }
    class ChildView{
        CheckBox child_cb;
        TextView tv_title,price,yanse,tv_num;
        SimpleDraweeView sdv;
    }
}

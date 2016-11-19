package com.wuzch.expandablelistviewlearning.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.wuzch.expandablelistviewlearning.Bean.Group;
import com.wuzch.expandablelistviewlearning.Bean.Item;
import com.wuzch.expandablelistviewlearning.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2016/11/6.
 */

/**
 * BaseExpandableListAdpter则分成了两部分：组和子列表 。
 *另外，有一点要注意的是，重写isChildSelectable()方法需要返回true，
 * 不然不会触发 子Item的点击事件！
 */
public class ExListAdapter extends BaseExpandableListAdapter {
    private ArrayList<Group> gData;
    private ArrayList<ArrayList<Item>> iData; //存储子列表
    private Context myContext;


    public ExListAdapter(Context myContext,ArrayList<Group> gData,ArrayList<ArrayList<Item>> iData){
        this.myContext=myContext;
        this.gData=gData;
        this.iData=iData;
    }
    @Override
    public int getGroupCount() {
        return gData.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return iData.get(groupPosition).size(); //得到存储子列表中的每一项
    }

    @Override
    public Object getGroup(int groupPosition) {
        return gData.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return iData.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    /**
     * 取得用于显示给定的分组对象视图，这个方法仅返回分组的视图对象
     * @param groupPosition
     * @param isExpanded
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolderGroup viewHolderGroup=null;
        if (convertView==null){
            convertView= LayoutInflater.from(myContext)
                        .inflate(R.layout.expandale_group,parent,false);
            viewHolderGroup=new ViewHolderGroup();
            viewHolderGroup.tv_group_name=(TextView) convertView.findViewById(R.id.myExpandable_Group_name);
            convertView.setTag(viewHolderGroup);
        }else {
            viewHolderGroup= (ViewHolderGroup) convertView.getTag();
        }
            viewHolderGroup.tv_group_name.setText(gData.get(groupPosition).getGroup_name());
        return convertView;
    }

    /**
     * 取得给定分组给定子位置的数据用的视图
     * @param groupPosition
     * @param childPosition
     * @param isLastChild
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolderItem viewHolderItem=null;
        if (convertView==null){
            convertView=LayoutInflater.from(myContext)
                        .inflate(R.layout.expandale_list_item,parent,false);
            viewHolderItem=new ViewHolderItem();
            viewHolderItem.circle_iv_item_icon= (CircleImageView) convertView.findViewById(R.id.item_icon);
            viewHolderItem.tv_item= (TextView) convertView.findViewById(R.id.item_text);
            convertView.setTag(viewHolderItem);
        }else {
            viewHolderItem= (ViewHolderItem) convertView.getTag();
        }
        viewHolderItem.circle_iv_item_icon.setImageResource(iData.get(groupPosition).
                                                get(childPosition).getItem_icon_Id());
        viewHolderItem.tv_item.setText(iData.get(groupPosition).get(childPosition).getItem_name());
        return convertView;
    }

    /**
     * 设置子列表是否可以选中
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
    private class ViewHolderGroup{
        private TextView tv_group_name;
    }
    private class ViewHolderItem{
        private CircleImageView circle_iv_item_icon;
        private TextView tv_item;
    }
}

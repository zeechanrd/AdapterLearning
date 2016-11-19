package com.wuzch.listviewlearningdemo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wuzch.listviewlearningdemo.R;
import com.wuzch.listviewlearningdemo.bean.Data;

import java.util.LinkedList;

/**
 * Created by Administrator on 2016/11/3.
 */

public class MyAdapter extends BaseAdapter {
    private Context myContext;
    private LinkedList<Data> myList;
    public MyAdapter(){

    }
    public MyAdapter(Context myContext,LinkedList<Data> myList){
        this.myContext=myContext;
        this.myList=myList;
    }
    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            convertView= LayoutInflater.from(myContext).inflate(R.layout.list_item,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.myimage = (ImageView) convertView.findViewById(R.id.myimage);
            viewHolder.mytitle = (TextView) convertView.findViewById(R.id.mytitle);
            viewHolder.mycontain= (TextView) convertView.findViewById(R.id.mycontain);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.myimage.setImageResource(myList.get(position).getImgid());
        viewHolder.mytitle.setText(myList.get(position).getTitle());
        viewHolder.mycontain.setText(myList.get(position).getContain());
        return convertView;
    }
    private class ViewHolder{
        ImageView myimage;
        TextView mytitle;
        TextView mycontain;
    }
    //添加一条数据
    public void add(Data data){
        if (myList==null){
            myList=new LinkedList<>();
        }
        myList.add(data);
        notifyDataSetChanged();
    }
    //指定位置添加数据
    public void add(int position,Data data){
        if (myList==null){
            myList=new LinkedList<>();
        }
        myList.add(position,data);
        notifyDataSetChanged();
    }
    //移除特定内容的数据
    public void remove(Data data){
        if (myList!=null){
            myList.remove(data);
        }
        notifyDataSetChanged();
    }
    public void remove(int position){
        if (myList!=null){
            myList.remove(position);
        }
        notifyDataSetChanged();
    }
    public void removeLast(){
        if (myList!=null){
            myList.removeLast();
        }
        notifyDataSetChanged();
    }
    public int getLastposition(){
        return myList.size()-1;
    }
}

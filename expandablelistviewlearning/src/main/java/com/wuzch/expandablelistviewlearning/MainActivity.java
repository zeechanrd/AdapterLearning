package com.wuzch.expandablelistviewlearning;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.wuzch.expandablelistviewlearning.Adapter.ExListAdapter;
import com.wuzch.expandablelistviewlearning.Bean.Group;
import com.wuzch.expandablelistviewlearning.Bean.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ExListAdapter exListAdapter;
    private ExpandableListView expandableListView=null;
    private ArrayList<Group> gData=null;
    private ArrayList<ArrayList<Item>> iData=null;
    private ArrayList<Item> childData=null;
    private Context myContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myContext=MainActivity.this;
        expandableListView= (ExpandableListView) findViewById(R.id.myExpandable_List);

        /**
         * 数据准备
         */
        gData=new ArrayList<Group>();
        iData=new ArrayList<ArrayList<Item>>();
        gData.add(new Group("Gif图"));
        gData.add(new Group("AD"));
        gData.add(new Group("AP"));
        gData.add(new Group("Tank"));
        gData.add(new Group("Android好难学啊!"));

        /**
         * 子数据准备
         */
        //Gif图
        childData=new ArrayList<Item>();
        childData.add(new Item(R.drawable.icon_024,"兔斯基"));
        iData.add(childData);
        //AD组
        childData=new ArrayList<Item>();
        childData.add(new Item(R.drawable.iv_lol_icon3,"剑圣"));
        childData.add(new Item(R.drawable.iv_lol_icon4,"德莱文"));
        childData.add(new Item(R.drawable.iv_lol_icon13,"男枪"));
        childData.add(new Item(R.drawable.iv_lol_icon14,"韦鲁斯"));
        iData.add(childData);
        //AP组
        childData=new ArrayList<Item>();
        childData.add(new Item(R.drawable.iv_lol_icon1, "提莫"));
        childData.add(new Item(R.drawable.iv_lol_icon7, "安妮"));
        childData.add(new Item(R.drawable.iv_lol_icon8, "天使"));
        childData.add(new Item(R.drawable.iv_lol_icon9, "泽拉斯"));
        childData.add(new Item(R.drawable.iv_lol_icon11, "狐狸"));
        iData.add(childData);
        //Tank组
        childData=new ArrayList<Item>();
        childData.add(new Item(R.drawable.iv_lol_icon2, "诺手"));
        childData.add(new Item(R.drawable.iv_lol_icon5, "德邦"));
        childData.add(new Item(R.drawable.iv_lol_icon6, "奥拉夫"));
        childData.add(new Item(R.drawable.iv_lol_icon10, "龙女"));
        childData.add(new Item(R.drawable.iv_lol_icon12, "狗熊"));
        iData.add(childData);

        //自己加的
        childData=new ArrayList<Item>();
        childData.add(new Item(R.drawable.ic_html,"Html 5"));
        childData.add(new Item(R.drawable.ic_eriri,"Eriri"));
        childData.add(new Item(R.drawable.ic_momo,"MoMo,もも,モモ"));
        childData.add(new Item(R.drawable.ic_icon_qitao,"哎，Android好难学"));
        iData.add(childData);

        exListAdapter=new ExListAdapter(myContext,gData,iData);
        expandableListView.setAdapter(exListAdapter);
        /**
         * 为子列表设置监听事件
         */
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(myContext,"你点击了"+iData.get(groupPosition).get(childPosition).getItem_name(),Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

}

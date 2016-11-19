package com.wuzch.viewpagerlearning;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;

import com.wuzch.viewpagerlearning.Adapter.MyAdapter2;

import java.util.ArrayList;

public class TwoActivity extends AppCompatActivity {
    private ViewPager my_ViewPager_two;
    private MyAdapter2 myAdpater;
    private ArrayList<View> viewLists=null;
    private ArrayList<String> titleLists=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        viewLists= new ArrayList<View>();
        titleLists=new ArrayList<String>();
        titleLists.add("橘黄");
        titleLists.add("浅粉红");
        titleLists.add("浅粉蓝");
        my_ViewPager_two= (ViewPager) findViewById(R.id.my_ViewPager_two);
        LayoutInflater inflater=getLayoutInflater();
        viewLists.add(inflater.inflate(R.layout.view_one,null,false));
        viewLists.add(inflater.inflate(R.layout.view_two,null,false));
        viewLists.add(inflater.inflate(R.layout.view_three,null,false));
        myAdpater=new MyAdapter2(viewLists,titleLists);
        my_ViewPager_two.setAdapter(myAdpater);

    }
}

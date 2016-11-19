package com.wuzch.viewpagerlearning;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;


import com.wuzch.viewpagerlearning.Adapter.MyAdapter;

import java.util.ArrayList;

public class OneActivity extends AppCompatActivity {
    private ViewPager my_ViewPager_one;
    private MyAdapter myAdpater;
    private ArrayList<View> viewLists=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        viewLists= new ArrayList<View>();
        my_ViewPager_one= (ViewPager) findViewById(R.id.my_ViewPager_one);
        LayoutInflater inflater=getLayoutInflater();
        viewLists.add(inflater.inflate(R.layout.view_one,null,false));
        viewLists.add(inflater.inflate(R.layout.view_two,null,false));
        viewLists.add(inflater.inflate(R.layout.view_three,null,false));
        myAdpater=new MyAdapter(viewLists);
        my_ViewPager_one.setAdapter(myAdpater);
    }
}

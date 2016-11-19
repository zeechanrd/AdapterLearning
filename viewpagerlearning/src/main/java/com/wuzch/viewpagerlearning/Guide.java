package com.wuzch.viewpagerlearning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.wuzch.viewpagerlearning.Adapter.MyAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/11/17.
 */

public class Guide extends Activity implements ViewPager.OnPageChangeListener{
    private ViewPager my_ViewPager_guide;
    private ArrayList<View> viewLists=null;
    private MyAdapter myAdapter;
    private ImageView images[];
    private int imgId[]={R.id.img_point1,R.id.img_point2,R.id.img_point3,};
    private Button btn_start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initViews();
        initImg();
    }
    private void initViews(){
        viewLists=new ArrayList<View>();
        my_ViewPager_guide= (ViewPager) findViewById(R.id.my_ViewPager_guide);
        LayoutInflater inflater=getLayoutInflater();
        viewLists.add(inflater.inflate(R.layout.guide_one,null,false));
        viewLists.add(inflater.inflate(R.layout.guide_two,null,false));
        viewLists.add(inflater.inflate(R.layout.guide_three,null,false));
        myAdapter=new MyAdapter(viewLists,this);
        btn_start= (Button) viewLists.get(2).findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Guide.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        my_ViewPager_guide.setAdapter(myAdapter);
        my_ViewPager_guide.addOnPageChangeListener(this);
    }
    private void initImg(){
        images=new ImageView[viewLists.size()];
        for (int i=0;i<viewLists.size();i++){
            images[i]= (ImageView) findViewById(imgId[i]);
        }
    }
    @Override
    public void onPageSelected(int position) {
        for (int i=0;i<images.length;i++){
            if (position==i){
                images[i].setImageResource(R.drawable.login_point_selected);
            }else {
                images[i].setImageResource(R.drawable.login_point);
            }
        }
    }
    //滑动时触发
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    //滑动状态改变触发
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

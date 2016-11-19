package com.wuzch.viewpagerlearning;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.wuzch.viewpagerlearning.Adapter.MyAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/11/15.
 */

public class FourActivity extends AppCompatActivity implements View.OnClickListener, OnPageChangeListener {
    private ViewPager my_ViewPager_four;
    private ImageView img_cursor;
    private TextView tv_one;
    private TextView tv_two;
    private TextView tv_three;

    private ArrayList<View> viewLists;
    private int offset=0;   //移动图片的
    private int cursorIndex=0;//当前页面的编号
    private int bmpWidth;   //移动图片的长度
    private int one=0;  //移动条滑动一页的距离
    private int two=0;  //移动条滑动两页的距离


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        initViews();
    }

    private void initViews(){
        my_ViewPager_four= (ViewPager) findViewById(R.id.my_ViewPager_four);
        tv_one= (TextView) findViewById(R.id.tv_one);
        tv_two= (TextView) findViewById(R.id.tv_two);
        tv_three= (TextView) findViewById(R.id.tv_three);
        img_cursor= (ImageView) findViewById(R.id.img_cursor);
        /**
         * 下划线设置
         */
        //获取图片宽度
        bmpWidth= BitmapFactory.decodeResource(getResources(),R.drawable.line).getWidth();
        //获取分辨率宽度
        DisplayMetrics displayMetrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWindow=displayMetrics.widthPixels;
        //计算偏移量
        offset=(screenWindow/3-bmpWidth)/2;
        Matrix matrix=new Matrix();
        matrix.postTranslate(offset,0);
        //设置动画的初始位置
        img_cursor.setImageMatrix(matrix);
        //移动的距离
        one=offset*2+bmpWidth;  //一页的偏移量
        two=one*2;      //两页的偏移量
        /**
         * ViewPager填充View，同时设置点击事件和页面切换事件
         */
        viewLists=new ArrayList<View>();
        LayoutInflater inflater= getLayoutInflater();
        viewLists.add(inflater.inflate(R.layout.view_one,null,false));
        viewLists.add(inflater.inflate(R.layout.view_two,null,false));
        viewLists.add(inflater.inflate(R.layout.view_three,null,false));
        my_ViewPager_four.setAdapter(new MyAdapter(viewLists));
        //设置当前ViewPager的页面,从0开始计算
        my_ViewPager_four.setCurrentItem(0);
        tv_one.setTextColor(Color.BLUE);

        tv_one.setOnClickListener(this);
        tv_two.setOnClickListener(this);
        tv_three.setOnClickListener(this);

        my_ViewPager_four.addOnPageChangeListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_one:
                my_ViewPager_four.setCurrentItem(0);
                break;
            case R.id.tv_two:
                my_ViewPager_four.setCurrentItem(1);
                break;
            case R.id.tv_three:
                my_ViewPager_four.setCurrentItem(2);
                break;
        }
    }

    @Override
    public void onPageSelected(int position) {
        Animation animation=null;
        switch (position){
            case 0:
                if (cursorIndex==1){
                    animation=new TranslateAnimation(one,0,0,0);
                }else if (cursorIndex==2){
                    animation=new TranslateAnimation(two,0,0,0);
                }
                tv_one.setTextColor(Color.BLUE);
                tv_two.setTextColor(Color.BLACK);
                tv_three.setTextColor(Color.BLACK);
                break;
            case 1:
                if (cursorIndex==0){
                    animation=new TranslateAnimation(offset,one,0,0);
                }else if (cursorIndex==2){
                    animation=new TranslateAnimation(two,one,0,0);
                }
                tv_two.setTextColor(Color.BLUE);
                tv_one.setTextColor(Color.BLACK);
                tv_three.setTextColor(Color.BLACK);
                break;
            case 2:
                if (cursorIndex==0){
                    animation=new TranslateAnimation(offset,two,0,0);
                }else  if (cursorIndex==1){
                    animation=new TranslateAnimation(one,two,0,0);
                }
                tv_three.setTextColor(Color.BLUE);
                tv_two.setTextColor(Color.BLACK);
                tv_one.setTextColor(Color.BLACK);
                break;

        }
        cursorIndex=position;
        //true表示图片停在动画结束位置
        animation.setFillAfter(true);
        animation.setDuration(250);
        img_cursor.startAnimation(animation);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

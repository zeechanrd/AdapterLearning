package com.wuzch.popupwindowlearning;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn_PopupWindow,btn_item_one,btn_item_two,btn_item_three;
    private Button btn_item_dismiss;
    private Context myContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myContext=MainActivity.this;
        btn_PopupWindow= (Button) findViewById(R.id.btn_popupwindow);
        btn_PopupWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPopupWindow(v);
            }
        });
    }

    private void initPopupWindow(View view){
        View v= LayoutInflater.from(myContext).inflate(R.layout.popupwindow_item,null,false);
        //bindView();
        //1、构建一个PopupWindow，参数一次是加载的View，宽高，是否显示焦点
        final PopupWindow myPopupWindow=new PopupWindow(v, ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);
        //设置动画
        myPopupWindow.setAnimationStyle(R.anim.popupwindow_anime);
        /**
         * 这些为了点击非PopupWindow区域，PopupWindow会消失的，如果没有下面的
         *代码的话，你会发现，当你把PopupWindow显示出来了，无论你按多少次后退键
         *PopupWindow并不会关闭，而且退不出程序，加上下述代码可以解决这个问题
         */
        myPopupWindow.setTouchable(true);
        myPopupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                /**
                 * 返回true的话，TouchEvent会被拦截，拦截后PopupWindow的onTouchEvent不会被调用，
                 * 这样点解外部区域无法解除
                 */
                return false;
            }
        });
        //要设置背景颜色才有效
        myPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        //设置显示的位置，参数依次是View,x偏移量，y偏移量
        myPopupWindow.showAsDropDown(view,50,0);

        btn_item_one= (Button) v.findViewById(R.id.btn_item_one);
        btn_item_two= (Button) v.findViewById(R.id.btn_item_two);
        btn_item_three=(Button) v.findViewById(R.id.btn_item_three);
        btn_item_dismiss= (Button) v.findViewById(R.id.btn_item_dismiss);

        btn_item_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(myContext,"你点击了"+btn_item_one.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        btn_item_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(myContext,"你点击了"+btn_item_two.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        btn_item_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(myContext,"你点击了"+btn_item_three.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        btn_item_dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //解除悬浮框
                myPopupWindow.dismiss();
            }
        });
    }
}

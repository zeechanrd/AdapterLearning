package com.wuzch.viewflipperlearning;

import android.app.Activity;
import android.content.Context;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {
    private Context myContext;
    private ViewFlipper myViewFlipper;
    private int imgId[]={R.drawable.ic_help_view_1,R.drawable.ic_help_view_2,
                         R.drawable.ic_help_view_3,R.drawable.ic_help_view_4};
    private final static int MIN_MOVE=200;  //最小距离
    private MyGestureListener myGestureListener;
    private GestureDetector myGestureDetector; //识别手势用的
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myContext=MainActivity.this;
        myViewFlipper= (ViewFlipper) findViewById(R.id.myViewFlipper);
        myGestureListener=new MyGestureListener();
        myGestureDetector=new GestureDetector(myContext,myGestureListener);

        //动态加入View
        for (int i=0;i<imgId.length;i++){
//            myViewFlipper.addView(getImageView(imgId[i]));
            myViewFlipper.addView(getImageView(iv,imgId[i]));
        }
    }
    //重写onTouchEvent触发MyGestureListener里的方法
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return myGestureDetector.onTouchEvent(event);
    }
    //自定义一个GestureListener,这个是View类下的，别写错哦！！！
    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX()-e2.getX()>MIN_MOVE){
                myViewFlipper.setInAnimation(myContext,R.anim.right_in);
                myViewFlipper.setOutAnimation(myContext,R.anim.right_out);
                myViewFlipper.showNext();
            }else if (e2.getX()-e1.getX()>MIN_MOVE){
                myViewFlipper.setInAnimation(myContext,R.anim.letf_in);
                myViewFlipper.setOutAnimation(myContext,R.anim.letf_out);
                myViewFlipper.showNext();
            }
            return true;
        }
    }

//    private ImageView getImageView(int imgId){
//        ImageView imageView=new ImageView(this);
//        imageView.setBackgroundResource(imgId);
//        return imageView;
//    }
    private ImageView getImageView(ImageView imageView,int imgId){
        //优化无效。方法不对。
        if (imageView==null){
            imageView=new ImageView(myContext);
            imageView.setBackgroundResource(imgId);
            imageView.setTag(imageView);
        }else {
            imageView= (ImageView) imageView.getTag();
        }

        return imageView;
    }
}

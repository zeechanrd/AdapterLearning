package com.wuzch.viewpagerlearning;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * Created by Administrator on 2016/11/17.
 */

public class Welcome extends Activity {
    private static boolean isFirstIn=false;
    private static final int  TIME=2000;
    private static final int GO_GUIDE=1000;
    private static final int GO_HOME=1001;

    private Handler my_handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case GO_GUIDE:
                    go_Gudie();
                    break;
                case GO_HOME:
                    go_Home();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);
        init();
    }
    private void init(){
        /**
         * 存储是否第一进入程序，如果是第一次进入程序就先打开引导页，不是则是直接跳转到主活动
         */
        SharedPreferences preferences=getSharedPreferences("view_welcome",MODE_PRIVATE);
        isFirstIn=preferences.getBoolean("isFirstIn",true);
        if (!isFirstIn){
            my_handler.sendEmptyMessageDelayed(GO_HOME,TIME);
        }else{
            my_handler.sendEmptyMessageDelayed(GO_GUIDE,TIME);
            Editor editor=preferences.edit();
            editor.putBoolean("isFirstIn",false);
            editor.commit();
        }
    }
    private void go_Home(){
        Intent i=new Intent(Welcome.this,MainActivity.class);
        startActivity(i);
        finish();
    }

    private void go_Gudie(){
        Intent i=new Intent(Welcome.this,Guide.class);
        startActivity(i);
        finish();
    }
}

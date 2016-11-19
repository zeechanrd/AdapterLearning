package com.wuzch.notificationlearning;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Context myContext;
    private Notification notification;
    private NotificationManager myManager;
    private Button btn_show_notification,btn_close_notification;
    Bitmap LargeBitmap=null;
    private final static int NOTIFY_1=1;    //Notification的id
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myContext=MainActivity.this;
        //创建大图标的BitMap
        LargeBitmap= BitmapFactory.decodeResource(getResources(),R.drawable.iv_lc_icon);
        myManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        bindView();
    }

    private void bindView(){
        btn_show_notification= (Button) findViewById(R.id.btn_show_notification);
        btn_close_notification= (Button) findViewById(R.id.btn_close_notification);
        btn_show_notification.setOnClickListener(this);
        btn_close_notification.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_show_notification:
                //点击Notification跳转到另外一个活动去
                Intent intent=new Intent(myContext,OtherActivity.class);
                PendingIntent pendingIntent=PendingIntent.getActivity(myContext,0,intent,0);
                Notification.Builder mBuilder=new Notification.Builder(myContext);
                mBuilder.setContentText("叶良辰")      //设置标题
                        .setContentText("我有一百种方法让你呆不下去")    //内容
                        .setSubText("--记住我叫叶良辰")        //内容下的小文字
                        .setTicker("收到一条叶良辰发送过来的信息")    //收到信息后状态栏显示的文字

                        .setWhen(System.currentTimeMillis())    //设置通知时间
                        .setSmallIcon(R.drawable.ic_lol_icon)   //小图标
                        .setLargeIcon(LargeBitmap)         //大图标

                        //设置默认的通知灯和振动器
                        .setDefaults(Notification.DEFAULT_LIGHTS|Notification.DEFAULT_VIBRATE)
//                        .setDefaults(Notification.DEFAULT_LIGHTS|Notification.DEFAULT_VIBRATE|Notification.DEFAULT_SOUND)
                        //设置自定义通知铃声
                        .setSound(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.biaobiao))

                        .setAutoCancel(true)    //设置点击后自动取消Notification
                        .setContentIntent(pendingIntent);   //设置pendingIntent

                notification=mBuilder.build();
                myManager.notify(NOTIFY_1,notification);
                break;
            case R.id.btn_close_notification:
                //关闭通知
                myManager.cancel(NOTIFY_1);
                break;
        }
    }
}

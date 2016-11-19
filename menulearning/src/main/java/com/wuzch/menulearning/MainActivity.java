package com.wuzch.menulearning;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //给不同颜色定义菜单项的标识
    final static int RED=110;
    final static int GREEN=111;
    final static int BLUE=112;
    final static int YELLOW=113;
    final static int BLACK=114;
    final static int MAGENTA =115;

    private TextView tv_test;
    private TextView tv_longpress_test;
    private Button btn_pop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_test= (TextView) findViewById(R.id.tv_test);
        tv_longpress_test= (TextView) findViewById(R.id.tv_longpress_test);
        registerForContextMenu(tv_longpress_test);
        btn_pop= (Button) findViewById(R.id.btn_pop);
        btn_pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(MainActivity.this,btn_pop,150);
                popupMenu.getMenuInflater().inflate(R.menu.menu_pop,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.chat:
                                Toast.makeText(MainActivity.this,"你点击了"+item.getTitle(),Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.add_friends:
                                Toast.makeText(MainActivity.this,"你点击了"+item.getTitle(),Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.scan:
                                Toast.makeText(MainActivity.this,"你点击了"+item.getTitle(),Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.money:
                                Toast.makeText(MainActivity.this,"你点击了"+item.getTitle(),Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.help:
                                Toast.makeText(MainActivity.this,"你点击了"+item.getTitle(),Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }
    //初始化菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        //onCreateOptionsMenu的参数menu，调用add方法添加 菜单，add(菜单项的组号，ID，排序号，标题)
        menu.add(1,RED,2,"红色");
        menu.add(1,GREEN,5,"绿色");
        menu.add(1,BLUE,3,"蓝色");
        menu.add(1,YELLOW,1,"黄色");
        menu.add(1, MAGENTA,4,"品红色");
        menu.add(1,BLACK,6,"黑色");
        return true;
    }
    //菜单项被选中是触发，这里完成事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.add_pop:
                Toast.makeText(MainActivity.this,"Shabi",Toast.LENGTH_SHORT).show();
                //问题无解决方法
                PopupMenu popupMenu=new PopupMenu(MainActivity.this,item.getActionView());
                popupMenu.getMenuInflater().inflate(R.menu.menu_pop,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.chat:
                                Toast.makeText(MainActivity.this,"你点击了"+item.getTitle(),Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.add_friends:
                                Toast.makeText(MainActivity.this,"你点击了"+item.getTitle(),Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.scan:
                                Toast.makeText(MainActivity.this,"你点击了"+item.getTitle(),Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.money:
                                Toast.makeText(MainActivity.this,"你点击了"+item.getTitle(),Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.help:
                                Toast.makeText(MainActivity.this,"你点击了"+item.getTitle(),Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                });
                try{
                    popupMenu.show();
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"麻痹",Toast.LENGTH_SHORT).show();
                }
                break;
            case RED:
                tv_test.setTextColor(Color.RED);
                break;
            case BLUE:
                tv_test.setTextColor(Color.BLUE);
                break;
            case GREEN:
                tv_test.setTextColor(Color.GREEN);
                break;
            case YELLOW:
                tv_test.setTextColor(Color.YELLOW);
                break;
            case MAGENTA:
                tv_test.setTextColor(Color.MAGENTA);
                break;
            case BLACK:
                tv_test.setTextColor(Color.BLACK);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //加载菜单
        MenuInflater inflater=new MenuInflater(this);
        inflater.inflate(R.menu.menu_context,menu);
        menu.setHeaderTitle("选择颜色");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.blue:
                tv_longpress_test.setTextColor(Color.BLUE);

                break;
            case R.id.red:
                tv_longpress_test.setTextColor(Color.RED);
                break;
            case R.id.green:
                tv_longpress_test.setTextColor(Color.GREEN);
                break;
        }
        return super.onContextItemSelected(item);
    }
}

package com.wuzch.listviewlearningdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.wuzch.listviewlearningdemo.Adapter.MyAdapter;
import com.wuzch.listviewlearningdemo.bean.Data;


import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MyAdapter adapter=null;
    private Context myContext;
    private ListView list_item;
    private List<Data> myList=null;
    private TextView text_empty;
    private Button btnadd_one,btnadd_position,btnremove,btnremove_position,btn_remove_data;
    private int flag=1;
    private Data myData_5; //用于存放临时对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myContext=MainActivity.this;
        myList=new LinkedList<Data>();
        adapter=new MyAdapter(myContext, (LinkedList<Data>) myList);
        bindView();
    }

    private void bindView(){
        btnadd_one= (Button) findViewById(R.id.add_one);
        btnadd_position= (Button) findViewById(R.id.add_two);
        btnremove= (Button) findViewById(R.id.remove_one);
        btnremove_position= (Button) findViewById(R.id.remove_two);
        btn_remove_data= (Button) findViewById(R.id.remove_three);
        text_empty= (TextView) findViewById(R.id.text_empty);

        text_empty.setText("暂无数据");
        list_item= (ListView) findViewById(R.id.list_one);
        //当列表无数据时，就显示该TextView
        list_item.setEmptyView(text_empty);
        //貌似无效
        list_item.setSelection(adapter.getLastposition());
        list_item.setAdapter(adapter);

        btnadd_one.setOnClickListener(this);
        btnadd_position.setOnClickListener(this);
        btnremove.setOnClickListener(this);
        btnremove_position.setOnClickListener(this);
        btn_remove_data.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_one:
                if (flag==5){
                    myData_5=new Data(R.drawable.ic_html,"Html\t X\t"+flag,"Fuck the Html");
                    adapter.add(myData_5);
                }else{
                    if (flag%2!=0&&flag!=5){
                        adapter.add(new Data(R.drawable.ic_momo,"梦梦\t X\t"+flag,"tolove Darkness"));
                    }else{
                        adapter.add(new Data(R.drawable.ic_eriri,"英莉莉\t X\t"+flag,"no 欧派"));
                    }
                }
                flag++;
                break;
            case R.id.add_two:
                //position从0开始算
                adapter.add(4,new Data(R.drawable.ic_icon_qitao,"唉，Android好难学\t X\t"+flag,"Android难学"));
                flag++;
                break;
            case R.id.remove_one:
                adapter.remove(myData_5);
                flag--;
                break;
            case R.id.remove_two:
                try {
                    adapter.remove(2);
                    flag--;
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"已经删除了",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.remove_three:
                if (!myList.isEmpty()){
                    adapter.removeLast();
                    flag--;
                }else {
                    Toast.makeText(MainActivity.this,"无数据",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}

package com.wuzch.adapterlearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ArraryAdapterDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        String[] data=new String[]{"Android","好难学","没时间~~","唉，想哭","好后悔",
//                    "Android","好难学","没时间~~","唉，想哭","好后悔",
//                    "Android","好难学","没时间~~","唉，想哭","好后悔"};

        List<String> data=new ArrayList<String>();
        for (int i=0;i<15;i++){
            int index=i+1;
            data.add("Android好难学:"+index);
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,data);
        ListView list_test= (ListView) findViewById(R.id.myListView);
        list_test.setAdapter(adapter);
    }

}

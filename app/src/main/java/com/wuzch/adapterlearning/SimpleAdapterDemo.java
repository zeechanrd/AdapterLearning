package com.wuzch.adapterlearning;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/2.
 */

public class SimpleAdapterDemo extends AppCompatActivity {
    private String[] name=new String[]{"梦梦","Html5","英莉莉"};
    private String[] said=new String[]{"toLove darkness","fuck the Html","no 欧派"};
    private int[] img=new int[]{R.drawable.ic_momo,R.drawable.ic_html,R.drawable.ic_eriri};
    private List<Map<String,Object>> data;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data=new ArrayList<Map<String, Object>>();
        for (int i=0;i<name.length;i++){
            Map<String,Object> showItem=new HashMap<String,Object>();
            showItem.put("imgface",img[i]);
            showItem.put("names",name[i]);
            showItem.put("says",said[i]);
            data.add(showItem);
        }
        final SimpleAdapter adapter=new SimpleAdapter(getApplicationContext(),data,
                    R.layout.simpleadpater_layout,new String[]{"imgface","names","says"},
                    new int[]{R.id.imgface,R.id.name,R.id.said});
        ListView list_test= (ListView) findViewById(R.id.myListView);
        list_test.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                data.add(data.get(position));
                adapter.notifyDataSetChanged();
            }
        });
        list_test.setAdapter(adapter);
    }
}

package com.wuzch.viewpagerlearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_ViewPager_one,btn_ViewPager_two,btn_ViewPager_three,btn_ViewPager_four;
    private Button btn_go_guide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BindView();
    }
    private void BindView(){
        btn_ViewPager_one = (Button) findViewById(R.id.btn_ViewPager_one);
        btn_ViewPager_two= (Button) findViewById(R.id.btn_ViewPager_two);
        btn_ViewPager_three= (Button) findViewById(R.id.btn_ViewPager_three);
        btn_ViewPager_four= (Button) findViewById(R.id.btn_ViewPager_four);
        btn_go_guide= (Button) findViewById(R.id.btn_go_guide);
        btn_ViewPager_one.setOnClickListener(this);
        btn_ViewPager_two.setOnClickListener(this);
        btn_ViewPager_three.setOnClickListener(this);
        btn_ViewPager_four.setOnClickListener(this);
        btn_go_guide.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_ViewPager_one:
                startActivity(new Intent(this,OneActivity.class));
                break;
            case R.id.btn_ViewPager_two:
                startActivity(new Intent(this,TwoActivity.class));
                break;
            case R.id.btn_ViewPager_three:
                startActivity(new Intent(this,ThreeActivity.class));
                break;
            case R.id.btn_ViewPager_four:
                startActivity(new Intent(this,FourActivity.class));
                break;
            case R.id.btn_go_guide:
                startActivity(new Intent(this,Guide.class));
                break;
        }
    }
}

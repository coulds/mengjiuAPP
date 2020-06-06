package com.example.mengjiu;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;


public class AllActivity extends AppCompatActivity {
    private final static String TAG="Mengjiu";
    private Button allb2;
    private Button allb3;
    private Button allb4;
    private Button allb5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();//隐藏标题栏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        //点击进入代配送订单页
        allb3=findViewById(R.id.all_b3);
        allb3.setOnClickListener(v->{
            Log.d(TAG,"点击待配送订单！前往待配送订单页面");
            Intent intent=new Intent(AllActivity.this,ShippingActivity.class);
            startActivity(intent);
        });

        //点击进入待评价订单页
        allb4=findViewById(R.id.all_b4);
        allb4.setOnClickListener(v->{
            Log.d(TAG,"点击待评论订单！前往待评论订单页面");
            Intent intent=new Intent(AllActivity.this,EvaluatedActivity.class);
            startActivity(intent);
        });

        //点击进入完成订单页
        allb5=findViewById(R.id.all_b5);
        allb5.setOnClickListener(v->{
            Log.d(TAG,"点击完成订单！前往完成订单页面");
            Intent intent=new Intent(AllActivity.this,FinishActivity.class);
            startActivity(intent);
        });
        allb2=findViewById(R.id.all_b2);
        allb2.setOnClickListener(v->{
            Intent intent=new Intent(AllActivity.this,DashboardActivity.class);
            startActivity(intent);
        });
    }
}

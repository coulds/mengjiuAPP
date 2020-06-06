package com.example.mengjiu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class FinishActivity extends AppCompatActivity {
    private final static String TAG="Mengjiu";
    private Button finishb1;
    private Button finishb2;
    private Button finishb3;
    private Button finishb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();//隐藏标题栏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        //点击进入全部订单页
        finishb1=findViewById(R.id.all_b3);
        finishb1.setOnClickListener(v->{
            Log.d(TAG,"点击全部订单！前往全部订单页面");
            Intent intent=new Intent(FinishActivity.this,AllActivity.class);
            startActivity(intent);
        });

        //点击进入带配送订单页
        finishb3=findViewById(R.id.all_b4);
        finishb3.setOnClickListener(v->{
            Log.d(TAG,"点击待配送订单！前往待配送订单页面");
            Intent intent=new Intent(FinishActivity.this,ShippingActivity.class);
            startActivity(intent);
        });

        //点击进入待评价订单页
        finishb4=findViewById(R.id.all_b5);
        finishb4.setOnClickListener(v->{
            Log.d(TAG,"点击待评价订单！前往待评价订单页面");
            Intent intent=new Intent(FinishActivity.this,EvaluatedActivity.class);
            startActivity(intent);
        });
    }
}

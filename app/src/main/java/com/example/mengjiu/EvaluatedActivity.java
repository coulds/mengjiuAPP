package com.example.mengjiu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class EvaluatedActivity extends AppCompatActivity {
    private final static String TAG="Mengjiu";
    private Button evaluatedb1;
    private Button evaluatedb2;
    private Button evaluatedb3;
    private Button evaluatedb5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();//隐藏标题栏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluated);
        //点击进入全部订单页
        evaluatedb1=findViewById(R.id.evaluated_b1);
        evaluatedb1.setOnClickListener(v->{
            Log.d(TAG,"点击全部订单！前往全部订单页面");
            Intent intent=new Intent(EvaluatedActivity.this,AllActivity.class);
            startActivity(intent);
        });
        //点击进入代配送订单页
        evaluatedb3=findViewById(R.id.evaluated_b3);
        evaluatedb3.setOnClickListener(v->{
            Log.d(TAG,"点击待配送订单！前往待配送订单页面");
            Intent intent=new Intent(EvaluatedActivity.this,ShippingActivity.class);
            startActivity(intent);
        });
        //点击进入完成订单页
        evaluatedb5=findViewById(R.id.evaluated_b5);
        evaluatedb5.setOnClickListener(v->{
            Log.d(TAG,"点击完成订单！前往完成订单页面");
            Intent intent=new Intent(EvaluatedActivity.this,FinishActivity.class);
            startActivity(intent);
        });
    }
}

package com.example.mengjiu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class ShippingActivity extends AppCompatActivity {
    private final static String TAG="Mengjiu";
    private Button shippingb1;
    private Button shippingb2;
    private Button shippingb4;
    private Button shippingb5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();//隐藏标题栏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping);

        //点击进入全部订单页
        shippingb1=findViewById(R.id.shipping_b1);
        shippingb1.setOnClickListener(v->{
            Log.d(TAG,"点击全部订单！前往全部订单页面");
            Intent intent=new Intent(ShippingActivity.this,AllActivity.class);
            startActivity(intent);
        });
        //点击进入全部订单页
        shippingb4=findViewById(R.id.shipping_b4);
        shippingb4.setOnClickListener(v->{
            Log.d(TAG,"点击全部订单！前往全部订单页面");
            Intent intent=new Intent(ShippingActivity.this,EvaluatedActivity.class);
            startActivity(intent);
        });//点击进入全部订单页
        shippingb5=findViewById(R.id.shipping_b5);
        shippingb5.setOnClickListener(v->{
            Log.d(TAG,"点击全部订单！前往全部订单页面");
            Intent intent=new Intent(ShippingActivity.this,FinishActivity.class);
            startActivity(intent);
        });
    }
}
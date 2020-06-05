package com.example.mengjiu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class ShippingActivity extends AppCompatActivity {
    private final static String TAG="Mengjiu";
    private Button shippingb1;


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
    }
}
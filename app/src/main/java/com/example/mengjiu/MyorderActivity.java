package com.example.mengjiu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MyorderActivity extends AppCompatActivity {
    private Button dash_my;
    private Button login_my;
    private Button home_my;
    private Button mywddd;
    private Button mywdsc;
    private Button myyhq;
    private Button myqianbao;
    private Button mykfzx;
    private Button myshez;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();//隐藏标题栏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorder);
        //跳转登录页
        login_my=findViewById(R.id.myorder_login);
        login_my.setOnClickListener(v->{
            Intent intent=new Intent(MyorderActivity.this,LoginActivity.class);
            startActivity(intent);
        });
        //跳转账单页
        dash_my=findViewById(R.id.myorder_dashboard);
        dash_my.setOnClickListener(v->{
            Intent intent=new Intent(MyorderActivity.this,DashboardActivity.class);
            startActivity(intent);
        });
        //跳转主页
        home_my=findViewById(R.id.myorder_home);
        home_my.setOnClickListener(v->{
            Intent intent=new Intent(MyorderActivity.this,HomeActivity.class);
            startActivity(intent);
        });
        //跳转我的订单
        mywddd=findViewById(R.id.my_wddd);
        mywddd.setOnClickListener(v->{
            Intent intent=new Intent(MyorderActivity.this,AllActivity.class);
            startActivity(intent);
        });
        //跳转我的收藏
        mywdsc=findViewById(R.id.my_wdsc);
        mywdsc.setOnClickListener(v->{
            Intent intent=new Intent(MyorderActivity.this,My_collection.class);
            startActivity(intent);
        });
        //跳转优惠券
        myyhq=findViewById(R.id.my_yhq);
        myyhq.setOnClickListener(v->{
            Intent intent=new Intent(MyorderActivity.this,Myordercoupon.class);
            startActivity(intent);
        });
        //跳转钱包
        myqianbao=findViewById(R.id.my_qianbao);
        myqianbao.setOnClickListener(v->{
            Intent intent=new Intent(MyorderActivity.this,Myorderwallet.class);
            startActivity(intent);
        });
        //跳转客服中心
        mykfzx=findViewById(R.id.my_hfzx);
        mykfzx.setOnClickListener(v->{
            Intent intent=new Intent(MyorderActivity.this,Mykehuzx.class);
            startActivity(intent);
        });
        //跳转设置
        myshez=findViewById(R.id.my_shez);
        myshez.setOnClickListener(v->{
            Intent intent=new Intent(MyorderActivity.this, My_favorite.class);
            startActivity(intent);
        });
    }

}

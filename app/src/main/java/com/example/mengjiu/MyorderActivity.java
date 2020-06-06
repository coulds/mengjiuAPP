package com.example.mengjiu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MyorderActivity extends AppCompatActivity {
    private Button dash_my;
    private Button login_my;
    private Button home_my;

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
    }
}

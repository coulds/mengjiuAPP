package com.example.mengjiu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    private Button dash_home;
    private Button login_home;
    private Button my_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();//隐藏标题栏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //跳转登录页
        login_home=findViewById(R.id.home_login);
        login_home.setOnClickListener(v->{
            Intent intent=new Intent(HomeActivity.this,LoginActivity.class);
            startActivity(intent);
        });
        //跳转账单页
        dash_home=findViewById(R.id.home_dashboard);
        dash_home.setOnClickListener(v->{
            Intent intent=new Intent(HomeActivity.this,DashboardActivity.class);
            startActivity(intent);
        });
        //跳转我的页
        my_home=findViewById(R.id.home_myorder);
        my_home.setOnClickListener(v->{
            Intent intent=new Intent(HomeActivity.this,MyorderActivity.class);
            startActivity(intent);
        });
    }
}

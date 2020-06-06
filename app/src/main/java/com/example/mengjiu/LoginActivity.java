package com.example.mengjiu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    private final static String TAG="Mengjiu";
    private Button loginButton1;
    private Button dash_login;
    private Button my_login;
    private Button home_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();//隐藏标题栏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //跳转账单页
        dash_login=findViewById(R.id.login_dashboard);
        dash_login.setOnClickListener(v->{
            Intent intent=new Intent(LoginActivity.this,DashboardActivity.class);
            startActivity(intent);
        });
        //跳转主页页
        home_login=findViewById(R.id.login_home);
        home_login.setOnClickListener(v->{
            Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(intent);
        });
        //跳转我的页
        my_login=findViewById(R.id.login_myorder);
        my_login.setOnClickListener(v->{
            Intent intent=new Intent(LoginActivity.this,MyorderActivity.class);
            startActivity(intent);
        });

        //实现从登陆界面到注册页面的跳转
        loginButton1 =findViewById(R.id.notifications_login_button1);
        loginButton1.setOnClickListener(v->{
            Log.d(TAG,"点击注册跳转注册页！");
            Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(intent);
        });
    }
}

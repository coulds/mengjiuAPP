package com.example.mengjiu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {
    private final static String TAG="Mengjiu";
    private Button button4Button;
    private Button button7Button;
    private Button button6Button;
    private Button button5Button;
    private Button login_dash;
    private Button my_dash;
    private Button home_dash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();//隐藏标题栏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //跳转登录页
        login_dash=findViewById(R.id.dashboard_login);
        login_dash.setOnClickListener(v->{
            Intent intent=new Intent(DashboardActivity.this,LoginActivity.class);
            startActivity(intent);
        });
        //跳转主页页
        home_dash=findViewById(R.id.dashboard_home);
        home_dash.setOnClickListener(v->{
            Intent intent=new Intent(DashboardActivity.this,HomeActivity.class);
            startActivity(intent);
        });
        //跳转我的页
        my_dash=findViewById(R.id.dashboard_myorder);
        my_dash.setOnClickListener(v->{
            Intent intent=new Intent(DashboardActivity.this,MyorderActivity.class);
            startActivity(intent);
        });

        //实现从账单界面到全部订单页面的跳转
        button4Button =findViewById(R.id.dashboard_button4);
        button4Button.setOnClickListener(v->{
            Log.d(TAG,"点击全部跳转全部订单页！");
            Intent intent=new Intent(DashboardActivity.this,AllActivity.class);
            startActivity(intent);
        });

        //实现从账单界面到待配送订单页面的跳转
        button7Button =findViewById(R.id.dashboard_button7);
        button7Button.setOnClickListener(v->{
            Intent intent=new Intent(DashboardActivity.this,ShippingActivity.class);
            startActivity(intent);
        });
        //实现从账单界面到待评价订单页面的跳转
        button6Button = findViewById(R.id.dashboard_button6);
        button6Button.setOnClickListener(v->{
            Intent intent=new Intent(DashboardActivity.this, EvaluatedActivity.class);
            startActivity(intent);
        });
        //实现从账单界面到待完成订单页面的跳转
        button5Button =findViewById(R.id.dashboard_button5);
        button5Button.setOnClickListener(v->{
            Intent intent=new Intent(DashboardActivity.this, FinishActivity.class);
            startActivity(intent);
        });
    }
}

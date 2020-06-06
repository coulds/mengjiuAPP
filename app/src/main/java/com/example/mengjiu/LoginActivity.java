package com.example.mengjiu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    public static String name;
    private final static String TAG="Mengjiu";
    private Button loginButton1;
    private Button dash_login;
    private TextView findpasswordButton;
    private Button my_login;
    private String user;
    private Button home_login;
    private Button loginButton;
    final boolean[] tiyan = {true};
    private UserLab lab =UserLab.getInstance();
    private Mypreference prefs = Mypreference.getInstance();
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg){
            if (null!=msg){
                switch (msg.what){
                    case UserLab.USER_LOGIN_SUCCESS:
                        loginSucess(msg.obj);
                        TextInputLayout username=findViewById(R.id.notifications_textInputLayout1);
                        name=username.getEditText().getText().toString();
                        break;
                    case UserLab.USER_LOGIN_PASSWORD_ERROR:
                        loginPasswordError();
                        break;
                    case UserLab.USER_LOGIN_NET_ERROR:
                        loginFailed();
                        break;
                }
            }
        }
    };

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

        //实现登录APP模块
        loginButton=findViewById(R.id.notifications_login_button);
        loginButton.setOnClickListener(v->{
            TextInputLayout username=findViewById(R.id.notifications_textInputLayout1);
            TextInputLayout password=findViewById(R.id.notifications_textInputLayout2);
            user=username.getEditText().getText().toString();
            String p=password.getEditText().getText().toString();

            //判断
            if (TextUtils.isEmpty(user)){
                Toast.makeText(LoginActivity.this,"请输入用户名！",Toast.LENGTH_LONG).show();
                return;
            }else if (TextUtils.isEmpty(p)){
                Toast.makeText(LoginActivity.this,"请输入密码！",Toast.LENGTH_LONG).show();
                return;
            }else {
                // 调用retrofit
                lab.login(user, p, handler);
            }
        });
        // TODO 还未实现找回密码，目前不能找回密码
        findpasswordButton=findViewById(R.id.notifications_login_find_passworld);
        findpasswordButton.setOnClickListener(v->{
            Log.e(TAG,"找回失败！密码找回通道未开发");
            //TODO 暂时不跳转
            //Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            //startActivity(intent);
            Toast.makeText(LoginActivity.this,"暂时未开发找回密码通道！",Toast.LENGTH_LONG).show();
        });
        prefs.setup(getApplicationContext());

    }

    private void loginSucess(Object token){
        Toast.makeText(LoginActivity.this,"登录成功！",Toast.LENGTH_LONG).show();
        Log.d(TAG,"服务器返回的token是："+token);
        prefs.saveUser(user,(String) token);
        Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
        startActivity(intent);
    }

    private void loginPasswordError(){
        Toast.makeText(LoginActivity.this,"密码错误，请重新输入！",Toast.LENGTH_LONG).show();
    }

    private void loginFailed(){
        Toast.makeText(LoginActivity.this,"服务器错误，请稍后再试！",Toast.LENGTH_LONG).show();
    }
}

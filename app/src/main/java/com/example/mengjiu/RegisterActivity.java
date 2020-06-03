package com.example.mengjiu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {
    private final static String TAG="Mengjiu";
    private ImageView useravatar;
    private Button registerButton;
    private UserLab lab =UserLab.getInstance();
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg){
            if (null!=msg){
                switch (msg.what){
                    case UserLab.USER_REGISTER_SUCCESS:
                        ReqisterSucess();
                        break;
                    case UserLab.USER_REGISTER_NET_ERROR:
                        ReqisterFailed();
                        break;
                }
            }
        }
    };

    private void ReqisterSucess(){
        Toast.makeText(RegisterActivity.this,"注册成功！",Toast.LENGTH_LONG).show();
        //跳转登录界面
        //TODO 跳转失败
//        Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
//        startActivity(intent);
    }

    private void ReqisterFailed(){
        Toast.makeText(RegisterActivity.this,"服务器错误，请稍后再试！",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWindow();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //注册按钮
        registerButton=findViewById(R.id.register_button);
        registerButton.setOnClickListener(v->{
            register();
        });
    }

    private void initWindow() {//初始化，将状态栏和标题栏设为透明或者隐藏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//因为不是所有的系统都可以设置颜色的，在4.4以下就不可以。。有的说4.1，所以在设置的时候要检查一下系统版本是否是4.1以上
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));//通知栏所需颜色
        }
        setContentView(R.layout.activity_register);

        /**
         * 标题栏处理
         */
        // 标题栏居中显示
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(R.layout.title_name_register);
            TextView textView = (TextView) actionBar.getCustomView().findViewById(R.id.display_title_register);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowCustomEnabled(true);

        }
    }
    /**
     * 实现返回键按钮
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish(); // 返回按钮
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //获取登录信息
    private void register(){
        User u =new User();
        boolean error=false;
        String errorMessage;

        //头像
        //TODO 暂时不能设置用户头像
        useravatar=findViewById(R.id.register_logo);
        useravatar.setOnClickListener(v->{
            Log.e(TAG,"不能设置头像！头像上传通道未开发");
            Toast.makeText(RegisterActivity.this,"暂时未开发头像上传通道！",Toast.LENGTH_LONG).show();
        });

        //用户名
        TextInputLayout usernameInput =findViewById(R.id.register_textInputLayout1);
        Editable username =usernameInput.getEditText().getText();
        if(TextUtils.isEmpty(username)) {
            Toast.makeText(RegisterActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
            return;
        }else {
            u.setUsername(username != null ? username.toString() : "");
        }

        //判断密码并获取
        TextInputLayout passwordInput =findViewById(R.id.register_textInputLayout2);
        TextInputLayout confirmpasswordInput =findViewById(R.id.register_textInputLayout3);
        Editable password =passwordInput.getEditText().getText();
        Editable confirmpassword =confirmpasswordInput.getEditText().getText();
        if (TextUtils.isEmpty(password)){
            Toast.makeText(RegisterActivity.this, "请输入6-20位密码！", Toast.LENGTH_SHORT).show();
            return;
        }else if (password.length()<6 || password.length()>20){
            Toast.makeText(RegisterActivity.this, "请输入6-20位密码！", Toast.LENGTH_SHORT).show();
            return;
        }else {
            if (TextUtils.isEmpty(confirmpassword)){
                Toast.makeText(RegisterActivity.this, "请再次输入密码！", Toast.LENGTH_SHORT).show();
                return;
            }else if (password!=null&&confirmpassword!=null){
                if (!confirmpassword.toString().equals(password.toString())){
                    error =true;
                    errorMessage="两次输入密码不一样！";
                    Toast.makeText(RegisterActivity.this,"两次密码输入不一样，请重新输入！",Toast.LENGTH_LONG).show();
                    return;
                }else {
                    u.setPassword(password.toString());
                }
            }
        }

        //手机号
        TextInputLayout phoneInput =findViewById(R.id.register_textInputLayout4);
        Editable phone =phoneInput.getEditText().getText();
        String phone_number = phone.toString().trim();
        String num = "[1][35789]\\d{9}";
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(RegisterActivity.this, "请输入手机号！", Toast.LENGTH_SHORT).show();
            return;
        }else if (phone.length()!=11) {
            Toast.makeText(RegisterActivity.this, "您的电话号码位数不正确", Toast.LENGTH_LONG).show();
            return;
        }else if (!phone_number.matches(num)) {
            Toast.makeText(RegisterActivity.this, "请输入正确的电话号码！", Toast.LENGTH_LONG).show();
            return;
        }else {
            u.setPhone(phone != null ? phone.toString() : "");
        }

        //性别
        RadioGroup genderGroup =findViewById(R.id.register_sex);
        int gender =genderGroup.getCheckedRadioButtonId();
        switch (gender){
            case R.id.register_male:
                u.setGender("男");
                break;
            case R.id.register_femle:
                u.setGender("女");
                break;
            default:
                u.setGender("保密");
        }

        //判断数据
        //判断输入框内容
        if(isExistUserName(username)){
            Toast.makeText(RegisterActivity.this, "此账户名已经存在", Toast.LENGTH_SHORT).show();
            return;
        }else {
            //上传服务器
            lab.register(u, handler);
        }
    }

    private boolean isExistUserName(Editable username) {
        boolean has_username=false;
        SharedPreferences sp=getSharedPreferences("LoginActivity", MODE_PRIVATE);
        //获取密码
        String spPsw=sp.getString(String.valueOf(username), "");//传入用户名获取密码
        //如果密码不为空则确实保存过这个用户名
        if(!TextUtils.isEmpty(spPsw)) {
            has_username=true;
        }
        return has_username;
    }

}

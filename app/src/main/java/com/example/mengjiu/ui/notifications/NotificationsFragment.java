package com.example.mengjiu.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.mengjiu.Mypreference;
import com.example.mengjiu.R;
import com.example.mengjiu.RegisterActivity;
import com.google.android.material.textfield.TextInputLayout;

public class NotificationsFragment extends Fragment {
    private final static String TAG="Mengjiu";
    private Button loginButton1;
    private Button loginButton;
    private String user;
    private NotificationsViewModel notificationsViewModel;
    private Mypreference prefs=Mypreference.getInstance();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        //实现从登陆界面到注册页面的跳转
        loginButton1 = root.findViewById(R.id.notifications_login_button1);
        loginButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"点击注册跳转注册页！");
                Intent intent = new Intent(getActivity(),RegisterActivity.class);
                startActivity(intent);
            }
        });

//        //实现登录APP模块
//        loginButton=root.findViewById(R.id.notifications_login_button);
//        loginButton.setOnClickListener(v->{
//            TextInputLayout username=root.findViewById(R.id.notifications_registerinput1);
//            TextInputLayout password=root.findViewById(R.id.notifications_registerinput2);
//            user=username.getEditText().getText().toString();
//            String p=password.getEditText().getText().toString();
//
//
//            //判断
//            if (TextUtils.isEmpty(user)){
//                Toast.makeText(getActivity(), getResources().getString(R.string.root_fail_text), Toast.LENGTH_SHORT).show();
//                return;
//            }else if (TextUtils.isEmpty(p)){
//                Toast.makeText(getActivity(), getResources().getString(R.string.root_fail_text1), Toast.LENGTH_SHORT).show();
//                return;
//            }else {
//               // 调用retrofit
//               //TODO 未实现服务器对接
//                lab.login(user, p, handler);
//            }
//        });
//        prefs.setup(getApplicationContext());
        return root;

    }
}


//    private void toRegister(){
//        Intent intent = new Intent(this,RegisterActivity.class);
//        startActivity(intent);
//
//    }








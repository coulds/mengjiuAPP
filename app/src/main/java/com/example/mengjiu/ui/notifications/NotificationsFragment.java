package com.example.mengjiu.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.mengjiu.R;
import com.example.mengjiu.RegisterActivity;

public class NotificationsFragment extends Fragment {
    private Button loginButton1;
    private NotificationsViewModel notificationsViewModel;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        //实现从登陆界面到注册页面的跳转
        loginButton1 = root.findViewById(R.id.login_button1);
        loginButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),RegisterActivity.class);
                startActivity(intent);
            }
        });
        return root;

    }
}


//    private void toRegister(){
//        Intent intent = new Intent(this,RegisterActivity.class);
//        startActivity(intent);
//
//    }








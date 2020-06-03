package com.example.mengjiu.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.mengjiu.AllActivity;
import com.example.mengjiu.R;
import com.example.mengjiu.RegisterActivity;

public class DashboardFragment extends Fragment {
    private final static String TAG="Mengjiu";
    private Button button4Button;
    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
//        final TextView textView = root.findViewById(R.id.text_dashboard);
//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        //实现从账单界面到全部订单页面的跳转
        button4Button = root.findViewById(R.id.button4);
        button4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"点击全部跳转全部订单页！");
                Intent intent = new Intent(getActivity(),AllActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }
}

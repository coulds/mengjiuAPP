package com.example.mengjiu.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.mengjiu.AllActivity;
import com.example.mengjiu.EvaluatedActivity;
import com.example.mengjiu.FinishActivity;
import com.example.mengjiu.R;
import com.example.mengjiu.ShippingActivity;

public class DashboardFragment extends Fragment {
    private final static String TAG="Mengjiu";
    private Button button4Button;
    private Button button7Button;
    private Button button6Button;
    private Button button5Button;
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
        button4Button = root.findViewById(R.id.dashboard_button4);
        button4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"点击全部跳转全部订单页！");
                Intent intent = new Intent(getActivity(),AllActivity.class);
                startActivity(intent);
            }
        });

        //实现从账单界面到待配送订单页面的跳转
        button7Button = root.findViewById(R.id.dashboard_button7);
        button7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"点击全部跳转全部订单页！");
                Intent intent = new Intent(getActivity(), ShippingActivity.class);
                startActivity(intent);
            }
        });
        //实现从账单界面到待评价订单页面的跳转
        button6Button = root.findViewById(R.id.dashboard_button6);
        button6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"点击全部跳转评价订单页！");
                Intent intent = new Intent(getActivity(), EvaluatedActivity.class);
                startActivity(intent);
            }
        });
        //实现从账单界面到待完成订单页面的跳转
        button5Button = root.findViewById(R.id.dashboard_button5);
        button5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"点击全部跳转完成订单页！");
                Intent intent = new Intent(getActivity(), FinishActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }
}

package com.example.mengjiu.ui.myorder;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.mengjiu.R;

public class MyorderFragment extends Fragment {
    private final static String TAG="Mengjiu";
//    private RecyclerView myddButton;

    private MyorderViewModel myorderViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        myorderViewModel =
                ViewModelProviders.of(this).get(MyorderViewModel.class);
        View root = inflater.inflate(R.layout.fragment_myorder, container, false);
        //实现从账单界面到全部订单页面的跳转
//        myddButton = root.findViewById(R.id.my_wddd);
//        myddButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG,"点击我的订单跳转全部订单页！");
//                Intent intent = new Intent(getActivity(), AllActivity.class);
//                startActivity(intent);
//            }
//        });
        return root;

    }
}

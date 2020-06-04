package com.example.mengjiu.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mengjiu.Commodity;
import com.example.mengjiu.CommodityLab;
import com.example.mengjiu.CommodityRvAdapter;
import com.example.mengjiu.InfoActivity;
import com.example.mengjiu.R;
import com.example.mengjiu.RetrofitClient;

import retrofit2.Retrofit;

public class HomeFragment<CommodiyRvAdapter> extends Fragment {
    private ImageView home_kafei_img;
    private RecyclerView commodityRv;
    private CommodiyRvAdapter rvAdapter;
    private RecyclerView commodity;
    private HomeViewModel homeViewModel;private CommodityLab lab=CommodityLab.getInstance();
    //线程通讯第1步，在主线程创建HandLer
    private Handler handler=new Handler(){
        //按快捷键ctrl o
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case CommodityLab.MSG_CHANNELS:
//                    rvAdapter.notifyDataSetChanged();
                    break;
                case CommodityLab.MSG_FAILURE:
                    failed();
                    break;
            }
        }
    };

    private void failed(){
//        Toast.makeText(HomeFragment.this,"Token无效，禁止访问！",Toast.LENGTH_LONG).show();
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        home_kafei_img = root.findViewById(R.id.home_kafei_img);
        home_kafei_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), InfoActivity.class);
                startActivity(intent);
            }
        });



        this.commodityRv=root.findViewById(R.id.commodity_recy);
        //lambda简化
        //适用handler，把适配器改为实例变量
//        rvAdapter =new CommodityRvAdapter(HomeFragment.this, p -> {
            //跳转到新界面，使用意图Intent
//            Intent intent =new Intent(HomeFragment.this,SpxqActivity.class);
            //TODO 传递用户选中的频道到下一个界面
            //通过位置p得到当前频道channel
//            Commodity c=lab.getCommodity(p);
//            intent.putExtra("commodity",c);
//            startActivity(intent);
//        });
//        this.commodityRv.setAdapter(rvAdapter);
//        this.commodityRv.setLayoutManager(new LinearLayoutManager(this));
//        Retrofit a= RetrofitClient.getInstance();

        return root;
    }

//    @Override
//    protected void onResume(){
//        super.onResume();
//        //把主线程的handler传递给子线程适用
//        lab.getData(handler);
//    }
}

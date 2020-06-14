package com.example.mengjiu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import retrofit2.Retrofit;

public class HomeActivity extends AppCompatActivity {
    private ImageView dring_home;
    private ImageView list_home;
    private ImageView kafei_home;
    private ImageView home_fuwu_img;
    private Button dash_home;
    private Button login_home;
    private Button my_home;
    private ImageView cake_img;
    private RecyclerView commodityRv;
    private CommodityRvAdapter rvAdapter;
    private CommodityLab lab=CommodityLab.getInstance();
    //线程通讯第1步，在主线程创建HandLer
    private Handler handler=new Handler(){
        //按快捷键ctrl o
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case CommodityLab.MSG_COMMODITYS:
                    rvAdapter.notifyDataSetChanged();
                    break;
                case CommodityLab.MSG_FAILURE:
                    failed();
                    break;
            }
        }
    };

    private void failed(){
        Toast.makeText(HomeActivity.this,"Token无效，禁止访问！",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();//隐藏标题栏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.commodityRv=findViewById(R.id.commodity_recy);

        //lambda简化
        //适用handler，把适配器改为实例变量
        rvAdapter =new CommodityRvAdapter(HomeActivity.this, p -> {
            //跳转到新界面，使用意图Intent
            Intent intent =new Intent(HomeActivity.this,InfoActivity.class);
            //TODO 传递用户选中的频道到下一个界面
            //通过位置p得到当前频道commodity
            Commodity c=lab.getCommodity(p);
            intent.putExtra("commodity",c);
            startActivity(intent);
        });
        this.commodityRv.setAdapter(rvAdapter);
        this.commodityRv.setLayoutManager(new LinearLayoutManager(this));
        Retrofit a=RetrofitClient.getInstance();

        //跳转登录页
        login_home=findViewById(R.id.home_login);
        login_home.setOnClickListener(v->{
            Intent intent=new Intent(HomeActivity.this,LoginActivity.class);
            startActivity(intent);
        });
        //跳转账单页
        dash_home=findViewById(R.id.home_dashboard);
        dash_home.setOnClickListener(v->{
            Intent intent=new Intent(HomeActivity.this,DashboardActivity.class);
            startActivity(intent);
        });
        //跳转我的页
        my_home=findViewById(R.id.home_myorder);
        my_home.setOnClickListener(v->{
            Intent intent=new Intent(HomeActivity.this,MyorderActivity.class);
            startActivity(intent);
        });
        //顶部商品中咖啡的跳转
        kafei_home = findViewById(R.id.home_kafei_img);
        kafei_home.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this,KaFeiActivity2.class);
            startActivity(intent);
        });
        list_home = findViewById(R.id.home_jiudan_img);
        list_home.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this,ListActivity.class);
            startActivity(intent);
        });
        dring_home = findViewById(R.id.home_yingpin_img);
        dring_home.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this,DringActivity.class);
            startActivity(intent);
        });
        home_fuwu_img = findViewById(R.id.home_fuwu_img);
        home_fuwu_img.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this,Mykehuzx.class);
            startActivity(intent);
        });

//        this.cake_img=findViewById(R.id.home_kafei_img);
//        cake_img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(HomeActivity.this,InfoActivity.class);
//                startActivity(intent);
//            }
//        });

    }


    @Override
    protected void onResume(){
        super.onResume();
        //把主线程的handler传递给子线程适用
        lab.getData(handler);
    }
}

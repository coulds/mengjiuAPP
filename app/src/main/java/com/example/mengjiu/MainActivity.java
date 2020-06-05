package com.example.mengjiu;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.example.mengjiu.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
//    private RecyclerView commodityRv;
//    private CommodityRvAdapter rvAdapter;
//    private CommodityLab lab=CommodityLab.getInstance();
//    //线程通讯第1步，在主线程创建HandLer
//    private Handler handler=new Handler(){
//        //按快捷键ctrl o
//        @Override
//        public void handleMessage(@NonNull Message msg) {
//            switch (msg.what){
//                case CommodityLab.MSG_CHANNELS:
//                    rvAdapter.notifyDataSetChanged();
//                    break;
//                case CommodityLab.MSG_FAILURE:
//                    failed();
//                    break;
//            }
//        }
//    };
//
//    private void failed(){
//        Toast.makeText(MainActivity.this,"Token无效，禁止访问！",Toast.LENGTH_LONG).show();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();//隐藏标题栏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//透明状态栏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);//透明标题栏
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications,R.id.navigation_myorder)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        int id = getIntent().getIntExtra("id",0);
        if (id==1){
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_container,new NotificationsFragment()).addToBackStack(null).commit();
        }

//        this.commodityRv=findViewById(R.id.commodity_recy);
        //lambda简化
        //适用handler，把适配器改为实例变量
//        rvAdapter =new CommodityRvAdapter(MainActivity.this, p -> {
            //跳转到新界面，使用意图Intent
//            Intent intent =new Intent(MainActivity.this,SpxqActivity.class);
            //TODO 传递用户选中的频道到下一个界面
            //通过位置p得到当前频道channel
//            Commodity c=lab.getCommodity(p);
//            intent.putExtra("commodity",c);
//            startActivity(intent);
//        });
//        this.commodityRv.setAdapter(rvAdapter);
//        this.commodityRv.setLayoutManager(new LinearLayoutManager(this));
//        Retrofit a= RetrofitClient.getInstance();
    }

//    @Override
//    protected void onResume(){
//        super.onResume();
//        //把主线程的handler传递给子线程适用
//        lab.getData(handler);
//    }
}

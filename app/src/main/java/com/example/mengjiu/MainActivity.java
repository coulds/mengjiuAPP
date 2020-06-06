package com.example.mengjiu;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;

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
//
    private Mypreference prefs = Mypreference.getInstance();
//

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();//隐藏标题栏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//透明状态栏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);//透明标题栏

        setContentView(R.layout.activity_main);

//        this.commodityRv=findViewById(R.id.commodity_recy);
//        //lambda简化
//        //适用handler，把适配器改为实例变量
//        rvAdapter =new CommodityRvAdapter(MainActivity.this, p -> {
//            //跳转到新界面，使用意图Intent
//            Intent intent =new Intent(MainActivity.this,InfoActivity.class);
//            //TODO 传递用户选中的频道到下一个界面
//            //通过位置p得到当前频道channel
//            Commodity c=lab.getCommodity(p);
//            intent.putExtra("commodity",c);
//            startActivity(intent);
//        });
//        this.commodityRv.setAdapter(rvAdapter);
//        this.commodityRv.setLayoutManager(new LinearLayoutManager(this));
//        Retrofit a= RetrofitClient.getInstance();
    }

//
//    @Override
//    protected void onResume(){
//        super.onResume();
//        //把主线程的handler传递给子线程适用
//        lab.getData(handler);
//    }
}

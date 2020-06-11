package com.example.mengjiu;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class InfoActivity extends AppCompatActivity {
    private Commodity currentCommodity;
    private ImageView infocover;
    private TextView commodityname,category,price,production,score,abv,describe;
    private CommodityLab lab=CommodityLab.getInstance();
    private final static String TAG="Mengjiu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();//隐藏标题栏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        //init();
        Serializable s = getIntent().getSerializableExtra("commodity");
        Log.d(TAG, "取得当前频道对象是：" + s);
        if (s != null && s instanceof Commodity) {
            currentCommodity = (Commodity) s;
        }
        updateUI();
    }


    private void updateUI(){
        commodityname=findViewById(R.id.info_commodityname);
        commodityname.setText(currentCommodity.getCommodityname());
        category=findViewById(R.id.info_category);
        category.setText(currentCommodity.getCategory());
        production=findViewById(R.id.info_production);
        production.setText(currentCommodity.getProduction());
        score=findViewById(R.id.info_score);
        score.setText(currentCommodity.getScore());
        abv=findViewById(R.id.info_abv);
        abv.setText(currentCommodity.getAbv());
        describe=findViewById(R.id.info_describe);
        describe.setText(currentCommodity.getDescribe());
        price=findViewById(R.id.product_price);
        price.setText(currentCommodity.getPrice());
//        infocover=findViewById(R.id.info_cover);
//        infocover.setImageURI(Uri.parse(currentCommodity.getCover()));
    }
}


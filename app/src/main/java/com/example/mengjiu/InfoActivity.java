package com.example.mengjiu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

public class InfoActivity extends AppCompatActivity {
    private SimpleExoPlayer player;
    private PlayerView playerView;
    private Commodity currentCommodity;
    private TextView commodityname,category,price,production,score,abv,describe;
    private CommodityLab lab=CommodityLab.getInstance();
    private final static String TAG="Mengjiu";
    private final DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();//隐藏标题栏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        //init();
        Serializable s=getIntent().getSerializableExtra("commodity");
        Log.d(TAG,"取得当前频道对象是："+s);
        if (s!=null&&s instanceof Commodity){
            currentCommodity=(Commodity) s;
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
    }

    //快捷键ctrl O
    @Override
    protected void onDestroy() {
        super.onDestroy();
        clean();
    }

    protected void onStart(){
        super.onStart();
        if (playerView!=null){
            playerView.onResume();
        }
    }

    protected void onStop(){
        super.onStop();
        if (playerView!=null){
            playerView.onPause();
        }
        clean();
    }

    /**
     * 自定义方法，清理不用资源
     */
    private void clean(){
        if (player!=null){
            player.release();
            player=null;
        }
    }
}

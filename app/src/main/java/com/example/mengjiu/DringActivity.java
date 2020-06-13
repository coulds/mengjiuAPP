package com.example.mengjiu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class DringActivity extends AppCompatActivity {
    private ImageView kafei_home2;
    private ImageView list_home2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dring);
        getSupportActionBar().hide();//隐藏标题栏

//        kafei_home2 = findViewById(R.id.home_kafei_img);
//        kafei_home2.setOnClickListener(v -> {
//            Intent intent = new Intent(DringActivity.this,KaFeiActivity2.class);
//            startActivity(intent);
//            finish();
//        });
//
//        list_home2 = findViewById(R.id.home_jiudan_img);
//        list_home2.setOnClickListener(v -> {
//            Intent intent = new Intent(DringActivity.this,ListActivity.class);
//            startActivity(intent);
//            finish();
//        });
    }
}
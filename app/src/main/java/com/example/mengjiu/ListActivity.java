package com.example.mengjiu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class ListActivity extends AppCompatActivity {
    private ImageView kafei_home3;
    private ImageView dring_home3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        getSupportActionBar().hide();//隐藏标题栏

//        kafei_home3=findViewById(R.id.home_kafei_img);
//        kafei_home3.setOnClickListener(v -> {
//            Intent intent = new Intent(ListActivity.this,KaFeiActivity2.class);
//            startActivity(intent);
//            finish();
//        });
//        dring_home3 = findViewById(R.id.home_yingpin_img);
//        Intent intent =new Intent(ListActivity.this,DringActivity.class);
//        startActivity(intent);
//        finish();
    }
}
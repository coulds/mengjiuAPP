package com.example.mengjiu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class KaFeiActivity2 extends AppCompatActivity {
    private ImageView dring_home1;
    private ImageView list_home1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ka_fei2);
        getSupportActionBar().hide();//隐藏标题栏

        dring_home1 = findViewById(R.id.home_yingpin_img);
        dring_home1.setOnClickListener(v -> {
            Intent intent = new Intent(KaFeiActivity2.this,DringActivity.class);
            startActivity(intent);
            finish();
        });

        list_home1=findViewById(R.id.home_jiudan_img);
        list_home1.setOnClickListener(v -> {
            Intent intent = new Intent(KaFeiActivity2.this,ListActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
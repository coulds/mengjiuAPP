package com.example.mengjiu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class KaFeiActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ka_fei2);
        getSupportActionBar().hide();//隐藏标题栏
    }
}
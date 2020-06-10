package com.example.mengjiu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class My_favorite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();//隐藏标题栏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_favorite);
    }
}
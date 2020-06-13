package com.example.mengjiu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dring);
        getSupportActionBar().hide();//隐藏标题栏
    }
}
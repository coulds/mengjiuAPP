package com.example.mengjiu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class EvaluatedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();//隐藏标题栏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluated);
    }
}

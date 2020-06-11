package com.example.mengjiu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SetUpActivity extends AppCompatActivity {
    private ImageView abutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);
        abutton = findViewById(R.id.img_fanhui);
        abutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetUpActivity.this,MyorderActivity.class);
                startActivity(intent);

            }
        });
    }
}

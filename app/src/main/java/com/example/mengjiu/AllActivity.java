package com.example.mengjiu;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;


public class AllActivity extends AppCompatActivity {
    private final static String TAG="Mengjiu";
    private Button allb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();//隐藏标题栏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);
    }
}

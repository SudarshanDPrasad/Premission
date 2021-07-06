package com.example.rememberme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class SecondScreeen extends AppCompatActivity {
    private TextView mtvdiaplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screeen);
        mtvdiaplay = findViewById(R.id.tvdiaplay);
        SharedPreferences sharedPreferences = getSharedPreferences("com.xyz.sharedpreferences", MODE_PRIVATE);
        String Display = sharedPreferences.getString("userName", "");
        mtvdiaplay.setText(Display);
    }

}
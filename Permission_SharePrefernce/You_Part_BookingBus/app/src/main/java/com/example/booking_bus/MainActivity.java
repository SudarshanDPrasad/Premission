package com.example.booking_bus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button mbtncontinue;
    EditText metPhoneNumber, metEmaild, metLastName, metFirstName;
    TextView mtvFirstname, mtvLastName, mtvEmail, mtvPhoneNumber;

    private static final String SHARED_PREFERENCE_KEY = "com.xyz.sharedpreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intidviews();
        mbtncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstnname = metFirstName.getText().toString().trim();
                String LastName = metLastName.getText().toString();
                String emailId = metEmaild.getText().toString();
                String phoneNumber = metPhoneNumber.getText().toString();

                // using Shared Preferneces
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCE_KEY,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("firstName",firstnname);
                editor.putString("LastName",LastName);
                editor.putString("emailId",emailId);
                editor.putString("phoneNumber",phoneNumber);
                editor.apply();

                Intent intent = new Intent(MainActivity.this,SecondScreen.class);
                startActivity(intent);



            }
        });
    }

    private void intidviews() {
        mbtncontinue = findViewById(R.id.btncontinue);
        metPhoneNumber = findViewById(R.id.etPhoneNumber);
        metEmaild = findViewById(R.id.etEmaild);
        metFirstName = findViewById(R.id.etFirstName);
        metLastName = findViewById(R.id.etLastName);
        mbtncontinue=findViewById(R.id.btncontinue);
    }
}
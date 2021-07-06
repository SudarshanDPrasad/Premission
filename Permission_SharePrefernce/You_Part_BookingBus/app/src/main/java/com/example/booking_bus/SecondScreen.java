package com.example.booking_bus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondScreen extends AppCompatActivity {
    Button mbtncontinue;
    TextView metPhoneNumber1, metEmaild1, metLastName1, metFirstName1,metDate,metnoofseats;

    private static final String Second_key = "com.xyz.sharedpreferences";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        intidviews();
        showData();
        mbtncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String Date = metDate.getText().toString();
               String Seats = metnoofseats.getText().toString();

                // using Shared Preferneces
                SharedPreferences sharedPreferences = getSharedPreferences(Second_key,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Date",Date);
                editor.putString("Seats",Seats);
                editor.apply();

                Intent intent = new Intent(SecondScreen.this,ThirdScreen.class);
                startActivity(intent);


            }
        });

    }

    private void showData() {
        SharedPreferences sharedPreferences = getSharedPreferences("com.xyz.sharedpreferences",MODE_PRIVATE);
        String Firstname = sharedPreferences.getString("firstName","");
        metFirstName1.setText(Firstname);
        String LastName = sharedPreferences.getString("LastName","");
        metLastName1.setText(LastName);
        String emailId = sharedPreferences.getString("emailId","");
        metEmaild1.setText(emailId);
        String phoneNumber = sharedPreferences.getString("phoneNumber", "");
        metPhoneNumber1.setText(phoneNumber);

    }

    private void intidviews() {
        metEmaild1 = findViewById(R.id.etEmaild1);
        metFirstName1 = findViewById(R.id.etFirstName1);
        metLastName1 = findViewById(R.id.etLastName1);
        metPhoneNumber1 = findViewById(R.id.etPhoneNumber1);
        mbtncontinue=findViewById(R.id.btncontinue);
        metDate=findViewById(R.id.etDate);
        metnoofseats=findViewById(R.id.etnoofseats);
    }
}
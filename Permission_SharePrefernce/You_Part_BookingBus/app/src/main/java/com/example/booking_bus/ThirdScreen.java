package com.example.booking_bus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URI;

public class ThirdScreen extends AppCompatActivity {

    Button mbtncontinue;
    AlertDialog.Builder builder;
    TextView metPhoneNumber1, metEmaild1, metLastName1, metFirstName1, metDate, metnoofseats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_screen);
        intidviews();
        showdata();
        showData();
        mbtncontinue.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog alert = builder.create();
                alert.setTitle("Confirmed");
                alert.show();
            }
        });

    }

    private void showData() {
        SharedPreferences sharedPreferences = getSharedPreferences("com.xyz.sharedpreferences", MODE_PRIVATE);
        String Firstname = sharedPreferences.getString("firstName", "");
        metFirstName1.setText(Firstname);
        String LastName = sharedPreferences.getString("LastName", "");
        metLastName1.setText(LastName);
        String emailId = sharedPreferences.getString("emailId", "");
        metEmaild1.setText(emailId);
        String phoneNumber = sharedPreferences.getString("phoneNumber", "");
        metPhoneNumber1.setText(phoneNumber);

    }

    private void showdata() {
        SharedPreferences sharedPreferences = getSharedPreferences("com.xyz.sharedpreferences", MODE_PRIVATE);
        String Date = sharedPreferences.getString("Date", "");
        metDate.setText(Date);
        String Seats = sharedPreferences.getString("Seats", "");
        metnoofseats.setText(Seats);
    }

    private void intidviews() {
        metEmaild1 = findViewById(R.id.etEmaild1);
        metFirstName1 = findViewById(R.id.etFirstName1);
        metLastName1 = findViewById(R.id.etLastName1);
        metPhoneNumber1 = findViewById(R.id.etPhoneNumber1);
        mbtncontinue = findViewById(R.id.btncontinue);
        metDate = findViewById(R.id.etDate);
        metnoofseats = findViewById(R.id.etnoofseats);
        builder = new AlertDialog.Builder(this);

    }
}
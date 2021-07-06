package com.example.rememberme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mbtncontinue;
    private CheckBox mcbTick;
    EditText metUserName;

    private static final String SHARED_PREFERENCE_KEY = "com.xyz.sharedpreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intidviews();

        mbtncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mcbTick.isChecked()) {
                    String userName = metUserName.getText().toString();

                    SharedPreferences sharedPreferences =getSharedPreferences(SHARED_PREFERENCE_KEY,MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("userName",userName);
                    editor.apply();

                    Intent intent = new Intent(MainActivity.this,SecondScreeen.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"Please Click on the Remember me",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void intidviews() {
        mbtncontinue = findViewById(R.id.btncontinue);
        mcbTick = findViewById(R.id.cbTick);
        metUserName = findViewById(R.id.etUserName);
    }
}
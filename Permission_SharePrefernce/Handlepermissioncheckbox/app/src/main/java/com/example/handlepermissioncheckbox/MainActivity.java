package com.example.handlepermissioncheckbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mbutton;
    private static final int REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbutton = findViewById(R.id.button);

        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] permissions = {Manifest.permission.CAMERA};
                ActivityCompat.requestPermissions(MainActivity.this, permissions, REQUEST_CODE);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            showToast("Camera Permission Granted ");
        }else if (grantResults[0] == PackageManager.PERMISSION_DENIED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,permissions[0])){
                showToast("Permission Denied");
            }else{
                showToast("permisson Denied by clicking DONT SHOW again, please go to setting and enable the permission");
            }
        }
    }


    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
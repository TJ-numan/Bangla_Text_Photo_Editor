package com.example.banglatextphotoeditor;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(1024, 1024);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                SplashActivity.this.startToMainActivity();
            }
        }, 3500);
    }

    public void startToMainActivity() {
        startActivity(new Intent(this, BaseActivity.class));
        finish();
    }
}
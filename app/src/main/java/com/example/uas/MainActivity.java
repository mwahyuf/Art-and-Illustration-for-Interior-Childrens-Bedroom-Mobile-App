package com.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Handler handler;
    Runnable runnable;
    ImageView splash_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        splash_logo = findViewById(R.id.splash_logo);
            splash_logo.animate().alpha(1.0f).setDuration(0);

            handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent dsp = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(dsp);
                    finish();
                }
            }, 4000);
    }
}
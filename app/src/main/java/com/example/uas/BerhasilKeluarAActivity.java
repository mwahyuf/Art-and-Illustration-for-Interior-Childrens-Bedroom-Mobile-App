package com.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class BerhasilKeluarAActivity extends AppCompatActivity {

    Handler handler;
    Runnable runnable;
    TextView berhasilKeluar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berhasil_keluar_aactivity);

        berhasilKeluar = findViewById(R.id.berhasilKeluar);

        berhasilKeluar.animate().alpha(1.0f).setDuration(0);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent keluar = new Intent(BerhasilKeluarAActivity.this, LoginActivity.class);
                startActivity(keluar);
                finish();
            }
        }, 4000);


    }
}
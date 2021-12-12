package com.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SesuaiKeinginanActivity extends AppCompatActivity {

    Button buttonKonfirmasiSesuaiKeinginan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesuai_keinginan);

        buttonKonfirmasiSesuaiKeinginan = findViewById(R.id.konfirmasiSesuaiKeinginan);
        buttonKonfirmasiSesuaiKeinginan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnKonfirmasiSesuai = new Intent(SesuaiKeinginanActivity.this, KonfirmasiPembayaranHire.class);
                startActivity(btnKonfirmasiSesuai);
            }
        });
    }
}
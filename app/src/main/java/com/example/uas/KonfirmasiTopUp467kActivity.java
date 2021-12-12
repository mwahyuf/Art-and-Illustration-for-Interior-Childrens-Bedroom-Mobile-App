package com.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class KonfirmasiTopUp467kActivity extends AppCompatActivity {
    Button button467k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi_top_up467k);

        button467k = findViewById(R.id.button_konfirmasitopup467k);
        button467k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn467k = new Intent(KonfirmasiTopUp467kActivity.this, HomePageActivity.class);
                Toast.makeText(KonfirmasiTopUp467kActivity.this, "Berhasil membayar", Toast.LENGTH_LONG).show();
                startActivity(btn467k);
            }
        });
    }
}
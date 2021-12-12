package com.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class KonfirmasiTopUpActivity extends AppCompatActivity {
    Button button100k;
    TextView angka100k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi_top_up);

        button100k = findViewById(R.id.button_konfirmasitopup100k);
        angka100k = findViewById(R.id.angka_isi100k);

        button100k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn100k = new Intent(KonfirmasiTopUpActivity.this, HomePageActivity.class);
                Toast.makeText(KonfirmasiTopUpActivity.this, "Berhasil membayar", Toast.LENGTH_LONG).show();
                startActivity(btn100k);
            }
        });
    }
}
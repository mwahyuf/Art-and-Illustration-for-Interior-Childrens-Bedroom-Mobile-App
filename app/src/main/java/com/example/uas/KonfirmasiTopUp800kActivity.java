package com.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class KonfirmasiTopUp800kActivity extends AppCompatActivity {
    Button button800k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi_top_up800k);

        button800k = findViewById(R.id.button_konfirmasitopup800k);

        button800k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn800k = new Intent(KonfirmasiTopUp800kActivity.this, HomePageActivity.class);
                Toast.makeText(KonfirmasiTopUp800kActivity.this, "Berhasil membayar", Toast.LENGTH_LONG).show();
                startActivity(btn800k);
            }
        });
    }
}
package com.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class konfirmasi_topup_250k extends AppCompatActivity {
    Button button250k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi_topup250k);

        button250k = findViewById(R.id.button_konfirmasitopup250k);

        button250k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn250k = new Intent(konfirmasi_topup_250k.this, HomePageActivity.class);
                Toast.makeText(konfirmasi_topup_250k.this, "Berhasil membayar", Toast.LENGTH_LONG).show();
                startActivity(btn250k);
            }
        });
    }
}
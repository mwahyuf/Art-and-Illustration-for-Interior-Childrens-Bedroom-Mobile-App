package com.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class KonfirmasiPembayaranHire extends AppCompatActivity {

    Button konfirmasiPembayaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi_pembayaran_hire);

        konfirmasiPembayaran = findViewById(R.id.button_konfirmasipembayaran);

        konfirmasiPembayaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent konfirmasibtn = new Intent(KonfirmasiPembayaranHire.this, HomepPageAlternate.class);
                Toast.makeText(KonfirmasiPembayaranHire.this, "Berhasil membayar", Toast.LENGTH_LONG).show();
                startActivity(konfirmasibtn);
            }
        });
    }
}
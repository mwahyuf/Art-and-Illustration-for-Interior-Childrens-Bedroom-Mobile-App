package com.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HasilYangTelahDibuatActivity extends AppCompatActivity {

    Button buttonKonfirmasiHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_yang_telah_dibuat);

        buttonKonfirmasiHasil = findViewById(R.id.konfirmasiHasilDibuat);
        buttonKonfirmasiHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btnKonfirmasi = new Intent(HasilYangTelahDibuatActivity.this, KonfirmasiPembayaranHire.class);
                startActivity(btnKonfirmasi);
            }
        });
    }
}
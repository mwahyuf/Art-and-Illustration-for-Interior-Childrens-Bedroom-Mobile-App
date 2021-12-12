package com.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfilCreatorDefaultActivity extends AppCompatActivity {

    Button hireButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_creator_default);

        TextView namaCreator = findViewById(R.id.creatorNameDefault);
        TextView lokasiCreator = findViewById(R.id.creatorLocationDefault);
        TextView sejakCreator = findViewById(R.id.creatorSinceDefault);

        hireButton = findViewById(R.id.hireBtnCreator);

        hireButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hire = new Intent(ProfilCreatorDefaultActivity.this, HireActivity.class);
                startActivity(hire);
            }
        });

        /*Intent intent = getIntent();

        String nama = intent.getStringExtra("NAMACREATOR_DEFAULT");
        String lokasi = intent.getStringExtra("LOKASICREATOR_DEFAULT");
        String sejak = intent.getStringExtra("SEJAKCREATOR_DEFAULT");

        namaCreator.setText(nama);
        lokasiCreator.setText(lokasi);
        sejakCreator.setText(sejak);*/
    }
}
package com.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GaleriDefaultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeri_default);

        ImageView imageDefault = findViewById(R.id.image_default);
        TextView titleDefault = findViewById(R.id.title_default);
        TextView createdDefault = findViewById(R.id.created_default);
        TextView genreDefault = findViewById(R.id.genre_default);
        TextView tanggalDefault = findViewById(R.id.tanggal_default);
        Button creatorProfileButton = findViewById(R.id.creatorprofile_btn);


        creatorProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent creatorProfile = new Intent(GaleriDefaultActivity.this, ProfilCreatorDefaultActivity.class);
                startActivity(creatorProfile);
            }
        });

        Intent intent = getIntent();

        int hasilArtwork = intent.getIntExtra("GAMBAR_DEFAULT", 0);
        String judulArtwork = intent.getStringExtra("JUDUL_DEFAULT");
        String creatorArtwork = intent.getStringExtra("PEMBUAT_DEFAULT");
        String genreArtwork = intent.getStringExtra("GENRE_DEFAULT");
        String tanggalArtwork = intent.getStringExtra("TANGGAL_DEFAULT");

        imageDefault.setImageResource(hasilArtwork);
        titleDefault.setText(judulArtwork);
        createdDefault.setText(creatorArtwork);
        genreDefault.setText(genreArtwork);
        tanggalDefault.setText(tanggalArtwork);

    }
}
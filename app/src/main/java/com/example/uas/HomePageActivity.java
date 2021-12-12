package com.example.uas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomePageActivity extends AppCompatActivity {
    ImageView galeriseni;
    ImageView topup;
    ImageView profile;
    ImageView riwayatPesanan;
    ImageView creator;

    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        galeriseni = findViewById(R.id.galeri_tap);
        topup = findViewById(R.id.topup_tap);
        profile = findViewById(R.id.profile_tap);
        riwayatPesanan = findViewById(R.id.riwayat_pesanan_tap);
        creator = findViewById(R.id.creator_tap);

        galeriseni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galeri = new Intent(HomePageActivity.this, GaleriSeniFixActivity.class);
                startActivity(galeri);
            }
        });

        topup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent topup = new Intent(HomePageActivity.this, TopUpFixActivity.class);
                startActivity(topup);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profil = new Intent(HomePageActivity.this, ProfileActivity.class);
                startActivity(profil);
            }
        });

        riwayatPesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent riwayatPesanan = new Intent(HomePageActivity.this, RiwayatPesananActivity.class);
                startActivity(riwayatPesanan);
            }
        });

        creator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent creator = new Intent(HomePageActivity.this, CreatorActivcity.class);
                startActivity(creator);
            }
        });

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        final TextView greetingText = (TextView) findViewById(R.id.welcome);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                PenggunaActivity userProfile = dataSnapshot.getValue(PenggunaActivity.class);

                if(userProfile != null){
                    String fullName = userProfile.fullName;

                    greetingText.setText("Selamat Datang, " + fullName + "!");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(HomePageActivity.this, "Terjadi kesalahan!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
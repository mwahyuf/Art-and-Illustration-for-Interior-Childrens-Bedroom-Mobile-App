package com.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class TopUpFixActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    Button lanjutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up_fix);

        radioGroup = findViewById(R.id.radiogroup);
        lanjutButton = findViewById(R.id.lanjut_btn);

        lanjutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkId = radioGroup.getCheckedRadioButtonId();
                if(checkId == -1){
                    Toast.makeText(TopUpFixActivity.this, "Mohon untuk memilih jumlah pengisian terlebih dahulu!", Toast.LENGTH_LONG).show();
                } else {
                    findRadioButton1(checkId);
                }
                radioGroup.clearCheck();
            }
        });

    }

    private void findRadioButton1(int checkId) {
        switch (checkId){
            case R.id.radio100kbtn:
                Intent radio100k = new Intent(TopUpFixActivity.this, KonfirmasiTopUpActivity.class);
                startActivity(radio100k);
                break;
            case R.id.radio250kbtn:
                Intent radio250k = new Intent(TopUpFixActivity.this, konfirmasi_topup_250k.class);
                startActivity(radio250k);
                break;
            case R.id.radio467kbtn:
                Intent radio467k = new Intent(TopUpFixActivity.this, KonfirmasiTopUp467kActivity.class);
                startActivity(radio467k);
                break;
            case R.id.radio800kbtn:
                Intent radio800k = new Intent(TopUpFixActivity.this, KonfirmasiTopUp800kActivity.class);
                startActivity(radio800k);
                break;
        }
    }

}
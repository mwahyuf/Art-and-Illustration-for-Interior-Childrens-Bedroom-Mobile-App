package com.example.uas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView daftar_text_1, daftar_button;
    private EditText editFullName, editEmail, editNoSeluler, editNewPassword;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        daftar_text_1 = (TextView) findViewById(R.id.daftar_text_1);
        daftar_text_1.setOnClickListener(this);
        daftar_button = (Button) findViewById(R.id.daftar_button);
        daftar_button.setOnClickListener(this);

        editFullName = (EditText) findViewById(R.id.nama_lengkap);
        editEmail = (EditText) findViewById(R.id.email);
        editNoSeluler = (EditText) findViewById(R.id.nomor_seluler);
        editNewPassword = (EditText) findViewById(R.id.password_baru);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.daftar_text_1:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.daftar_button:
                daftar_button();
                break;

        }
    }

    private void daftar_button() {
        String fullName = editFullName.getText().toString().trim();
        String email = editEmail.getText().toString().trim();
        String noSeluler = editNoSeluler.getText().toString().trim();
        String newPassword = editNewPassword.getText().toString().trim();

        if(fullName.isEmpty()){
            editFullName.setError("Nama Lengkap perlu diisi!");
            editFullName.requestFocus();
            return;
        }

        if(email.isEmpty()){
            editEmail.setError("Email perlu diisi!");
            editEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editEmail.setError("Mohon berikan email yang valid!");
            editEmail.requestFocus();
            return;
        }

        if(noSeluler.isEmpty()){
            editNoSeluler.setError("Nomor seluler perlu diisi!");
            editNoSeluler.requestFocus();
            return;
        }


        if(newPassword.isEmpty()){
            editNewPassword.setError("Password baru perlu diisi!");
            editNewPassword.requestFocus();
            return;
        }

        if(newPassword.length() < 6){
            editNewPassword.setError("Panjang password minimal harus 6 karakter!");
            editNewPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, newPassword)
            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        PenggunaActivity user = new PenggunaActivity(fullName, email, noSeluler);

                        FirebaseDatabase.getInstance().getReference("Users")
                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                if(task.isSuccessful()){
                                    Toast.makeText(RegisterActivity.this, "Pendaftaran berhasil!", Toast.LENGTH_LONG).show();
                                    progressBar.setVisibility(View.GONE);

                                    // Redirect ke Login Layout
                                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                } else {
                                    Toast.makeText(RegisterActivity.this,"Gagal untuk mendaftar! Coba lagi!", Toast.LENGTH_LONG).show();
                                    progressBar.setVisibility((View.GONE));
                                }
                            }
                        });

                    } else {
                        Toast.makeText(RegisterActivity.this,"Gagal untuk mendaftar! Coba lagi!", Toast.LENGTH_LONG).show();
                        progressBar.setVisibility((View.GONE));
                    }
                }
            });

    }
}
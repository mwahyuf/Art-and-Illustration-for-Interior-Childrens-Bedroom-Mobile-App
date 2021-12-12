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
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button register;
    private EditText yourEmail, yourPassword;
    private Button masuk;
    private TextView lupaPassword;

    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        register = (Button) findViewById(R.id.registerbtn);
        register.setOnClickListener(this);

        masuk = (Button) findViewById(R.id.loginbtn);
        masuk.setOnClickListener(this);

        lupaPassword = (TextView) findViewById(R.id.forgotpwd);
        lupaPassword.setOnClickListener(this);

        yourEmail = (EditText) findViewById(R.id.email);
        yourPassword = (EditText) findViewById(R.id.password);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.registerbtn:
                startActivity(new Intent(this, RegisterActivity.class));
                break;

            case  R.id.loginbtn:
                userLogin();
                break;

            case R.id.forgotpwd:
                startActivity(new Intent(this, LupaPasswordActivity.class));
                break;
        }
    }

    private void userLogin() {
        String email = yourEmail.getText().toString().trim();
        String password = yourPassword.getText().toString().trim();

        if (email.isEmpty()){
            yourEmail.setError("Pengisian email dibutuhkan!");
            yourEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            yourEmail.setError("Mohon masukkan email yang valid!");
            yourEmail.requestFocus();
            return;
        }

        if (password.isEmpty()){
            yourPassword.setError("Pengisian password dibutuhkan!");
            yourPassword.requestFocus();
            return;
        }

        if (password.length() < 6){
            yourPassword.setError("Panjang password minimal 6 karakter!");
            yourPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                    if(user.isEmailVerified()){
                        // Redirect ke Home Page
                        startActivity(new Intent(LoginActivity.this, HomePageActivity.class));
                        progressBar.setVisibility(View.GONE);
                    } else {
                        user.sendEmailVerification();
                        Toast.makeText(LoginActivity.this, "Cek email anda untuk verifikasi akun!", Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.GONE);
                    }

                } else {
                    Toast.makeText(LoginActivity.this, "Gagal untuk masuk! Mohon cek kredensial anda", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}
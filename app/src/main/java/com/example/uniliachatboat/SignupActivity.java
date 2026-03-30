package com.example.uniliachatboat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button btnSignup = findViewById(R.id.btn_signup);
        TextView tvLoginLink = findViewById(R.id.tv_login_link);

        btnSignup.setOnClickListener(v -> {
            // In a real app, perform registration here
            Intent intent = new Intent(SignupActivity.this, MainActivity.class);
            startActivity(intent);
            finishAffinity(); // Clear activity stack
        });

        tvLoginLink.setOnClickListener(v -> {
            finish();
        });
    }
}
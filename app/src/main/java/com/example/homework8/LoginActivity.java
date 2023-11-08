package com.example.homework8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;
public class LoginActivity extends AppCompatActivity {
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView errorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.email_box);
        passwordEditText = findViewById(R.id.pass_box);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {
                    Snackbar.make(v, "Заполните все поля", Snackbar.LENGTH_SHORT).show();
                } else if (email.equals("admin@gmail.com") && password.equals("admin123")) {
                    Intent welcomeIntent = new Intent(LoginActivity.this,WelcomeActivity.class);
                    startActivity(welcomeIntent);
                } else {
                    Snackbar.make(v, "Неверный email или пароль", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }
}

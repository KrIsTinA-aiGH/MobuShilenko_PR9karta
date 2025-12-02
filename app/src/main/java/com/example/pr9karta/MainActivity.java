package com.example.pr9karta;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Инициализация элементов
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        Button buttonSignIn = findViewById(R.id.button);

        // Обработка нажатия кнопки Sign In
        buttonSignIn.setOnClickListener(v -> {
            String email = editTextEmail.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();

            // Проверка введенных данных
            if (email.isEmpty() && password.isEmpty()) {
                Toast.makeText(MainActivity.this,
                        "Введите логин и пароль", Toast.LENGTH_SHORT).show();
            } else if (email.isEmpty()) {
                Toast.makeText(MainActivity.this,
                        "Введите логин", Toast.LENGTH_SHORT).show();
            } else if (password.isEmpty()) {
                Toast.makeText(MainActivity.this,
                        "Введите пароль", Toast.LENGTH_SHORT).show();
            } else {
                // Если все заполнено - переходим на экран карты
                Intent intent = new Intent(MainActivity.this, karta.class);
                startActivity(intent);
            }
        });
    }
}
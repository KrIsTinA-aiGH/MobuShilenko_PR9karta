package com.example.pr9karta;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class karta extends AppCompatActivity {

    private Button button1, button2, button3;
    private int button1State = 0; // 0=серая, 1=цветная
    private int button2State = 0;
    private int button3State = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_karta);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Инициализация кнопок
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        // Обработчики нажатий
        button1.setOnClickListener(v -> {
            if (button1State == 0) {
                // Становимся цветной (красной)
                button1.setBackgroundColor(ContextCompat.getColor(karta.this, R.color.red));
                button1.setTextColor(ContextCompat.getColor(karta.this, R.color.white));
                button1.setText(getString(R.string.button_red));
                button1State = 1;
            } else {
                // Возвращаемся к серой
                button1.setBackgroundColor(ContextCompat.getColor(karta.this, R.color.gray));
                button1.setTextColor(ContextCompat.getColor(karta.this, R.color.black));
                button1.setText(getString(R.string.button_1));
                button1State = 0;
            }
        });

        button2.setOnClickListener(v -> {
            if (button2State == 0) {
                // Становимся цветной (синей)
                button2.setBackgroundColor(ContextCompat.getColor(karta.this, R.color.blue));
                button2.setTextColor(ContextCompat.getColor(karta.this, R.color.white));
                button2.setText(getString(R.string.button_blue));
                button2State = 1;
            } else {
                // Возвращаемся к серой
                button2.setBackgroundColor(ContextCompat.getColor(karta.this, R.color.gray));
                button2.setTextColor(ContextCompat.getColor(karta.this, R.color.black));
                button2.setText(getString(R.string.button_2));
                button2State = 0;
            }
        });

        button3.setOnClickListener(v -> {
            if (button3State == 0) {
                // Становимся цветной (зеленой)
                button3.setBackgroundColor(ContextCompat.getColor(karta.this, R.color.green));
                button3.setTextColor(ContextCompat.getColor(karta.this, R.color.white));
                button3.setText(getString(R.string.button_green));
                button3State = 1;
            } else {
                // Возвращаемся к серой
                button3.setBackgroundColor(ContextCompat.getColor(karta.this, R.color.gray));
                button3.setTextColor(ContextCompat.getColor(karta.this, R.color.black));
                button3.setText(getString(R.string.button_3));
                button3State = 0;
            }
        });
    }
}
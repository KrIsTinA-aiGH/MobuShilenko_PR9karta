package com.example.pr9karta;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class karta extends AppCompatActivity {

    private Button button1, button2, button3;
    private int button1State = 0;
    private int button2State = 0;
    private int button3State = 0;
    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
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

        // Инициализация WebView с Яндекс.Картами
        webView = findViewById(R.id.webView);
        if (webView != null) {
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient());

            // Загружаем Яндекс.Карты с центром в Москве
            String url = "https://yandex.ru/maps/?ll=37.6173,55.7558&z=12";
            webView.loadUrl(url);
        }

        // Инициализация всех кнопок
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        // Обработчики для ВСЕХ кнопок
        button1.setOnClickListener(v -> {
            if (button1State == 0) {
                button1.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
                button1.setTextColor(ContextCompat.getColor(this, R.color.white));
                button1.setText("Красная");

                // Переходим на Красную площадь в картах
                if (webView != null) {
                    String redSquareUrl = "https://yandex.ru/maps/?ll=37.6208,55.7539&z=17";
                    webView.loadUrl(redSquareUrl);
                }

                button1State = 1;
            } else {
                button1.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
                button1.setTextColor(ContextCompat.getColor(this, R.color.black));
                button1.setText("Кнопка 1");
                button1State = 0;
            }
        });

        button2.setOnClickListener(v -> {
            if (button2State == 0) {
                button2.setBackgroundColor(ContextCompat.getColor(this, R.color.blue));
                button2.setTextColor(ContextCompat.getColor(this, R.color.white));
                button2.setText("Синяя");

                // Переходим на Санкт-Петербург
                if (webView != null) {
                    String spbUrl = "https://yandex.ru/maps/?ll=30.3351,59.9343&z=12";
                    webView.loadUrl(spbUrl);
                }

                button2State = 1;
            } else {
                button2.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
                button2.setTextColor(ContextCompat.getColor(this, R.color.black));
                button2.setText("Кнопка 2");
                button2State = 0;
            }
        });

        button3.setOnClickListener(v -> {
            if (button3State == 0) {
                button3.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
                button3.setTextColor(ContextCompat.getColor(this, R.color.white));
                button3.setText("Зеленая");

                // Переходим на Сочи
                if (webView != null) {
                    String sochiUrl = "https://yandex.ru/maps/?ll=39.7231,43.5855&z=12";
                    webView.loadUrl(sochiUrl);
                }

                button3State = 1;
            } else {
                button3.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
                button3.setTextColor(ContextCompat.getColor(this, R.color.black));
                button3.setText("Кнопка 3");
                button3State = 0;
            }
        });
    }
}
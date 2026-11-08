package com.example.pizza;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Log.d("STOS", "AboutActivity onCreate");

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("STOS", "AboutActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("STOS", "AboutActivity onDestroy");
    }
}

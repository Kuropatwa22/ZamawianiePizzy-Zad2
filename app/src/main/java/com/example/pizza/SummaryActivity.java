package com.example.pizza;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        findViewById(R.id.btnEdit).setOnClickListener(v -> finish());
    }
}

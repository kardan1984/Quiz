package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private String correctAnswers;
    private String result;
    private TextView resultView;
    private TextView resultView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result = getIntent().getStringExtra("userAnswers");
        resultView = findViewById(R.id.resultView);
        resultView.setText(result);

        correctAnswers = getIntent().getStringExtra("correctAnswers");
        resultView1 = findViewById(R.id.correctAnswers);
        resultView1.setText(correctAnswers);

    }
}
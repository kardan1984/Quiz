package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;

public class ResultActivity extends AppCompatActivity {

    private int correctAnswers;
    private String [] result;
    private TextView resultView;
    private TextView resultView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        result = getIntent().getStringArrayExtra("userAnswers");
        resultView = findViewById(R.id.resultView);
        resultView.setText("Поздравляем, вы прошли ТЕСТ: \n"+Arrays.toString(result));

        correctAnswers = getIntent().getIntExtra("correctAnswers",50505050);
        resultView1 = findViewById(R.id.correctAnswers);
        resultView1.setText("Правильных ответов: "+String.valueOf(correctAnswers));

    }
}
package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {

    private boolean isAnswerTrue;
    private TextView answerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        // Получаем дополнение
        isAnswerTrue = getIntent().getBooleanExtra("answer", false);
        // Сохраняем в переменную вью компонет из лейаута по id
        answerTextView = findViewById(R.id.answerTextView);
        // Печатаем текст на текст вью в зависимости от того, что пришло в isAnswerTrue
        answerTextView.setText(isAnswerTrue?R.string.yes:R.string.no);
        /*Могло быть так: if(isAnswerTrue)
            answerTextView.setText(R.string.yes);
        else
            answerTextView.setText(R.string.no);*/
    }
}
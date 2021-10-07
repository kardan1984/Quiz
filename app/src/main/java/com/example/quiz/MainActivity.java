package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Button yesBtn;
    Button noBtn;
    Button getAnswer;
    TextView textView;
    TextView textView2;
    Question[] questions = {
            new Question(R.string.question1, true),
            new Question(R.string.question2, true),
            new Question(R.string.question3, true),
            new Question(R.string.question4, false),
            new Question(R.string.question5, false)
    };

    String[] userAnswers = new String[questions.length];
    int questionIndex = 0;
    int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SYSTEM INFO:", "Вызван метод onCreate()");
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null){
            questionIndex = savedInstanceState.getInt("questionIndex");
        }

        yesBtn = findViewById(R.id.yesBtn);
        noBtn = findViewById(R.id.noBtn);
        getAnswer = findViewById(R.id.getAnswer);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);

        textView.setText(questions[questionIndex].getQuestionText());

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    checkAnswer(true);
                    }

        });
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
                }
        });

        getAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Создаём намерение (интент) указывая кто и какую активность хочет запустить
                Intent intent = new Intent(MainActivity.this,AnswerActivity.class);
                // Кладём дополнения (их может быть несколько)
                intent.putExtra("answer",questions[questionIndex].isAnswerTrue());
                // Стартуем активность
                startActivity(intent);
            }
        });

    }

    public void checkAnswer(boolean btn){
        if((questions[questionIndex].isAnswerTrue() && btn) || (!questions[questionIndex].isAnswerTrue() && !btn)){
            Toast.makeText(MainActivity.this, R.string.correct_answer, Toast.LENGTH_SHORT).show(); correctAnswers++;}
        else
            Toast.makeText(MainActivity.this, R.string.incorrect_answer, Toast.LENGTH_SHORT).show();

        String Btn;
        if (btn) Btn = "ДА"; else Btn = "НЕТ";
        userAnswers[questionIndex] = ("\n"+getString(questions[questionIndex].getQuestionText())+" - ваш ответ: "+Btn+"\n");

        questionIndex++;

        if (questionIndex == questions.length){
            questionIndex = 0;
            textView.setText(questions[questionIndex].getQuestionText());
            Intent intent1 = new Intent(MainActivity.this,ResultActivity.class);
            intent1.putExtra("userAnswers",userAnswers);
            intent1.putExtra("correctAnswers",correctAnswers);
            startActivity(intent1);
            textView.setText("Вы прошли этот тест");
            yesBtn.setClickable(false);
            noBtn.setClickable(false);
            getAnswer.setClickable(false);

        }
        else
            textView.setText(questions[questionIndex].getQuestionText());

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.d("SYSTEM INFO: ", "Вызван метод onSaveInstanceState()");
        savedInstanceState.putInt("questionIndex", questionIndex);
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d("SYSTEM INFO: ", "Вызван метод onStart()");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d("SYSTEM INFO: ", "Вызван метод onResume()");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d("SYSTEM INFO: ", "Вызван метод onPause()");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d("SYSTEM INFO: ", "Вызван метод onStop()");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("SYSTEM INFO: ", "Вызван метод onDestroy()");
    }
}
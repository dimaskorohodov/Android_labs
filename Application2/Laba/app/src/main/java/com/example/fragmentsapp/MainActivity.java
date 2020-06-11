package com.example.fragmentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements ActionListener {

    private AnswerFragment answerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answerFragment = (AnswerFragment) getSupportFragmentManager().findFragmentById(R.id.answerFragment);
    }

    @Override
    public void onQuestionReceived(Level level, Type type) {
        String answer = String.format(Locale.US,
                "Level: %s\nType: %s",
                level.getValue(), type.getValue()
        );
        answerFragment.setAnswer(answer);
    }
}
package com.example.fragmentsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AnswerFragment extends Fragment {

    private TextView textAnswer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_answer, container, false);
        textAnswer = view.findViewById(R.id.txtAnswer);
        return view;
    }

    public void setAnswer(String text) {
        textAnswer.setText(text);
    }
}
package com.example.fragmentsapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import static com.example.fragmentsapp.Level.HIGH;
import static com.example.fragmentsapp.Level.LOW;
import static com.example.fragmentsapp.Level.MEDIUM;
import static com.example.fragmentsapp.Type.PRACTICE;
import static com.example.fragmentsapp.Type.THEORY;

public class QuestionFragment extends Fragment {

    private Button btnGo;
    private RadioGroup rgLevel;
    private RadioGroup rgType;
    private ActionListener actionListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof ActionListener) {
            actionListener = (ActionListener) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question, container, false);
        btnGo = view.findViewById(R.id.btnGo);
        rgLevel = view.findViewById(R.id.rgLevel);
        rgType = view.findViewById(R.id.rgType);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        btnGo.setOnClickListener(v ->
                actionListener.onQuestionReceived(getLevel(), getType())
        );
    }

    private Level getLevel() {
        switch (rgLevel.getCheckedRadioButtonId()) {
            case R.id.rbLevel1: return LOW;
            case R.id.rbLevel2: return MEDIUM;
            case R.id.rbLevel3: return HIGH;
            default: return Level.UNDEFINED;
        }
    }

    private Type getType() {
        switch (rgType.getCheckedRadioButtonId()) {
            case R.id.rbTheory: return THEORY;
            case R.id.rbPractise: return PRACTICE;
            default: return Type.UNDEFINED;
        }
    }
}
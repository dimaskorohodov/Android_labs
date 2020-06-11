package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.io.FileOutputStream;
import java.io.IOException;

import static android.content.Context.MODE_PRIVATE;

public class AnswerFragment extends Fragment {
    private final static String FILE_NAME = "content.txt";

    private TextView textAnswer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_answer, container, false);
        textAnswer = view.findViewById(R.id.txtAnswer);
        return view;
    }

    public void setAnswer(String text) {
        textAnswer.setText(text);
        FileManager fileManager = new FileManager();

        fileManager.saveText();
    }


//    public void saveText(View view){
//
//        FileOutputStream fos = null;
//        try {
//           // EditText textBox = (EditText) findViewById(R.id.save_text);
//            String text = "lolkek";
//
//            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
//            fos.write(text.getBytes());
//            Toast.makeText(this, "Файл сохранен", Toast.LENGTH_SHORT).show();
//        }
//        catch(IOException ex) {
//
//            //Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//        finally{
//            try{
//                if(fos!=null)
//                    fos.close();
//            }
//            catch(IOException ex){
//
//               // Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        }
//    }


}
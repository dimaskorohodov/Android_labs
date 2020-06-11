
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] questions = {"What does manifest file stands for?", "What is \"resourse\" in android applications?", "to describe android application architecture"};
    String[] complexity = {"1", "2", "3"};
    String[] questionType = {"theory", "practise"};
    int selectedQuestion = 0;
    int selectedComplexity = 0;
    int selectedType = 0;

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView questionsList = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, questions);

        questionsList.setAdapter(adapter);


        // adapters
        ArrayAdapter<String> complexityAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, complexity);
        ArrayAdapter<String> questionTypeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, questionType);
        complexityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        questionTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner complexitySpinner = (Spinner) findViewById(R.id.spinner);
        Spinner questionTypeSpinner = (Spinner) findViewById(R.id.spinner2);
        complexitySpinner.setAdapter(complexityAdapter);
        questionTypeSpinner.setAdapter(questionTypeAdapter);
        // title
        complexitySpinner.setPrompt("Title");
        // выделяем элемент
        complexitySpinner.setSelection(0);
        questionTypeSpinner.setSelection(0);
        // устанавливаем обработчик нажатия
        complexitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                selectedComplexity = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        questionTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                selectedType = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "You choose:" + questions[selectedQuestion] + " " + complexity[selectedComplexity] + " " + questionType[selectedType], Toast.LENGTH_SHORT).show();
            }
        });

        questionsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                selectedQuestion = position;
            }
        });
    }

    public void onButtonClick(View view){
        Toast.makeText(getBaseContext(), "You choose:", Toast.LENGTH_SHORT).show();

    }
}

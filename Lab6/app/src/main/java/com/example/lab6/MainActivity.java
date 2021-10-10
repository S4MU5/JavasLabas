package com.example.lab6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String data = "";
    final static String dataVariableKey = "DATA_VAR";
    final static String textViewTextKey = "TEXT_VIEW";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button saveDataButton = findViewById(R.id.saveDataButton);
        Button getDataButton = findViewById(R.id.getDataButton);
        saveDataButton.setOnClickListener(this::saveData);
        getDataButton.setOnClickListener(this::getData);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(dataVariableKey,data);
        TextView textView = findViewById(R.id.textOutput);
        outState.putString(textViewTextKey,textView.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        data = savedInstanceState.getString(dataVariableKey);
        String textViewText = savedInstanceState.getString(textViewTextKey);
        TextView dataView = (TextView) findViewById(R.id.textOutput);
        Toast.makeText(this,"Состояние восстановлено",Toast.LENGTH_SHORT).show();
        dataView.setText(textViewText);
    }
    private void saveData(View view){
        TextView input = findViewById(R.id.textInput);
        data = input.getText().toString();
    }
    private void getData(View view){
        TextView output = findViewById(R.id.textOutput);
        output.setText(data);
    }

}
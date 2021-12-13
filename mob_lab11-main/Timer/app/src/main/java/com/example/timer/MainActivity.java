package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    private Chronometer _chrono;
    private Button startButton, stopButton, resetButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _chrono = (Chronometer) findViewById(R.id.simpleChronometer);
        startButton = (Button) findViewById(R.id.startButton);
        stopButton = (Button) findViewById(R.id.stopButton);
        resetButton = (Button) findViewById(R.id.restartButton);
    }
    public void startTimer(View view)
    {
        _chrono.setBase(SystemClock.elapsedRealtime());
        _chrono.start();
        this.startButton.setEnabled(false);
        this.stopButton.setEnabled(true);
        this.resetButton.setEnabled(true);
    }
    public void stopTimer(View view)
    {
        _chrono.stop();
        //
        this.startButton.setEnabled(true);
        this.stopButton.setEnabled(false);
    }
    public void resetTimer(View view)
    {
        _chrono.setBase(SystemClock.elapsedRealtime());
    }
}
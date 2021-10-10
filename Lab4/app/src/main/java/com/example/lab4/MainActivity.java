package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView img = findViewById(R.id.animationView);
        img.setBackgroundResource(R.drawable.rabbit_animation);
        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
        frameAnimation.setOneShot(false);
        frameAnimation.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
        AnimationDrawable img = (AnimationDrawable) findViewById(R.id.animationView).getBackground();
        Button stopBtn = findViewById(R.id.stopBtn);
        Button playBtn = findViewById(R.id.playBtn);
        Button zxcBtn = findViewById(R.id.zxcBtn);
        if(img.isRunning()){
            playBtn.setEnabled(false);
            stopBtn.setEnabled(true);
        }else{
            playBtn.setEnabled(true);
            stopBtn.setEnabled(false);
        }
        stopBtn.setOnClickListener(view -> {
            img.stop();
            stopBtn.setEnabled(false);
            playBtn.setEnabled(true);
        });
        playBtn.setOnClickListener(view -> {
            img.start();
            stopBtn.setEnabled(true);
            playBtn.setEnabled(false);
        });
        zxcBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, zxc.class);
            startActivity(intent);
        });

    }
}

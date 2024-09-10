package com.example.myapplication;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView animationIV;
    private Button frameAnimBtn;
    private Button pauseBtn;
    private Button nextActivityBtn;
    private AnimationDrawable frameAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animationIV = findViewById(R.id.animImageView);
        frameAnimBtn = findViewById(R.id.frameAnimButton);
        pauseBtn = findViewById(R.id.pauseButton);
        nextActivityBtn = findViewById(R.id.nextActivityButton);

        frameAnimation = (AnimationDrawable) animationIV.getDrawable();

        // Load animations
        Animation scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        Animation scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        frameAnimBtn.setOnClickListener(v -> {
            frameAnimBtn.startAnimation(scaleUp);
            frameAnimBtn.startAnimation(scaleDown);
            if (!frameAnimation.isRunning()) {
                frameAnimation.start();
            }
        });

        pauseBtn.setOnClickListener(v -> {
            pauseBtn.startAnimation(scaleUp);
            pauseBtn.startAnimation(scaleDown);
            if (frameAnimation.isRunning()) {
                frameAnimation.stop();
            }
            animationIV.clearAnimation();
        });

        nextActivityBtn.setOnClickListener(v -> {
            nextActivityBtn.startAnimation(scaleUp);
            nextActivityBtn.startAnimation(scaleDown);
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);  // Анимация перехода
        });
    }
}

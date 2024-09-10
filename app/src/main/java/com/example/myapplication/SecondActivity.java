package com.example.myapplication;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private ImageView animationIV;
    private Button tweenAnimBtn;
    private Button pauseBtn;
    private Button backBtn;
    private Animation blinkAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        animationIV = findViewById(R.id.animImageView);
        tweenAnimBtn = findViewById(R.id.tweenAnimButton);
        pauseBtn = findViewById(R.id.pauseButton);
        backBtn = findViewById(R.id.backButton);

        blinkAnimation = AnimationUtils.loadAnimation(this, R.anim.blink_animation);
        Animation scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        Animation scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        tweenAnimBtn.setOnClickListener(view -> {
            tweenAnimBtn.startAnimation(scaleUp);
            tweenAnimBtn.startAnimation(scaleDown);
            animationIV.startAnimation(blinkAnimation);
        });

        pauseBtn.setOnClickListener(view -> {
            pauseBtn.startAnimation(scaleUp);
            pauseBtn.startAnimation(scaleDown);
            animationIV.clearAnimation();
        });

        backBtn.setOnClickListener(v -> {
            backBtn.startAnimation(scaleUp);
            backBtn.startAnimation(scaleDown);
            finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });
    }
}

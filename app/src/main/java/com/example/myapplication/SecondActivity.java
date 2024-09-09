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

        tweenAnimBtn.setOnClickListener(view -> animationIV.startAnimation(blinkAnimation));

        pauseBtn.setOnClickListener(view -> {
            animationIV.clearAnimation();
        });

        backBtn.setOnClickListener(v -> {
            finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });
    }
}

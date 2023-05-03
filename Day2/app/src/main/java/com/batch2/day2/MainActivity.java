package com.batch2.day2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Runnable{

    TextView tv1;
    ImageView iv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.text1);
        iv1 = findViewById(R.id.img1);
        Animation an1 = AnimationUtils.loadAnimation(this, R.anim.blink);
        tv1.startAnimation(an1);
        iv1.startAnimation(an1);

        MediaPlayer mp1 = MediaPlayer.create(this,R.raw.overtaken_onepiece);
        mp1.start();

        Handler h1 = new Handler();
        h1.postDelayed(this, 20000);
    }

    @Override
    public void run() {
        Intent i1 = new Intent(this, HomeActivity.class);
        startActivity(i1);
    }

}
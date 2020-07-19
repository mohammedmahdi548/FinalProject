package com.example.mygarage_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int Screen = 5000;
    Animation topAnim,bottomAnim;
    ImageView logo;
    TextView appname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //Animation
        topAnim = AnimationUtils.loadAnimation(this,R.anim.animation_top);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.animation_bottom);
        //Hooks
        logo = findViewById(R.id.logo);
        appname = findViewById(R.id.name);
        //Calling
        logo.setAnimation(topAnim);
        appname.setAnimation(bottomAnim);
        //Delay
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intents = new Intent(MainActivity.this,Categories.class);
                startActivity(intents);
                finish();

            }
        },Screen);
    }
}
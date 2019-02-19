package com.cempakaweb.shoutuna;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EasySplashScreen config = new EasySplashScreen(SplashActivity.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(4000)
                .withBackgroundResource(android.R.color.black)
                .withFooterText("Copyright  2019")
                .withLogo(R.drawable.shoutuna_splash);


        //set your own animations
        myCustomTextViewAnimation(config.getFooterTextView());
        config.getLogo().getLayoutParams().height = 318;
        config.getLogo().getLayoutParams().width = 324;
        config.getLogo().setScaleType(ImageView.ScaleType.FIT_XY);
        //customize all TextViews
        Typeface pacificoFont = Typeface.createFromAsset(getAssets(), "Pacifico.ttf");
        config.getFooterTextView().setTypeface(pacificoFont);
        config.getFooterTextView().setTextSize(TypedValue.COMPLEX_UNIT_SP,10);
        config.getFooterTextView().setTextColor(Color.WHITE);

        //create the view
        View easySplashScreenView = config.create();

        setContentView(easySplashScreenView);
    }

    private void myCustomTextViewAnimation(TextView tv){
        Animation animation=new TranslateAnimation(0,0,480,0);
        animation.setDuration(1200);
        tv.startAnimation(animation);
    }
}

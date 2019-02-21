package com.cempakaweb.shoutuna;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;

import co.mobiwise.library.RadioListener;
import co.mobiwise.library.RadioManager;

public class MainActivity extends AppCompatActivity implements RadioListener {
    private final String[] RADIO_URL = {"http://202.65.114.229:9302/listen.pls"};
    RadioManager mRadioManager;
    ImageView mButtonControlStart;
    TextView mTextViewControl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRadioManager = RadioManager.with(getApplicationContext());
        mRadioManager.registerListener(this);
        mRadioManager.setLogging(true);
        initializeUI();
        SosialClick();
        fabClick();
    }

    public void SosialClick() {
        igClick();
        twitterClick();
        fbClick();
        waClick();
    }

    public void fabClick(){
        aboutClick();
        sponsoreClick();
        personClick();
        programClick();
    }

    public void aboutClick(){
        FloatingActionButton fab = findViewById(R.id.action_about);
        Intent intent = new Intent(MainActivity.this,AboutActivity.class);
        buttonClick(fab,intent);
    }

    public void programClick(){
        FloatingActionButton fab = findViewById(R.id.action_program);
        Intent intent = new Intent(MainActivity.this,ProgramActivity.class);
        buttonClick(fab,intent);
    }

    public void sponsoreClick()
    {
        FloatingActionButton fab = findViewById(R.id.action_sponsor);
        Intent intent = new Intent(MainActivity.this,SponsoreActivity.class);
        buttonClick(fab,intent);
    }

    public void personClick()
    {
        FloatingActionButton fab = findViewById(R.id.action_person);
        Intent intent = new Intent(MainActivity.this,PersonActivity.class);
        buttonClick(fab,intent);
    }

    private void buttonClick(FloatingActionButton fab, final Intent intent ) {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(intent);
            }
        });
    }

    public void waClick(){
        ImageView wa = findViewById(R.id.wa);
        wa.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                try {
                    String toNumber = "+6285218893893";
                    Intent sendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + "" + toNumber + "?body=" + ""));
                    sendIntent.setPackage("com.whatsapp");
                    startActivity(sendIntent);
                }
                catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this,"Anda belum memiliki aplikasi whatsapp",Toast.LENGTH_LONG).show();
                }
            }

        });
    }

    public void igClick(){
        ImageView Ig = findViewById(R.id.ig);
        Ig.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.instagram.com/shoutuna_fm");
                sosialClick(uri, "com.instagram.android", "https://www.instagram.com/shoutuna_fm");

            }

        });
    }

    private void sosialClick(Uri uri, String s, String s2) {
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);
        likeIng.setPackage(s);

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(s2)));
        }
    }

    public void twitterClick(){
        ImageView twitter = findViewById(R.id.twitter);
        twitter.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                Uri uri = Uri.parse("https://twitter.com/shoutuna_fm");
                sosialClick(uri, "com.twitter.android", "https://twitter.com/shoutuna_fm");
            }

        });
    }

    public void fbClick(){
        ImageView fb = findViewById(R.id.fb);
        fb.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.facebook.com/shoutuna");
                sosialClick(uri, "com.facebook.katana", "https://www.facebook.com/shoutuna");
            }

        });
    }

    public void initializeUI() {
        mButtonControlStart = (ImageView) findViewById(R.id.btn_play_pause);
        mTextViewControl = (TextView) findViewById(R.id.song_title);

        mButtonControlStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mRadioManager.isPlaying())
                    mRadioManager.startRadio("http://202.65.114.229:9302/listen.pls");
                else
                    mRadioManager.stopRadio();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mRadioManager.connect();
    }


    public void onRadioLoading() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //TODO Do UI works here.
                mTextViewControl.setText("Radio State : LOADING...");
            }
        });
    }

    @Override
    public void onRadioConnected() {

    }

    @Override
    public void onRadioStarted() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //TODO Do UI works here.
                mTextViewControl.setText("Radio State : PLAYING...");
                mButtonControlStart.setImageResource(R.drawable.ic_pause_icons);
            }
        });
    }

    @Override
    public void onRadioStopped() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //TODO Do UI works here
                mTextViewControl.setText("Radio State : STOPPED.");
                mButtonControlStart.setImageResource(R.drawable.ic_play_icons);
            }
        });
    }

    @Override
    public void onMetaDataReceived(String s, final String s1) {
            final String song_title= s1.replaceAll("\\s{2,}","-").toLowerCase();
        if ("StreamTitle".equals(s)) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mTextViewControl.setText(getCapsSentences(song_title));
                }
            });
        }
    }

    private String getCapsSentences(String tagName) {
        String[] splits = tagName.toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < splits.length; i++) {
            String eachWord = splits[i];
            if (i > 0 && eachWord.length() > 0) {
                sb.append(" ");
            }
            String cap = eachWord.substring(0, 1).toUpperCase()
                    + eachWord.substring(1);
            sb.append(cap);
        }
        return sb.toString();
    }
}

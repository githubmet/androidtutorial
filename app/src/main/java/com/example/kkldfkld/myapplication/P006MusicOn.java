package com.example.kkldfkld.myapplication;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.RelativeLayout;
import android.media.MediaPlayer;

public class P006MusicOn extends Activity {
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout relativeLayout=new RelativeLayout(this);
        setContentView(relativeLayout);

        mediaPlayer=MediaPlayer.create(this,R.raw.splassoundeffect);

        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean musinOn= sharedPreferences.getBoolean("musicOn",false);
        if(musinOn){
            mediaPlayer.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
    }
}


/*

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.RelativeLayout;

public class P006MusicOn extends Activity {
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout relativeLayout=new RelativeLayout(this);
        relativeLayout.setBackgroundColor(Color.GRAY);

        mediaPlayer=MediaPlayer.create(this,R.raw.splassoundeffect);

        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        Boolean musicOn= sharedPreferences.getBoolean("musicOn",true);
        if(musicOn){
            mediaPlayer.start();
        }

    }
    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
    }
}
*/


/*
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.RelativeLayout;
import android.media.MediaPlayer;

public class P006MusicOn extends Activity{

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout relativeLayout=new RelativeLayout(this);
        relativeLayout.setBackgroundColor(Color.CYAN);

        setContentView(relativeLayout);

        mediaPlayer=MediaPlayer.create(P006MusicOn.this,R.raw.splassoundeffect);

        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        Boolean musicOn= sharedPreferences.getBoolean("musicOn",true);
        if(musicOn) {
            mediaPlayer.start();  //fakat kapatmanda gerekir
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.release();
    }
}*/

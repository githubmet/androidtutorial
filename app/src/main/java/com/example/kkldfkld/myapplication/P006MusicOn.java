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

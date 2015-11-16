package com.example.kkldfkld.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.preference.PreferenceManager;
import android.content.SharedPreferences;
import android.widget.Toast;

public class P006PreferencesGetInfo extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p006preferencegetinfo);
    }

    public void onClickMtdP006(View view){
        TextView textViewNameP006=(TextView)findViewById(R.id.textViewNameP006);
        TextView textViewSurnameP006=(TextView)findViewById(R.id.textViewSurnameP006);

        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String editTextPreferenceName= sharedPreferences.getString("editTextPreferenceName","Null");
        String editTextPreferenceSurname= sharedPreferences.getString("editTextPreferenceSurname","Null");

        textViewNameP006.setText(editTextPreferenceName);
        textViewSurnameP006.setText(editTextPreferenceSurname);


    }
    public void onClickMtd2P006(View view){
        SharedPreferences sharedPreferences=  PreferenceManager.getDefaultSharedPreferences(getBaseContext());  //donen degeri bulmak icin yazim sirasinda en sona bak IDE de
        Boolean musicOn= sharedPreferences.getBoolean("musicOn",true);
        if(musicOn){
            Toast.makeText(P006PreferencesGetInfo.this,"Music On",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(P006PreferencesGetInfo.this,"Music Off",Toast.LENGTH_SHORT).show();
        }
    }
    public void onClickMtd3P006(View view){
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String ulasim= sharedPreferences.getString("listPreference", "yaya this is default value");

        Toast.makeText(P006PreferencesGetInfo.this,ulasim,Toast.LENGTH_SHORT).show();
    }
    public void onClickMtd4P006(View view){
        Intent intent=new Intent(P006PreferencesGetInfo.this,P006MusicOn.class);
        startActivity(intent);
    }
}

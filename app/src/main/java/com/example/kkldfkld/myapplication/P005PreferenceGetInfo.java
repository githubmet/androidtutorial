package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class P005PreferenceGetInfo extends Activity {
    TextView textViewName;
    TextView textViewSurnameP006;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p006preferencegetinfo);

        textViewName =(TextView)findViewById(R.id.textViewNameP006);
        textViewSurnameP006= (TextView)findViewById(R.id.textViewSurnameP006);
    }

    public void onClickMtdP006(View view) {

        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String name= sharedPreferences.getString("editTextPreferenceName2", "null");
        textViewName.setText(name);

        String surname=sharedPreferences.getString("editTextPreferenceSurname2","null");
        textViewSurnameP006.setText(surname);
    }

    public void onClickMtd2P006(View view) {
        SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String music=String.valueOf(sharedPreferences.getBoolean("checkBoxPreferenceMusic2", true));

        Toast.makeText(this,music,Toast.LENGTH_SHORT).show();
    }

    public void onClickMtd3P006(View view) {

        SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String transport=sharedPreferences.getString("listPreferenceTransport", "yaya is default value");

        Toast.makeText(this,transport,Toast.LENGTH_SHORT).show();
    }
    public void onClickMtd4P006(View view){
        Intent intent=new Intent(P005PreferenceGetInfo.this,P006MusicOn.class);
        startActivity(intent);
    }
}

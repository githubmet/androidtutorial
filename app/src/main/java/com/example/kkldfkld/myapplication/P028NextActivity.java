package com.example.kkldfkld.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import android.content.Intent;
import android.content.SharedPreferences;

public class P028NextActivity extends Activity{

    private static final String DEFAULT = "n/a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p028nextactivity);
    }

    public void onClickLoadMtdP028(View view) {
        TextView textViewNameP028=(TextView)findViewById(R.id.textViewNameP028);
        TextView textViewPasswordP028=(TextView)findViewById(R.id.textViewPasswordP028);

        SharedPreferences sharedPreferences= getSharedPreferences("Freedom",MODE_PRIVATE);
        textViewNameP028.setText(sharedPreferences.getString("UserId", DEFAULT));
        textViewPasswordP028.setText(sharedPreferences.getString("Password", DEFAULT));

    }

    public void onClickPreviousMtdP028(View view) {
        Intent intent=new Intent(P028NextActivity.this,P028SharedPreferences.class);
        startActivity(intent);
        finish();
    }
}

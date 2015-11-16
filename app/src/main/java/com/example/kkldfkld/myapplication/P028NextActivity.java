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
    }
}
/*
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class P028NextActivity extends Activity{
    public static final  String DEFAULT="N/A";
    TextView textViewNameP028;
    TextView textViewPasswordP028;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p028nextactivity);

        textViewNameP028=(TextView)findViewById(R.id.textViewNameP028);
        textViewPasswordP028= (TextView)findViewById(R.id.textViewPasswordP028);
    }
    public void onClickLoadMtdP028(View view){
        SharedPreferences sharedPreferences= getSharedPreferences("MyDataP028",MODE_PRIVATE);
        String Name= sharedPreferences.getString("Name",DEFAULT);
        String Password=sharedPreferences.getString("Password",DEFAULT);

        if(Name.equals(DEFAULT) || Password.equals(DEFAULT)){
            Toast.makeText(this,"No data was found",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Data loaded successfully",Toast.LENGTH_SHORT).show();
            textViewNameP028.setText(Name);
            textViewPasswordP028.setText(Password);
        }
    }
    public void onClickPreviousMtdP028(View view){
        Toast.makeText(this, "Go To Previous Activity", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,P028SharedPreferences.class);
        startActivity(intent);
    }
}
*/

package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.Intent;

import android.widget.EditText;
import android.widget.Toast;

public class P028SharedPreferences extends Activity {

    EditText editTextNameP028;
    EditText editTextPasswordP028;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p028sharedpreferences);

        editTextNameP028=(EditText)findViewById(R.id.editTextNameP028);
        editTextPasswordP028=(EditText)findViewById(R.id.editTextPasswordP028);
    }

    public void onClickSaveMtdP028(View view) {
        SharedPreferences sharedPreferences= getSharedPreferences("Freedom",MODE_PRIVATE);
        Editor  editor= sharedPreferences.edit();
        editor.putString("UserId",editTextNameP028.getText().toString());
        editor.putString("Password",editTextPasswordP028.getText().toString());
        editor.commit();
        Toast.makeText(this,"This User's information is saved successfully",Toast.LENGTH_SHORT).show();
    }

    public void onClickNextMtdP028(View view) {
        Intent intent =new Intent(P028SharedPreferences.this,P028NextActivity.class);
        startActivity(intent);


    }
}

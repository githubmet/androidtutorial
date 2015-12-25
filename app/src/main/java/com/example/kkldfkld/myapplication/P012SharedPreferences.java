package com.example.kkldfkld.myapplication;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class P012SharedPreferences extends Activity {

    EditText editTextName;
    EditText editTextSurname;
    TextView textViewName;
    TextView textViewSurname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p012sharedpreferences);

        editTextName=(EditText)findViewById(R.id.editText_name);
        editTextSurname=(EditText)findViewById(R.id.editText_surname);
        textViewName= (TextView)findViewById(R.id.textView_name);
        textViewSurname= (TextView)findViewById(R.id.textView_surname);

    }

    public void onClickSave(View view) {
        SharedPreferences sharedPreferences= getSharedPreferences("GetSharePref",MODE_PRIVATE);
         SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString("name",editTextName.getText().toString().toUpperCase());
        editor.putString("surname",editTextSurname.getText().toString().toLowerCase());
        editor.apply();

    }

    public void onClickGet(View view) {
        SharedPreferences sharedPreferences= getSharedPreferences("GetSharePref",MODE_PRIVATE);
        String name= sharedPreferences.getString("name","null2");
        String surname=sharedPreferences.getString("surname","null2");

        textViewName.setText(name);
        textViewSurname.setText(surname);
    }
}
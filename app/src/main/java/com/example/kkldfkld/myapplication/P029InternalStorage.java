package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class P029InternalStorage extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p028sharedpreferences);

    }

    public void onClickSaveMtdP028(View view) {
        EditText editTextNameP028= (EditText)findViewById(R.id.editTextNameP028);
        EditText editTextPasswordP028= (EditText)findViewById(R.id.editTextPasswordP028);
        try {

            byte[] buffer=editTextNameP028.getText().toString().getBytes();
            byte[] bufferPassword=editTextPasswordP028.getText().toString().getBytes();
            FileOutputStream fileOutputStream = openFileOutput("Freedom",MODE_PRIVATE);
            fileOutputStream.write(buffer);
            fileOutputStream.write(bufferPassword);

            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Toast.makeText(this,"User's info is saved successfull",Toast.LENGTH_SHORT).show();
    }
    public void onClickNextMtdP028(View view) {
        Intent intent=new Intent(P029InternalStorage.this,P029NextActivity.class);
        startActivity(intent);
    }
}
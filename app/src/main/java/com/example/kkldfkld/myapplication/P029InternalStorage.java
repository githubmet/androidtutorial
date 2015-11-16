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
            FileOutputStream fileOutputStream= openFileOutput("Freedom",MODE_PRIVATE);
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


/*
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.content.Intent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class P029InternalStorage extends Activity {

    EditText editTextNameP028;
    EditText editTextPasswordP028;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p028sharedpreferences);
        editTextNameP028= (EditText)findViewById(R.id.editTextNameP028);
        editTextPasswordP028=(EditText)findViewById(R.id.editTextPasswordP028);

    }
    public void onClickSaveMtdP028(View view){
        String Name=editTextNameP028.getText().toString();
        String Password=editTextPasswordP028.getText().toString();
        File file=null; //bu ekstra
        FileOutputStream fileOutputStream=null;
        Name =Name+" ";//cunku NamePassword olarak bitisik gitmesini istemiyoruz
        try {
            file=getFilesDir(); //bu ekstra
            fileOutputStream=openFileOutput("denemeP029.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(Name.getBytes());
            fileOutputStream.write(Password.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try {  //aslinda null olan bir connection kapatmanda farkli bir hataya sebep olabilir! dikkat bunun icin kontrol yapman daha iyi
                fileOutputStream.close();  //yukaridaki hata durumlarinda bile kapatilsin
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        Toast.makeText(this,"Data was saved successfully "+file+" /denemeP029.txt",Toast.LENGTH_SHORT).show();
    }
    public void onClickNextMtdP028(View view){
        Toast.makeText(this,"The next Activity ",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(P029InternalStorage.this,P029NextActivity.class);
        startActivity(intent);
    }
}

*/

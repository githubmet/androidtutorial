package com.example.kkldfkld.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import android.widget.Toast;

public class P021FileOutputStream extends Activity implements View.OnClickListener{

    FileOutputStream fileOutputStream;
    FileInputStream fileInputStream;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p021fileoutputstream);

        Button buttonSaveP021= (Button)findViewById(R.id.buttonSaveP021);
        Button buttonLoadP021= (Button)findViewById(R.id.buttonLoadP021);
        buttonSaveP021.setOnClickListener(this);
        buttonLoadP021.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonSaveP021:

                EditText editTextP021= (EditText)findViewById(R.id.editTextP021);
                String saveData= editTextP021.getText().toString();

                try {
                    fileOutputStream = openFileOutput("savedData", Context.MODE_PRIVATE);
                    byte[] buffer=saveData.getBytes();
                    fileOutputStream.write(buffer);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally {
                    try {
                        fileOutputStream.close();
                        Toast.makeText(this,"Congurulations",Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                break;
            case R.id.buttonLoadP021:
                String loadedData=null;
                try {
                    fileInputStream =openFileInput("savedData");
                    byte[] buffer2=new byte[fileInputStream.available()];


                    while(fileInputStream.read(buffer2) != -1)
                    {
                        loadedData= new String(buffer2);
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally{
                    try {
                        fileInputStream.close();
                        TextView textViewP021= (TextView)findViewById(R.id.textViewP021);
                        textViewP021.setText(loadedData);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }
}

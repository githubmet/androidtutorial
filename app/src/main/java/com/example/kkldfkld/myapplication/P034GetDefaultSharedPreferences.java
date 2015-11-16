package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.EditText;
import android.preference.PreferenceManager;
import android.content.SharedPreferences;
import android.widget.Toast;

public class P034GetDefaultSharedPreferences extends Activity implements View.OnClickListener{

    Button buttonSettingsP034;
    Button buttonTextSizeP034;
    Button buttonTextModeP034;
    EditText editTextNotPadP034;
    private static final int REQUESTCODE=12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p034getdefaultsharedpreferences);

        buttonSettingsP034= (Button)findViewById(R.id.buttonSettingsP034);
        buttonTextModeP034= (Button)findViewById(R.id.buttonTextModeP034);
        buttonTextSizeP034= (Button)findViewById(R.id.buttonTextSizeP034);
        editTextNotPadP034= (EditText)findViewById(R.id.editTextNotPadP034);

        buttonSettingsP034.setOnClickListener(this);
        buttonTextModeP034.setOnClickListener(this);
        buttonTextSizeP034.setOnClickListener(this);
    }


    public void onClick(View v){
        if(v.getId()== R.id.buttonSettingsP034){
            Intent intent=new Intent(this,P034PreferenceActivity.class);
            startActivityForResult(intent,REQUESTCODE);
        }
        else if(v.getId()==R.id.buttonTextModeP034){

            SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
            boolean boldOrNot= sharedPreferences.getBoolean("CheckBoxPreferenceTextMode",false);
            Toast.makeText(this, String.valueOf(boldOrNot), Toast.LENGTH_SHORT).show();

        }
        else if(v.getId()==R.id.buttonTextSizeP034){
            SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
            String textSize= sharedPreferences.getString("ListPrefernceTextSize","14");

            Toast.makeText(this,textSize,Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"what a hell done!",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUESTCODE){
           updateEditTextStyle();
        }
    }

    private void updateEditTextStyle() {
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);

        boolean boldOrNot= sharedPreferences.getBoolean("CheckBoxPreferenceTextMode",false);
        if(boldOrNot){
            editTextNotPadP034.setTypeface(null, Typeface.BOLD_ITALIC);
        }
        else{
            editTextNotPadP034.setTypeface(null,Typeface.NORMAL);
        }

        String textSize= sharedPreferences.getString("ListPrefernceTextSize","14");
        float size=Float.parseFloat(textSize);
        editTextNotPadP034.setTextSize(size);

    }
}










/*

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;
import android.widget.EditText;
//Altta belirtilen sorun onActivityResult Methodu override yapilarak halledildi!
//genel sikinti PreferenceActivity de olan degisiklik aninda this Activity de yakalanamiyor. Degisikligin yakalanabilmesi icin Button Click olmali
public class P034GetDefaultSharedPreferences extends Activity implements View.OnClickListener {
    EditText editTextNotPadP034;
    private static final int MY_REQUEST_CODE=111;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p034getdefaultsharedpreferences);

        Button buttonSettings= (Button)findViewById(R.id.buttonSettingsP034);
        Button buttonTextModeP034= (Button)findViewById(R.id.buttonTextModeP034);
        Button buttonTextSizeP034= (Button)findViewById(R.id.buttonTextSizeP034);
        editTextNotPadP034=(EditText)findViewById(R.id.editTextNotPadP034);
        buttonSettings.setOnClickListener(this);
        buttonTextModeP034.setOnClickListener(this);
        buttonTextSizeP034.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.buttonSettingsP034:
                Intent intent=new Intent(this,P034PreferenceActivity.class);
                startActivityForResult(intent, MY_REQUEST_CODE);
                break;
            case R.id.buttonTextModeP034:
                SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                boolean boldOrNot= sharedPreferences.getBoolean("CheckBoxPreferenceTextMode",false);
                Toast.makeText(this, String.valueOf(boldOrNot), Toast.LENGTH_SHORT).show();

                if(boldOrNot){
                    editTextNotPadP034.setTypeface(null,Typeface.BOLD);
                }
                else{
                    editTextNotPadP034.setTypeface(null,Typeface.NORMAL);
                }
                break;
            case R.id.buttonTextSizeP034:
                SharedPreferences sharedPreferences2= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                String textSize= sharedPreferences2.getString("ListPrefernceTextSize", "16");
                Toast.makeText(this,textSize,Toast.LENGTH_SHORT).show();

                Long size=Long.parseLong(textSize);
                editTextNotPadP034.setTextSize(size);

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {    //bu method un gorevi herhangi bir PreferenceActivity deki degisikligi
        super.onActivityResult(requestCode, resultCode, data); //aninda hayata gecirmek

        if(requestCode==MY_REQUEST_CODE){  //MY_REQUEST_CODE  ise ilgili PreferenceActivity yi yakalayabilmek!  //dikkat resultCode degil
            //Text Mode
            SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            boolean boldOrNot= sharedPreferences.getBoolean("CheckBoxPreferenceTextMode",false);
            Toast.makeText(this, String.valueOf(boldOrNot), Toast.LENGTH_SHORT).show();

            if(boldOrNot){
                editTextNotPadP034.setTypeface(null,Typeface.BOLD);
            }
            else{
                editTextNotPadP034.setTypeface(null,Typeface.NORMAL);
            }

            //Text Size
            SharedPreferences sharedPreferences2= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            String textSize= sharedPreferences2.getString("ListPrefernceTextSize", "16");
            Long size=Long.parseLong(textSize);
            editTextNotPadP034.setTextSize(size);
        }
    }
}
*/

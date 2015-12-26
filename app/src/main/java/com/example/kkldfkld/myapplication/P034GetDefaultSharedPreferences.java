package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.content.SharedPreferences;
import android.widget.Toast;

public class P034GetDefaultSharedPreferences extends Activity implements View.OnClickListener{

    Button buttonSettingsP034;
    Button buttonTextSizeP034;
    Button buttonTextModeP034;
    EditText editTextNotPadP034;
    static final int REQUESTCODE=2514;
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

        updateEditTextStyle();
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
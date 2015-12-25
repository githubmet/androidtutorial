package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;

public class P004SetInputType extends Activity implements View.OnClickListener{

    EditText editTextP004;
    EditText editText2P004;
    ToggleButton toggleButtonP004;
    ToggleButton toggleButton2P004;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p004setinputtype);

        editTextP004= (EditText)findViewById(R.id.editTextP004);
        editText2P004= (EditText)findViewById(R.id.editText2P004);
        toggleButtonP004=(ToggleButton)findViewById(R.id.toggleButtonP004);
        toggleButton2P004=(ToggleButton)findViewById(R.id.toggleButton2P004);

        toggleButtonP004.setOnClickListener(this);
        toggleButton2P004.setOnClickListener(this);


        editTextP004.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        editText2P004.setInputType(InputType.TYPE_CLASS_TEXT |InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.toggleButtonP004:
                if(toggleButtonP004.isChecked()){
                    editTextP004.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_NORMAL);
                }
                else{
                    editTextP004.setInputType(InputType.TYPE_CLASS_NUMBER |InputType.TYPE_NUMBER_VARIATION_PASSWORD);
                }
                break;
            case R.id.toggleButton2P004:
                if(toggleButton2P004.isChecked()){
                    editText2P004.setInputType(InputType.TYPE_CLASS_TEXT |InputType.TYPE_TEXT_VARIATION_NORMAL);
                }
                else{
                    editText2P004.setInputType(InputType.TYPE_CLASS_TEXT |InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                break;
        }
    }
}

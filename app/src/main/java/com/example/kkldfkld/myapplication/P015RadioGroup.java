package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

public class P015RadioGroup extends Activity implements RadioGroup.OnCheckedChangeListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p015radiogroup);
        RadioGroup radioGroup= (RadioGroup)findViewById(R.id.radioGroupP015);
        radioGroup.setOnCheckedChangeListener(this);

    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        final TextView textViewP015=(TextView)findViewById(R.id.textViewP015);
        switch(checkedId){
            case R.id.radioButtonP015:
                textViewP015.setText("CXiest");
                break;
            case R.id.radioButton2P015:
                textViewP015.setText("SXiest");
                break;
            case R.id.radioButton3P015:
                textViewP015.setText("STGXiest");
                break;
        }
    }
}


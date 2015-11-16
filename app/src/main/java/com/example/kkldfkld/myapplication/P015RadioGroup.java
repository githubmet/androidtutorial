package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

public class P015RadioGroup extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p015radiogroup);


        final TextView textViewP015=(TextView)findViewById(R.id.textViewP015);
        RadioGroup radioGroup= (RadioGroup)findViewById(R.id.radioGroupP015);
        radioGroup.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
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
        );

    }
}




/*
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.RadioGroup;

public class P015RadioGroup extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p015radiogroup);

    }
    public void onClickMtdP015(View view){
        final TextView textViewP015= (TextView)findViewById(R.id.textViewP015);
        RadioGroup radioGroupP015= (RadioGroup)findViewById(R.id.radioGroupP015);

        radioGroupP015.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        switch(checkedId){
                            case R.id.radioButtonP015:
                                textViewP015.setText("Crazy");
                                break;
                            case R.id.radioButton2P015:
                                textViewP015.setText("Sexy");
                                break;
                            case R.id.radioButton3P015:
                                textViewP015.setText("Strange");
                                break;
                        }
                    }
                }
        );
    }

}
*/

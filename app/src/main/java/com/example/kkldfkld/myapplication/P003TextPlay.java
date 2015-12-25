package com.example.kkldfkld.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import android.text.InputType;

import java.util.Random;

public class P003TextPlay extends Activity implements View.OnClickListener {

    Button buttonResults;
    ToggleButton toggleButton;
    EditText editTextCommands;
    TextView textViewResults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p003textplay);

        buttonResults= (Button)findViewById(R.id.buttonResults);
        toggleButton=(ToggleButton)findViewById(R.id.toggleButton);

        buttonResults.setOnClickListener(this);

        toggleButton.setOnClickListener(this);

        editTextCommands= (EditText)findViewById(R.id.editTextCommands);
        editTextCommands.setInputType(InputType.TYPE_TEXT_VARIATION_NORMAL | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        textViewResults=(TextView)findViewById(R.id.textViewResults);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonResults:
                switch(editTextCommands.getText().toString()){
                    case "left":
                        textViewResults.setGravity(Gravity.LEFT);
                        textViewResults.setText("left");
                        break;
                    case "right":
                        textViewResults.setGravity(Gravity.RIGHT);
                        textViewResults.setText("right");
                        break;
                    case "center":
                        textViewResults.setGravity(Gravity.CENTER);
                        textViewResults.setText("center");
                        break;
                    case "wft":
                        Random r=new Random();
                        int rastgele=r.nextInt(3);
                        textViewResults.setText("wft");
                        textViewResults.setTextSize(r.nextInt(75));
                        textViewResults.setTextColor(Color.rgb(r.nextInt(255), r.nextInt(255), r.nextInt(255)));

                        if(rastgele==0) {
                            textViewResults.setGravity(Gravity.LEFT);
                        }
                        else if(rastgele==1) {
                            textViewResults.setGravity(Gravity.RIGHT);
                        }
                        else {
                            textViewResults.setGravity(Gravity.CENTER);
                        }
                        break;
                    case "blue":
                        textViewResults.setText("blue");
                        textViewResults.setTextColor(Color.BLUE);
                    break;
                    default :
                        textViewResults.setText("You can type a command like:\nleft\nright\ncenter\nwft\nblue");
                        textViewResults.setGravity(Gravity.CENTER);
                        textViewResults.setTextColor(Color.RED);
                        break;

                }
                break;
            case R.id.toggleButton:
                if(!toggleButton.isChecked()){
                    editTextCommands.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                else{
                    editTextCommands.setInputType(InputType.TYPE_TEXT_VARIATION_NORMAL);
                }
                break;
        }
    }
}

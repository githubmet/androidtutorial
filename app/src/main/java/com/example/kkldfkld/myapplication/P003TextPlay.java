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




/*

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Random;

public class P003TextPlay extends Activity implements View.OnClickListener{

    EditText editTextCommands;
    Button buttonResults;
    ToggleButton toggleButton;
    TextView textViewResults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p003textplay);

        icerikMtd();

        buttonResults.setOnClickListener(this);
        toggleButton.setOnClickListener(this);
    }

    private void icerikMtd() {
        editTextCommands= (EditText)findViewById(R.id.editTextCommands);
        buttonResults=(Button)findViewById(R.id.buttonResults);
        toggleButton= (ToggleButton)findViewById(R.id.toggleButton);
        textViewResults= (TextView)findViewById(R.id.textViewResults);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonResults:
                String commands=editTextCommands.getText().toString();
                if(commands.contentEquals("left"))
                {
                 textViewResults.setGravity(Gravity.LEFT);
                    textViewResults.setText("left");
                }
                else if(commands.contentEquals("right"))
                {
                    textViewResults.setGravity(Gravity.RIGHT);
                    textViewResults.setText("right");
                }
                else if(commands.contentEquals("center"))
                {
                    textViewResults.setText("center");
                    textViewResults.setGravity(Gravity.CENTER);
                }
                else if(commands.contentEquals("wft"))
                {
                    textViewResults.setText("WFT");
                    Random r=new Random();
                    int rastgele=r.nextInt(3);
                    if(rastgele==0){
                        textViewResults.setGravity(Gravity.LEFT);
                        textViewResults.setTextColor(Color.rgb(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
                        textViewResults.setTextSize(r.nextInt(75));
                    }
                    else if(rastgele==1){
                        textViewResults.setGravity(Gravity.RIGHT);
                    }
                    else {
                        textViewResults.setGravity(Gravity.CENTER);
                    }

                }
                else if(commands.contentEquals("blue"))
                {
                    textViewResults.setTextColor(Color.BLUE);
                }
                else{
                    textViewResults.setText("You can type a command like:\nleft\nright\ncenter\nwft\nblue");
                    textViewResults.setGravity(Gravity.CENTER);
                    textViewResults.setTextColor(Color.RED);
                }


                break;
            case R.id.toggleButton:
                if(toggleButton.isChecked()){
                    toggleButton.setTextOn("normal mode");
                    editTextCommands.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                else{
                    toggleButton.setTextOff("password mode");
                    editTextCommands.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                }

                break;
            */
/*default:
                break;*//*

        }
    }
}
*/



/*

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;
import android.widget.TextView;
import android.view.View;

import java.util.Random;

public class P003TextPlay extends Activity implements View.OnClickListener {

    TextView textView;
    EditText editText;
    ToggleButton toggleButton;
    Button buttonResults;

    private void IcerikMtd() { //daha duzenli bir yapita kavusmak icin
        buttonResults= (Button)findViewById(R.id.buttonResults);
        toggleButton=(ToggleButton)findViewById(R.id.toggleButton); //final is abouth you can not change it
        editText= (EditText)findViewById(R.id.editTextCommands);
        textView= (TextView)findViewById(R.id.textViewResults);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.p003textplay); //manifest dosyasinda Activity leri refer etmeyi unutma
        IcerikMtd();  //alt+enter ile kolaylik var

        toggleButton.setOnClickListener(this); //bunlari refer etmeyi unutma
        buttonResults.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.toggleButton:
                if(toggleButton.isChecked()){
                    //InputType.... kullanabilmek bu olay tıpki enum ile ulasilir ve pekcok secenek var
                    editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD); //switch to passsword mode
                }
                else{
                    editText.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                break;
            case R.id.buttonResults:
                        String gelenVeri=editText.getText().toString().toLowerCase();
                        textView.setText(gelenVeri);
                        if(gelenVeri.contentEquals("left")){  //.contentEquals() geri donus degeri boolean!!!
                            textView.setGravity(Gravity.LEFT);
                        }
                        else if(gelenVeri.contentEquals("center")){
                            textView.setGravity(Gravity.CENTER);
                        }
                        else if(gelenVeri.contentEquals("right")){
                            textView.setGravity(Gravity.RIGHT);
                        }
                        else if(gelenVeri.contains("wft")){
                            Random crazy=new Random();
                            textView.setText("wft!!!");
                            textView.setTextSize(crazy.nextInt(75));
                            textView.setTextColor(Color.rgb(crazy.nextInt(255),crazy.nextInt(255),crazy.nextInt(255)));

                            switch(crazy.nextInt(3)){
                                case 0:
                                    textView.setGravity(Gravity.CENTER);  //.setGravity xml dosyasindaki .layout... kodunun karsiligi
                                    break;
                                case 1:
                                    textView.setGravity(Gravity.LEFT);
                                    break;
                                case 2:
                                    textView.setGravity(Gravity.RIGHT);
                                    break;
                            }
                        }
                        else if(gelenVeri.contentEquals("blue")){
                            textView.setTextColor(Color.BLUE);
                        }
                        else{  //html ozeliliklerini burada kullanabilirsin
                            textView.setText("You can type a command like:\nleft\nright\ncenter\nwft\nblue");
                            textView.setGravity(Gravity.CENTER);
                            textView.setTextColor(Color.RED);
                            //textView.setText(getString(R.string.hello_world)); -->"@string/string_name" seklinde olmuyor!
                        }
                break;
        }
    }
}

*/
/*
<>Resources class overview
        Class for accessing an application's resources.
        You can use this class to access your application's resources.
        You can generally acquire the Resources instance associated with your application with getResources().*//*


*/


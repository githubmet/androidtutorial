package com.example.kkldfkld.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class P007CreateUserFaceOnlyJavaCode extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout relativeLayout=new RelativeLayout(this);
        relativeLayout.setBackgroundColor(Color.parseColor("#006699"));

        Button button =new Button(this);
        button.setText("Hello World");
        button.setId(1234);


        RelativeLayout.LayoutParams buttonKonum=new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        buttonKonum.addRule(RelativeLayout.CENTER_HORIZONTAL, relativeLayout.getId());
        buttonKonum.addRule(RelativeLayout.CENTER_VERTICAL, relativeLayout.getId());
        button.setLayoutParams(buttonKonum);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(P007CreateUserFaceOnlyJavaCode.this, "I wanna run away with you :)", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        button.setOnLongClickListener(
                new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        Toast.makeText(P007CreateUserFaceOnlyJavaCode.this, "I don't wanna let you down!", Toast.LENGTH_LONG).show();
                        return true;
                    }
                }
        );


        Button button2=new Button(this);
        button2.setText("Hello world2");

        RelativeLayout.LayoutParams button2Konum =new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        button2Konum.addRule(RelativeLayout.CENTER_HORIZONTAL,relativeLayout.getId());
        button2Konum.addRule(RelativeLayout.ABOVE, button.getId());
        button2.setLayoutParams(button2Konum);

        TextView textView=new TextView(this);
        textView.setText("Aloha");

        RelativeLayout.LayoutParams textViewKonum=new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        textViewKonum.addRule(RelativeLayout.CENTER_HORIZONTAL,relativeLayout.getId());
        textViewKonum.addRule(RelativeLayout.BELOW,button.getId());
        textView.setLayoutParams(textViewKonum);


        relativeLayout.addView(button);
        relativeLayout.addView(button2);
        relativeLayout.addView(textView);

        setContentView(relativeLayout);
    }
}





/*

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.graphics.Color;
import android.widget.TextView;


public class P007CreateUserFaceOnlyJavaCode extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.) degisti
        RelativeLayout relativeLayout=new RelativeLayout(this);
        relativeLayout.setBackgroundColor(Color.parseColor("#009966"));

        Button button=new Button(this);
        button.setText(R.string.hello_world);
        button.setTextColor(Color.BLUE);
        button.setId(15);


        RelativeLayout.LayoutParams buttonKonum=new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        buttonKonum.addRule(RelativeLayout.CENTER_VERTICAL);
        buttonKonum.addRule(RelativeLayout.CENTER_HORIZONTAL);

        Button button2=new Button(this);
        button2.setText(R.string.hello_world2);
        button2.setTextColor(Color.GREEN);

        RelativeLayout.LayoutParams buttonKonum2=new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        buttonKonum2.addRule(RelativeLayout.ABOVE, button.getId());
        buttonKonum2.addRule(RelativeLayout.CENTER_HORIZONTAL);

        final TextView textView =new TextView(this);  //final attribute ile sub item olarak kullanilmasinde hatayi kaldirir
        textView.setTextColor(Color.CYAN);
        textView.setId(16);
        textView.setText("Merhaba");

        RelativeLayout.LayoutParams textViewKonum=new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        textViewKonum.addRule(RelativeLayout.CENTER_HORIZONTAL);
        textViewKonum.addRule(RelativeLayout.BELOW,button.getId());

        relativeLayout.addView(button, buttonKonum);
        relativeLayout.addView(button2, buttonKonum2);
        relativeLayout.addView(textView,textViewKonum);
        setContentView(relativeLayout);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textView.setText(R.string.wanna_text);
                        textView.setTextColor(Color.GREEN);
                    }
                }
        );

        button.setOnLongClickListener(
                new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        textView.setText(R.string.dontwanna_text);
                        textView.setTextColor(Color.RED);

                        return true;    //bunu ben hallettim aslinda bir pillar Java nin
                    }
                }
        );

    }
}

//RelativeLayout relativeLayout=new RelativeLayout(this); //1.adim
//TextView textView=new TextView(this);                   //2.adim
//relativeLayout.addView(textView, textViewDetails);      //3.adim
//setContentView(relativeLayout);                         //4.adim

//Tum widgetlar birer View dir. Gecerli RelativeLayout atamasini unutma!


*/

























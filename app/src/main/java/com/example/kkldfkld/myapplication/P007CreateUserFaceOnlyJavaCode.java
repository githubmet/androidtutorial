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

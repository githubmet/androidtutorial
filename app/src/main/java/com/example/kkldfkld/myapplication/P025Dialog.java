package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.view.View;

import android.app.Dialog;
import android.widget.TextView;

public class P025Dialog extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout relativeLayout=new RelativeLayout(this);

        Button button=new Button(this);
        button.setText("Dialog");

        RelativeLayout.LayoutParams buttonKonum=new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        buttonKonum.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonKonum.addRule(RelativeLayout.CENTER_VERTICAL);
        button.setLayoutParams(buttonKonum);

        relativeLayout.addView(button);
        setContentView(relativeLayout);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Dialog dialog=new Dialog(P025Dialog.this);
                        TextView textView=new TextView(P025Dialog.this);
                        textView.setText("Welcome to Dialog Land");
                        dialog.setContentView(textView);
                        dialog.setTitle("Infomation box");
                        dialog.show();
                    }
                }
        );
    }
}

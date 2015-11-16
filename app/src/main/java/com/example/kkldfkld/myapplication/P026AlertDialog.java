package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.widget.Toast;

import android.app.AlertDialog;

public class P026AlertDialog extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout relativeLayout=new RelativeLayout(this);
        Button button=new Button(this);
        button.setText("Show() AlertDialog");

        RelativeLayout.LayoutParams buttonKonum=new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        buttonKonum.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonKonum.addRule(RelativeLayout.CENTER_VERTICAL);
        button.setLayoutParams(buttonKonum);

        relativeLayout.addView(button);
        setContentView(relativeLayout);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        AlertDialog alertDialog= new AlertDialog.Builder(P026AlertDialog.this).create();
        alertDialog.setTitle("Welcome to AlertDialog landscape");
        alertDialog.setMessage("Please, select your message Box");

        alertDialog.setButton("Message Box 1", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(P026AlertDialog.this, "Message One", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.setButton2("Message Box 2", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(P026AlertDialog.this, "Message Two", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.setButton3("Message Box 3", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(P026AlertDialog.this, "Message Three", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.show();
    }
}

/*
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.RelativeLayout;
import android.app.AlertDialog;
import android.widget.Toast;

public class P026AlertDialog extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout relativeLayout=new RelativeLayout(this);
        Button button=new Button(this);
        button.setText("Show() AlertDialog");

        RelativeLayout.LayoutParams buttonKonum=new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        buttonKonum.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonKonum.addRule(RelativeLayout.CENTER_VERTICAL);
        button.setLayoutParams(buttonKonum);

        relativeLayout.addView(button);
        setContentView(relativeLayout);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        AlertDialog alertDialog=new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Options...");
        alertDialog.setMessage("Please, choose an option");
        alertDialog.setButton("Option 1", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(P026AlertDialog.this, "Option 1 is selected!", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.setButton2("Option 2", new DialogInterface.OnClickListener() {   //dikkat cok ilginc .setButton2 ayri bir Button olarak goruyor
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(P026AlertDialog.this, "Option 2 is selected!", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.setButton3("Option 3", new DialogInterface.OnClickListener() {   //dikkat cok ilginc .setButton3 ayri bir Button olarak goruyor
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(P026AlertDialog.this, "Option 3 is selected!", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.show();
    }
}
*/

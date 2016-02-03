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
        AlertDialog.Builder builder=new AlertDialog.Builder(P026AlertDialog.this);
        builder.setTitle("Welcome to AlertDialog landscape");
        builder.setMessage("Are you ok?");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(P026AlertDialog.this,"Good for you",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(P026AlertDialog.this,"Bad for you",Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
}

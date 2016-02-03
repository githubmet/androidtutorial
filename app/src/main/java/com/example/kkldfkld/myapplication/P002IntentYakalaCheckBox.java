package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.content.Intent;

public class P002IntentYakalaCheckBox extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout relativeLayout=new RelativeLayout(this);
        TextView textView=new TextView(this);
        RelativeLayout.LayoutParams textViewKonum=new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        textViewKonum.addRule(RelativeLayout.CENTER_HORIZONTAL);
        textViewKonum.addRule(RelativeLayout.CENTER_VERTICAL);
        textView.setLayoutParams(textViewKonum);

        Intent intent=getIntent();
        Boolean gelenVeri=intent.getBooleanExtra(P002Intent.KEY_BOOLEAN_VERI, false);  //bu sekilde de olur.
        //Bundle bundle= intent.getExtras();
        //Boolean gelenVeri= bundle.getBoolean(P002Intent.KEY_BOOLEAN_VERI,false);
        textView.setText(gelenVeri.toString().toUpperCase());

        relativeLayout.addView(textView);
        setContentView(relativeLayout);
    }
}

package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class P002IntentYakala extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout relativeLayout=new RelativeLayout(this);
        relativeLayout.setBackgroundColor(Color.CYAN);
        TextView textView=new TextView(this);

        Intent intent= getIntent();
        Bundle bundle= intent.getExtras();
        String veri= bundle.getString("bohca");
        textView.setText(veri);

        RelativeLayout.LayoutParams textViewKonum= new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        textViewKonum.addRule(RelativeLayout.CENTER_HORIZONTAL,relativeLayout.getId());
        textViewKonum.addRule(RelativeLayout.CENTER_VERTICAL,relativeLayout.getId());
        textView.setLayoutParams(textViewKonum);
        
        relativeLayout.addView(textView);
        setContentView(relativeLayout);
    }
}
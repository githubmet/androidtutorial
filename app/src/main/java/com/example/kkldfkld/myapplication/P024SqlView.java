package com.example.kkldfkld.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class P024SqlView extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p024sqlview);

        TextView textViewSqlInfoP024=(TextView)findViewById(R.id.textViewSqlInfoP024);
        P024HotOrNot info=new P024HotOrNot(this);

        info.open();
        String data=info.getData();
        info.close();
        textViewSqlInfoP024.setText(data);


    }
}

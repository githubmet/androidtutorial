package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.os.Bundle;

public class P018BCanvas extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        P018BCanvasAraclari p018BCanvasAraclari=new P018BCanvasAraclari(this);
        setContentView(p018BCanvasAraclari);
    }
}

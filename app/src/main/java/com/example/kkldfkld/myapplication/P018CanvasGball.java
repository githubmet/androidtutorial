package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.os.Bundle;

public class P018CanvasGball extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        P018Olaylar ourView=new P018Olaylar(this);
        setContentView(ourView);  //dikkat hic bir yerde layout kullanmadik
    }
}

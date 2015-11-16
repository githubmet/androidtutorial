package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.os.Bundle;

public class P018CanvasGball extends Activity {

    P018Olaylar ourView;  //dikkat class isimleri buyuk harfle baslar
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ourView=new P018Olaylar(this);
        setContentView(ourView);  //dikkat hic bir yerde layout kullanmadik
    }
}

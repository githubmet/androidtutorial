package com.example.kkldfkld.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View;

public class P017DrawableIcon extends Activity implements View.OnClickListener  {
    ImageButton imageButtonP017;
    ImageButton imageButton2P017;
    TextView textViewP017;
    private static int sayi=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p017drawableicon);


        IngredientsMtd();

        imageButtonP017.setOnClickListener(this);
        imageButton2P017.setOnClickListener(this);
    }

    private void IngredientsMtd() {
        imageButtonP017= (ImageButton)findViewById(R.id.imageButtonP017);
        imageButton2P017= (ImageButton)findViewById(R.id.imageButton2P017);
        textViewP017= (TextView)findViewById(R.id.textViewP017);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.imageButtonP017:
                sayi++;
                break;
            case R.id.imageButton2P017:
                sayi--;
                break;
        }

        textViewP017.setText(String.valueOf(sayi));
    }
}

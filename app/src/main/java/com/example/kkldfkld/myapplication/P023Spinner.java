package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class P023Spinner extends Activity implements AdapterView.OnItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout relativeLayout=new RelativeLayout(this);
        relativeLayout.setBackgroundColor(Color.parseColor("#b0c4de"));

        String[] araclar=getResources().getStringArray(R.array.value);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,araclar);

        Spinner spinner=new Spinner(this);
        spinner.setAdapter(arrayAdapter);

        RelativeLayout.LayoutParams spinnerKonum=new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        spinnerKonum.addRule(RelativeLayout.CENTER_VERTICAL,relativeLayout.getId());
        spinnerKonum.addRule(RelativeLayout.CENTER_HORIZONTAL,relativeLayout.getId());

        spinner.setLayoutParams(spinnerKonum);
        relativeLayout.addView(spinner);
        setContentView(relativeLayout);

        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getItemAtPosition(position).toString()){
            case "Bisiklet":
                Toast.makeText(this,"A bike has two tyre",Toast.LENGTH_SHORT).show();
                break;
            case "El Arabasi":
                Toast.makeText(this,"El arabasi has three tyre",Toast.LENGTH_SHORT).show();
                break;
            case "Otomobil":
                Toast.makeText(this,"A car has four tyre",Toast.LENGTH_SHORT).show();
                break;
            case "Kamyon":
                Toast.makeText(this,"A truck ten two tyre",Toast.LENGTH_SHORT).show();
                break;
            case "Tir":
                Toast.makeText(this,"A Tir Twenty-two tyre",Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this,"Yaya is not a transport veichles",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

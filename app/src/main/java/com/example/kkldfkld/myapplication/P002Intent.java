package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;

public class P002Intent extends Activity {
    public static final String KEY_VERI="com.example.kkldfkld.myapplication.VERI";
    public static final String KEY_BOOLEAN_VERI="com.example.kkldfkld.myapplication.BOOLEAN_VERI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p002intent);
    }

    public void onClickP002Mtd(View view) {
        EditText editTextP002=(EditText)findViewById(R.id.editTextP002);
        String veri=editTextP002.getText().toString();
        Intent intent =new Intent(this,P002IntentYakala.class);
        intent.putExtra(KEY_VERI,veri);
        startActivity(intent);
    }
    public void onClickP002Mtd2(View view){

        CheckBox checkBoxP002=(CheckBox)findViewById(R.id.checkBoxP002);
        boolean deger=checkBoxP002.isChecked();
        try {
            Class className=Class.forName("com.example.kkldfkld.myapplication.P002IntentYakalaCheckBox");
            Intent intent =new Intent(this,className);
            intent.putExtra(KEY_BOOLEAN_VERI,deger);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

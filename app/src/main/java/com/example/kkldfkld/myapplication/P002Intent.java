package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class P002Intent extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p002intent);
    }

    public void onClickP002Mtd(View view) {
        Intent intent =new Intent(P002Intent.this,P002IntentYakala.class);
        EditText editTextP002=(EditText)findViewById(R.id.editTextP002);
        intent.putExtra("bohca",editTextP002.getText().toString());

        startActivity(intent);
    }

    public void onClickP002Mtd2(View view) {
        try {
            Class className= Class.forName("com.example.kkldfkld.myapplication.P002IntentYakalaCheckBox");
            Intent intent=new Intent(P002Intent.this,className);
            CheckBox checkBoxP002=(CheckBox)findViewById(R.id.checkBoxP002);
            intent.putExtra("boolean",checkBoxP002.isChecked());

            startActivity(intent);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

/*

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.CheckBox;

public class P002Intent extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p002intent);

    }
    public void onClickP002Mtd(View view){

        Intent intent =new Intent(P002Intent.this,P002IntentYakala.class);
        EditText editTextP002=(EditText)findViewById(R.id.editTextP002);
        intent.putExtra("bohca", editTextP002.getText().toString());

        startActivity(intent);  //parametreler icersinde Bundle olarak veri gonderme parametreside var

    }
    public void onClickP002Mtd2(View view) {

        try {
            Class tamAd = Class.forName("com.example.kkldfkld.myapplication.P002IntentYakalaCheckBox"); //genede Manifests dosyasinda belirtmen gerekiyor
            CheckBox checkBox=(CheckBox)findViewById(R.id.checkBoxP002);
            Intent intent=new Intent(this,tamAd);
            intent.putExtra("boolean",checkBox.isChecked());
            startActivity(intent);
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }

    }

}

*/
/*<>Context class overview
        Interface to global information abouth an application envionment.
        This is an abstract class whose implementation is provided by the Android system.
        It allows access to application-specific resources and classes, as well as up-calls
        for application-level operations such as launching activities, broadcasting and recieving intents, etc.*/





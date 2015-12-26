package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;

import android.view.View;
import android.content.Intent;
import android.widget.EditText;

import android.content.SharedPreferences;

import android.preference.PreferenceManager;

public class P032PreferencesNot extends Activity implements View.OnClickListener {

    static final int REQUESTCODE=2514;
    EditText editTextNotesP032;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p032preferencesnot);

        Button buttonSettingsP032= (Button)findViewById(R.id.btnSettings);
        buttonSettingsP032.setOnClickListener(this);

        editTextNotesP032=(EditText)findViewById(R.id.notesEditText);

        if(savedInstanceState != null){
           String anlikVeri= savedInstanceState.getString("AnlikKapat");
            editTextNotesP032.setText(anlikVeri);
        }

        SharedPreferences sharedPreferences=getSharedPreferences("KapatIste",MODE_PRIVATE);
        String sharedString= sharedPreferences.getString("notlar","yaBosSa");
        if(sharedString != "yaBosSa"){
            editTextNotesP032.setText(sharedString);
        }
        updateEditTextProperty();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("AnlikKapat",editTextNotesP032.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStop() {
        SharedPreferences sharedPreferences=getSharedPreferences("KapatIste",MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString("notlar",editTextNotesP032.getText().toString());

        editor.commit();

        super.onStop();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.btnSettings){
            Intent intent=new Intent(P032PreferencesNot.this,P032SettingActivity.class);
            startActivityForResult(intent,REQUESTCODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUESTCODE){
            updateEditTextProperty();
        }
    }

    private void updateEditTextProperty() {

        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        boolean boldOrNot= sharedPreferences.getBoolean("checkBoxPreferenceBold2",false);
        if(boldOrNot){
            editTextNotesP032.setTypeface(null, Typeface.BOLD);
        }
        else{
            editTextNotesP032.setTypeface(null,Typeface.NORMAL);
        }

        String textSize=sharedPreferences.getString("listPreferenceTextSize2","16");

        float textSizeFloat=Float.parseFloat(textSize);
        editTextNotesP032.setTextSize(textSizeFloat);

     }
}

// SharedPreferences allow you to save data even if the user kills the app
// MODE_PRIVATE : Preferences shared only by your app
// MODE_WORLD_READABLE : All apps can read
// MODE_WORLD_WRITABLE : All apps can write
// edit() allows us to enter key vale pairs



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

    private static final int REQUESTCODE=123;
    EditText editTextNotesP032;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p032preferencesnot);

        Button buttonSettingsP032= (Button)findViewById(R.id.btnSettings);
        buttonSettingsP032.setOnClickListener(this);

        editTextNotesP032=(EditText)findViewById(R.id.notesEditText);
        updateEditTextProperty();

        if(savedInstanceState != null){
           String anlikVeri= savedInstanceState.getString("NOTES2");
            editTextNotesP032.setText(anlikVeri);
        }

        SharedPreferences sharedPreferences=getSharedPreferences("NOTES",MODE_PRIVATE);
        String sharedString= sharedPreferences.getString("notlar","empty");
        if(sharedString != "empty"){
            editTextNotesP032.setText(sharedString);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("NOTES2",editTextNotesP032.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStop() {
        SharedPreferences sharedPreferences=getSharedPreferences("NOTES",MODE_PRIVATE);
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










/*
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import android.preference.PreferenceManager;

public class P032PreferencesNot extends Activity {

    private static final int REQUESTCODE=12;
    EditText editTextNoteP032;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p032preferencesnot);

        editTextNoteP032= (EditText)findViewById(R.id.notesEditText);


        if(savedInstanceState !=null){
            String notes= savedInstanceState.getString("NOTES");
            editTextNoteP032.setText(notes);
        }

        SharedPreferences sharedPreferences= getSharedPreferences("NOTES",MODE_PRIVATE);
        String kontrol= sharedPreferences.getString("note","EMPTY");
        if(kontrol != "EMPTY"){
            editTextNoteP032.setText(kontrol);
        }


        Button buttonSettingsP032= (Button)findViewById(R.id.btnSettings);
        buttonSettingsP032.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(P032PreferencesNot.this,P032SettingActivity.class);

                        startActivityForResult(intent,REQUESTCODE);
                    }
                }
        );

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("NOTES", editTextNoteP032.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode==REQUESTCODE){
            updateEditTextNoteMtd();
        }
        super.onActivityResult(requestCode, resultCode, data);

    }

    private void updateEditTextNoteMtd() {
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        boolean boldKontrol= sharedPreferences.getBoolean("checkBoxPreferenceTextBold", false);
        if(boldKontrol){
            editTextNoteP032.setTypeface(null,Typeface.BOLD);
        }
        else{
            editTextNoteP032.setTypeface(null,Typeface.NORMAL);
        }
        String textSize= sharedPreferences.getString("listPreferenceTextSize","16");
        float sizeFloat=Float.parseFloat(textSize);
        editTextNoteP032.setTextSize(sizeFloat);
    }

    @Override
    protected void onStop() {
        SharedPreferences sharedPreferences=getSharedPreferences("NOTES",MODE_PRIVATE);
        Editor editor = sharedPreferences.edit();
        editor.putString("note",editTextNoteP032.getText().toString());

        editor.commit();
        super.onStop();
    }
}



*/




/*

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class P032PreferencesNot extends Activity {

    EditText notesEditText;
    Button btnSettings;
    private static final int SETTINGS_INFO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p032preferencesnot);

        notesEditText = (EditText) findViewById(R.id.notesEditText);
        // 1. Make sure there is data to retrieve
        if(savedInstanceState != null){  //key value ciftidir
            String notes = savedInstanceState.getString("NOTES");
            notesEditText.setText(notes);
        }
        // 2. Retrieves the String stored in shared preferences or "EMPTY" if nothing
        String sPNotes = getPreferences(Context.MODE_PRIVATE).getString("NOTES", "EMPTY");
        if(!sPNotes.equals("EMPTY")){
            notesEditText.setText(sPNotes);
        }

        btnSettings = (Button) findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPreferences = new Intent(getApplicationContext(),
                        P032SettingActivity.class);
                startActivityForResult(intentPreferences, SETTINGS_INFO);  //sebep kapatildiginda bir veri alacagim// 3. Start the activity and then pass results to onActivityResult
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {  // if the user kills the app or restarts the device. Kontrolsuz kapatilma durumlarinda
        outState.putString("NOTES", // Save the value in the EditText using the key NOTES
                notesEditText.getText().toString());
        super.onSaveInstanceState(outState);
    }
    // 2. Will save key value pairs to SharedPreferences
    private void saveSettings(){
        SharedPreferences.Editor editor = getPreferences(Context.MODE_PRIVATE).edit();
        editor.putString("NOTES", notesEditText.getText().toString());
        editor.commit();
    }

    @Override
    protected void onStop() { // 2. Called if the app is forced to close
        saveSettings();
        super.onStop();
    }
    // 3. Called after the settings intent closes
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        // 3. Check that the intent with the id SETTINGS_INFO called here
        if(requestCode == SETTINGS_INFO){
            updateNoteText();
        }
    }

    private void updateNoteText(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if(sharedPreferences.getBoolean("pref_text_bold", false)){
            notesEditText.setTypeface(null, Typeface.BOLD_ITALIC); // Set the text to bold
        } else {
            notesEditText.setTypeface(null, Typeface.NORMAL);
        }

        String textSizeStr = sharedPreferences.getString("pref_text_size", "16");
        float textSizeFloat = Float.parseFloat(textSizeStr);
        notesEditText.setTextSize(textSizeFloat); // Set the text size for the EditText box
    }
}
// SharedPreferences allow you to save data even if the user kills the app
// MODE_PRIVATE : Preferences shared only by your app
// MODE_WORLD_READABLE : All apps can read
// MODE_WORLD_WRITABLE : All apps can write
// edit() allows us to enter key vale pairs
*/



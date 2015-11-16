package com.example.kkldfkld.myapplication;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class P012SharedPreferences extends Activity {

    EditText editTextName;
    EditText editTextSurname;
    TextView textViewName;
    TextView textViewSurname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p012sharedpreferences);

        editTextName=(EditText)findViewById(R.id.editText_name);
        editTextSurname=(EditText)findViewById(R.id.editText_surname);
        textViewName= (TextView)findViewById(R.id.textView_name);
        textViewSurname= (TextView)findViewById(R.id.textView_surname);

    }

    public void onClickSave(View view) {
        SharedPreferences sharedPreferences= getSharedPreferences("GetSharePref",MODE_PRIVATE);
         SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString("name",editTextName.getText().toString().toUpperCase());
        editor.putString("surname",editTextSurname.getText().toString().toLowerCase());
        editor.apply();

    }

    public void onClickGet(View view) {
        SharedPreferences sharedPreferences= getSharedPreferences("GetSharePref",MODE_PRIVATE);
        String name= sharedPreferences.getString("name","null2");
        String surname=sharedPreferences.getString("surname","null2");

        textViewName.setText(name);
        textViewSurname.setText(surname);
    }
}





/*
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.widget.Toast;


public class P012SharedPreferences extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p012sharedpreferences);
    }

    public void onClickSave(View view){
        EditText editText_Name= (EditText)findViewById(R.id.editText_name);
        EditText editText_Surname= (EditText)findViewById(R.id.editText_surname);
                                                                             //Context.MODE_PRIVATE yerine '0' da yazsan olur. Enum gibi birsey
        SharedPreferences sharedPreferences= getSharedPreferences("fileName", Context.MODE_PRIVATE);
        //SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext()); ile karistirma
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("name",editText_Name.getText().toString().toUpperCase());
        editor.putString("surname", editText_Surname.getText().toString().toUpperCase());

        editor.apply();  //editor.commit(); bu da kullanilabilir fakat tabikide bir farki vardir
        Toast.makeText(this,"Saved succesfully",Toast.LENGTH_SHORT).show();

        //fileName static genel degisken olarak vermen "raw" olarak yukarida kullanmandan iyidir
    }

    public void onClickGet(View view){

        TextView textView_name= (TextView)findViewById(R.id.textView_name);
        TextView textView_surname= (TextView)findViewById(R.id.textView_surname);

        SharedPreferences sharedPreferences=getSharedPreferences("fileName",Context.MODE_PRIVATE);
        String name= sharedPreferences.getString("name","Couldn't Load Data");
        String surname=sharedPreferences.getString("surname","Couldn't Load Data");

        textView_name.setText(name);
        textView_surname.setText(surname);


    }
}

       >SharedPreferences is used by apps to save data in name-vaues pairs, like a Bundle

        >Data is stored in XML file in the directory data/data/<package name>/shared-prefs folder

        >Store data such  as username, password, theme settings, other application settings

        >SharedPreferences only allows you to save primitive data types(that is, floats,
        longs, ints and strings)

        MODE_PRIVATE:Only your app can access the file
        MODE_WORLD_READABLE:All apps can read the file...

        To store data
        1-Get a references to the SharedPreferences object
        a-For a single file, call getPreferences(int mode)
        b-For several files, call getSharedPreferences(String name, int mode)
        2-Call the editor
        3-Use the editor to add the data with a key
        4-Commit editor changes

        To retrieve data
        1-Het a references to the SharedPreferences object
        a-For a single file, call getPreferences(int mode)
        b-For several files, call getSharedPreferences(String name, int mode)
        2-Use the key provided earlier to get data
        3-Supply default values if the data is not found
*/





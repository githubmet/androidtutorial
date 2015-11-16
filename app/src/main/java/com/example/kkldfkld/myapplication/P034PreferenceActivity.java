package com.example.kkldfkld.myapplication;


import android.os.Bundle;
import android.preference.PreferenceActivity;

public class P034PreferenceActivity extends PreferenceActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.p034preferenceactivity);
    }
}




/*
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class P034PreferenceActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.p034preferenceactivity);  //ustunun cizilmesi sadece manifeste belirttigin min vesion modu uymadigi icin hata
    }
}
*/

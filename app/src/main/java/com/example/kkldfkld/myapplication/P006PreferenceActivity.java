package com.example.kkldfkld.myapplication;


import android.os.Bundle;
import android.preference.PreferenceActivity;

public class P006PreferenceActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.p006preferenceactivity);  //api 11 dikkat xml file biz olusturduk
    }
}

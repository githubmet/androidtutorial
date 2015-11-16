package com.example.kkldfkld.myapplication;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class P032SettingActivity extends PreferenceActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.p32settingactivity2);
    }
}



/*

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class P032SettingActivity extends PreferenceActivity{
    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.p032preferences2);
    }
}
*/

/*
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class P032SettingActivity extends PreferenceActivity {
   @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       addPreferencesFromResource(R.xml.p032preferences);
    }
}
*/

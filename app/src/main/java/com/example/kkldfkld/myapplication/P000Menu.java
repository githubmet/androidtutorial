package com.example.kkldfkld.myapplication;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;

public class P000Menu extends ListActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] activityNames=getResources().getStringArray(R.array.activity_names);
        ArrayAdapter arrayAdapter =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,activityNames);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        setListAdapter(arrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String activityName="com.example.kkldfkld.myapplication."+l.getItemAtPosition(position);
        try {
            Class className=Class.forName(activityName);
            Intent intent =new Intent(this,className);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

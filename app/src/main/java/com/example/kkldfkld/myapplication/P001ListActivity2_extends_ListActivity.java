package com.example.kkldfkld.myapplication;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class P001ListActivity2_extends_ListActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String activityNames[]=getResources().getStringArray(R.array.activity_names2);
        ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,activityNames);
        setListAdapter(listAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(this,l.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
    }
}

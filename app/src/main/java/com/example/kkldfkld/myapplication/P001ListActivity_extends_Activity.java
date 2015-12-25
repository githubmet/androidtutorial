package com.example.kkldfkld.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class P001ListActivity_extends_Activity extends Activity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p001listactivity);

        ListView listViewP001=(ListView)findViewById(R.id.listViewP001);
        String[] activityNames=getResources().getStringArray(R.array.activity_names2);
        ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,activityNames);

        listViewP001.setAdapter(listAdapter);

        listViewP001.setOnItemClickListener(this);
        listViewP001.setOnItemLongClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId()==R.id.listViewP001) {
            Toast.makeText(P001ListActivity_extends_Activity.this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId()==R.id.listViewP001) {
            Toast.makeText(P001ListActivity_extends_Activity.this, parent.getItemAtPosition(position).toString().toUpperCase(), Toast.LENGTH_SHORT).show();
            return true;
        }
        else{
            return true;
        }
    }
}

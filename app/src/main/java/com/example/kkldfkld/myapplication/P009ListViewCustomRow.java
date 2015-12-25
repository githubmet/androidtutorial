package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class P009ListViewCustomRow extends Activity implements AdapterView.OnItemClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p009listviewcustomrow);

        ListView listViewP009=(ListView)findViewById(R.id.listViewP009);
        String teamsNames[]=getResources().getStringArray(R.array.teams_names_p009);

        ListAdapter listAdapter=new P009ReturnArrayAdapterCustomRow(this,teamsNames);
        listViewP009.setAdapter(listAdapter);

        listViewP009.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(P009ListViewCustomRow.this, String.valueOf(parent.getItemIdAtPosition(position)), Toast.LENGTH_SHORT).show();
    }
}

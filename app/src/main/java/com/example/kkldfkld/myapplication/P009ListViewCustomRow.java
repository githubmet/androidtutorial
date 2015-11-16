package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class P009ListViewCustomRow extends Activity implements AdapterView.OnItemClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p009listviewcustomrow);

        String[] teams={"Alfreton","Braintree","Cheltenham","Coventry","Crawley","Fleetwood","Grimsby","Huddersfield","Hull","Manchester"};
    //    ListAdapter listAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,teams);
      ListAdapter listAdapter=new P009ReturnArrayAdapterCustomRow(this,teams);
        ListView listView= (ListView)findViewById(R.id.listViewP009);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(P009ListViewCustomRow.this, String.valueOf(parent.getItemAtPosition(position)), Toast.LENGTH_SHORT).show();
    }
}



/*

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class P009ListViewCustomRow extends Activity implements ListView.OnItemClickListener {

    private String[] teams={"Alfreton","Braintree","Cheltenham","Coventry","Crawley","Fleetwood","Grimsby","Huddersfield","Hull","Manchester"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.p009listviewcustomrow);


        ListAdapter listAdapter=new P009ReturnArrayAdapterCustomRow(P009ListViewCustomRow.this,teams);
        ListView listViewP009=(ListView)findViewById(R.id.listViewP009);
        listViewP009.setAdapter(listAdapter);

        listViewP009.setOnItemClickListener(this); //dikkat otomat olma think it deeply
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(P009ListViewCustomRow.this,parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
    }
}
//oglum kulak ve kafan var neden cok dusunuyorsun!!!
*/



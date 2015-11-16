package com.example.kkldfkld.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class P001ListActivity_extends_Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p001listactivity);

        String[] activityNames = {"activity 1", "activity 2", "activity 3", "activity 4",
                "activity 5", "activity 6", "activity 7", "activity 8", "activity 9"};
        ListView listView = (ListView) findViewById(R.id.listViewP001);

        ListAdapter listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, activityNames);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(P001ListActivity_extends_Activity.this,parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
                    }
                }
        );
        listView.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(P001ListActivity_extends_Activity.this,"Anormal "+parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
                        return true;
                    }
                }
        );

    }
}


/*

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ListAdapter;
import android.widget.Toast;

public class P001ListActivity_extends_Activity extends Activity implements AdapterView.OnItemClickListener,
AdapterView.OnItemLongClickListener {  //extends ListActivity olmadan da yapilabilir

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p001listactivity);

        final String activityName[]={"Activity","Activity2","Activity3","Activity4","Activity5","Activity6","Activity7","Activity8","Activity9"};
        ListAdapter listAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,activityName);

        ListView listViewP001= (ListView)findViewById(R.id.listViewP001);
        listViewP001.setAdapter(listAdapter);

        listViewP001.setOnItemClickListener(this);
//                new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                                                       //activityName(position) dan iyidir
//                        Toast.makeText(P001ListActivity_extends_Activity.this,listViewP001.getItemAtPosition(position)+" .setOnItemClickListener ile yakalandi!",Toast.LENGTH_LONG).show();  //ne gerek var dolanmaya
//                    }
//                }
//        );
        listViewP001.setOnItemLongClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
         Toast.makeText(P001ListActivity_extends_Activity.this,parent.getItemAtPosition(position)+" .setOnItemClickListener ile yakalandi!",Toast.LENGTH_LONG).show();  //ne gerek var dolanmaya
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        //html kod bilginide kullanabilirsin tabi hepsini yemiyor
        Toast.makeText(this,"<b>.setOnItemLongClickListener ile tetiklendi!.</b>\nLutfen uzun sureli click halinde durmayalim",Toast.LENGTH_SHORT).show();
        return true;
    }
}
*/

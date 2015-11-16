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

        String activityNames[]={"Activity 1","Activity 2","Activity 3","Activity 4",
                "Activity 5","Activity 6","Activity 7","Activity 8","Activity 9"};

        ListAdapter listAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,activityNames);
        setListAdapter(listAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(this,l.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();

    }
}



/*
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class P001ListActivity2_extends_ListActivity extends ListActivity {
    private String activityName[]={"activity","activity2","activity3","activity4","activity5","activity6","activity8","activity9"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //android temel kalip elamanlarina direk olarak ulasilamaz. Bunun icin    android.R.layout.simple_list_item_1
        ListAdapter listAdapter=new ArrayAdapter<String>(P001ListActivity2_extends_ListActivity.this,android.R.layout.simple_list_item_1,activityName);

        setListAdapter(listAdapter); //dikkat setContentView() YOK
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) { //dikkat bu method extends ListActivity yapildiginda gelir!!!
        super.onListItemClick(l, v, position, id);
                                                                    //activityName(position) dan daha iyi
        Toast.makeText(P001ListActivity2_extends_ListActivity.this,l.getItemAtPosition(position)+" onListItemClick(ListView l, View v, int position, long id) Method ile yakalandi" ,Toast.LENGTH_LONG).show();
    }
}
//diyelim ki startActivity ile isim dizisinden aldigin String veri ile yeni Activity ler acacak isen try-catch yapman gerekir.. Program risk almaz


*//*
<>ListAdapter class overview
        Extended Adapter that is the bridge between a ListView and the data that backs the list.
        Fraquently that data comes from a Cursor, but that is not required.
        The ListView can display any data provided that is wrapped in a ListAdapter.*/

package com.example.kkldfkld.myapplication;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class P000Menu extends ListActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String activityNames[]={"P001ListActivity_extends_Activity","P001ListActivity2_extends_ListActivity","P002Intent","P003TextPlay",
                "P004SetInputType","P005NormalMenuItem","P005PreferenceGetInfo","P006CoolMenuItem","P006PreferencesGetInfo","P007CreateUserFaceOnlyJavaCode",
                "P007CreateUserFaceOnlyJavaCode2", "P008GridLayout_Implements_View_OnClickListener","P009ListViewCustomRow","P010GestureDetectorCompat" ,
                "P011NotificationCompatBuilder","P012SharedPreferences","P013DrawableBitmapLayerDrawable", "P014EmailTasarim","P015RadioGroup","P016StyleTheme",
                "P017DrawableIcon","P018CanvasGball","P018BCanvas","P019WebView","P020TabHostTabSpec","P021FileOutputStream","P022AsyncTaskClass","P023Spinner","P024SqlLite",
                "P025Dialog","P026AlertDialog","P027SQLiteDatabaseClass","P028SharedPreferences","P029InternalStorage","P030TeaspoonConversion","P031IntentServices",
                "P032PreferencesNot","P033VideoView","P034GetDefaultSharedPreferences","P035Bitmap"};
        ListAdapter listAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,activityNames);
        setListAdapter(listAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        try {
            Class className=Class.forName("com.example.kkldfkld.myapplication."+l.getItemAtPosition(position));
            Intent intent=new Intent(this,className);
            startActivity(intent);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}






/*import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.content.Intent;
import android.widget.Toast;

public class P000Menu extends ListActivity {
    private String ActivitySName[]={"P001ListActivity_extends_Activity","P001ListActivity2_extends_ListActivity","P002Intent","P003TextPlay",
            "P004SetInputType","P005NormalMenuItem","P006CoolMenuItem","P006PreferencesGetInfo","P007CreateUserFaceOnlyJavaCode",
            "P007CreateUserFaceOnlyJavaCode2", "P008GridLayout_Implements_View_OnClickListener","P009ListViewCustomRow","P010GestureDetectorCompat" ,
            "P011NotificationCompatBuilder","P012SharedPreferences","P013DrawableBitmapLayerDrawable", "P014EmailTasarim","P015RadioGroup","P016StyleTheme",
            "P017DrawableIcon","P018CanvasGball","P019WebView","P020TabHostTabSpec","P021FileOutputStream","P022AsyncTaskClass","P023Spinner","P024SqlLite",
            "P025Dialog","P026AlertDialog","P027SQLiteDatabaseClass","P028SharedPreferences","P029InternalStorage","P030TeaspoonConversion","P031IntentServices",
            "P032PreferencesNot","P033VideoView","P034GetDefaultSharedPreferences","P035Bitmap"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListAdapter listAdapter= new ArrayAdapter<String>(P000Menu.this,android.R.layout.simple_list_item_1,ActivitySName);
        setListAdapter(listAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        try {  //buradaki kontrolun sebebi program risk almaz ya o isimde bir Activity yok ise! der
            Class AcilClass= Class.forName("com.example.kkldfkld.myapplication."+ l.getItemAtPosition(position));//ActivitySName[position]);
            Intent intent =new Intent(P000Menu.this,AcilClass);
            startActivity(intent);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this,"ClassNotFoundException is occur",Toast.LENGTH_SHORT).show();
        }
    }
}*/

package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;


import java.io.FileInputStream;
import java.io.IOException;

public class P029NextActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p028nextactivity);
    }
    public void onClickLoadMtdP028(View view) throws IOException {
        FileInputStream fileInputStream= openFileInput("Freedom");
        byte[] buffer=new byte[fileInputStream.available()];
        String katar = null;
        if((fileInputStream.read(buffer)) !=-1) {
            katar=new String(buffer);
        }

        TextView textViewNameP028= (TextView)findViewById(R.id.textViewNameP028);
        textViewNameP028.setText(katar);

    }

    public void onClickPreviousMtdP028(View view) {
        Intent intent=new Intent(P029NextActivity.this,P029InternalStorage.class);
        startActivity(intent);
    }
}



/*
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class P029NextActivity extends Activity{

    TextView textViewNameP028;
    TextView textViewPasswordP028;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p028nextactivity);

        textViewNameP028=(TextView)findViewById(R.id.textViewNameP028);
        textViewPasswordP028= (TextView)findViewById(R.id.textViewPasswordP028);
    }
    public void onClickLoadMtdP028(View view){
        FileInputStream fileInputStream= null;
        try {
            fileInputStream = openFileInput("denemeP029.txt");
            int read=-1;
            StringBuffer stringBuffer=new StringBuffer();
            while(( read=fileInputStream.read()) !=-1){
                stringBuffer.append((char)read);
            }
            Log.d("DENEMEP029",stringBuffer.toString());
            String Name=stringBuffer.substring(0,stringBuffer.indexOf(" "));
            String Password=stringBuffer.substring(stringBuffer.indexOf(" ")+1);

            textViewNameP028.setText(Name);
            textViewPasswordP028.setText(Password);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Toast.makeText(this, "Load Successfully", Toast.LENGTH_SHORT).show();
    }
    public void onClickPreviousMtdP028(View view){
        Toast.makeText(this, "Go To Previous Activity", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,P028SharedPreferences.class);
        startActivity(intent);
    }


}

// what you see when you open the file?
// name Password
// what is actually contained in the file?
// 112 115 116 114 123 14 15 31 125 22 33 31

*/


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
// what you see when you open the file?
// name Password
// what is actually contained in the file?
// 112 115 116 114 123 14 15 31 125 22 33 31


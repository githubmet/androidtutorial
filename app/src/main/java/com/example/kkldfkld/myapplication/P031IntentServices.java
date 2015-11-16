package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class P031IntentServices extends Activity {

    EditText downloadEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p031intentservices);

        downloadEditText=(EditText)findViewById(R.id.downloadEditText);
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction(P031FileService.TRANSACTION_DONE);

        registerReceiver(downloadReciever,intentFilter);


    }

    public void startFileService(View view){
        Intent intent=new Intent(this,P031FileService.class);
        intent.putExtra("url","http://www.newthinktank.com/wordpress/lotr.txt");

        this.startService(intent);
    }

    private BroadcastReceiver downloadReciever=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("FileService","Service Recieved");

            showFileContents();
        }};
    public void showFileContents(){
        StringBuilder sb;
        try{
            FileInputStream fis=this.openFileInput("myfile");
            InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
            BufferedReader bufferedReader=new BufferedReader(isr);
            sb=new StringBuilder();
            String line;

            while((line=bufferedReader.readLine())!=null){
                sb.append(line).append("\n");
            }
            downloadEditText.setText(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

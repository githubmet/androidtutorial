package com.example.kkldfkld.myapplication;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class P031FileService extends IntentService {

    public static final String TRANSACTION_DONE="com.newthinktank.TRANSACTION_DONE"; //islemin bittigini P031IntentServices.class bilirmek icin

    public P031FileService(String name) {
        super(name);
    }
    public P031FileService() {
        super(P031FileService.class.getName());  //validate the resources values  asagidaki intent e ulasmamizin sebebi olabilir
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.e("FileService","Service Started");
        String passedURL=intent.getStringExtra("url");

        downloadFile(passedURL);   //download
        Log.e("FileService", "Service Stopped"); //stop

        //this is the broadcast
        Intent i2=new Intent(TRANSACTION_DONE);   //broadcast and MainActivity catch that
        P031FileService.this.sendBroadcast(i2);
    }

    private void downloadFile(String theURL) {
        String fileName="myFile";

        try{
            FileOutputStream outputStream=openFileOutput(fileName, Context.MODE_PRIVATE);
            URL fileUrl =new URL(theURL);

            HttpURLConnection urlConnection=(HttpURLConnection)fileUrl.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoOutput(true);

            urlConnection.connect();

            InputStream inputStream=urlConnection.getInputStream();
            byte[] buffer=new byte[1024];
            int bufferLength=0;

            while((bufferLength=inputStream.read(buffer))>0){
                outputStream.write(buffer,0,bufferLength);
            }
            outputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

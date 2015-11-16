package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class P011NotificationCompatBuilder extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout relativeLayout =new RelativeLayout(this);
        relativeLayout.setBackgroundColor(Color.CYAN);
        Button button=new Button(this);
        button.setText("NotificationCompatBuilder");
        button.setTextColor(Color.parseColor("#FFFFFF"));
        relativeLayout.addView(button);
        setContentView(relativeLayout);

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        NotificationCompat.Builder notificationCompat=new NotificationCompat.Builder(this);
        notificationCompat.setAutoCancel(true);
        notificationCompat.setContentText("Merhabalar uyandırma servisi sizleri yeni gününüzde başarılar diler");
        notificationCompat.setWhen(System.currentTimeMillis());
        notificationCompat.setSmallIcon(R.mipmap.ic_launcher);
        notificationCompat.setTicker("Mesaj is on air");


        Intent intent=new Intent(this,P011NotificationCompatBuilder.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent, PendingIntent.FLAG_UPDATE_CURRENT);//dikkat bu blok yeri onemli
        notificationCompat.setContentIntent(pendingIntent);


        int uniqueId=12345;
        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(uniqueId,notificationCompat.build());

    }
}




/*import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Button;

public class P011NotificationCompatBuilder extends Activity implements View.OnClickListener{

    private static int uniquId=23456;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout relativeLayout =new RelativeLayout(this);
        relativeLayout.setBackgroundColor(Color.CYAN);
        Button button=new Button(this);
        button.setText("NotificationCompatBuilder");
        button.setTextColor(Color.parseColor("#FFFFFF"));
        relativeLayout.addView(button);
        setContentView(relativeLayout);

        button.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        NotificationCompat.Builder notification=new NotificationCompat.Builder(P011NotificationCompatBuilder.this);
        notification.setAutoCancel(true); //delete from system statusBar sebep kullaniciya rahatsizlik vermesin diye

        notification.setSmallIcon(R.mipmap.ic_launcher);
        notification.setTicker("Yeni bir mesajiniz var"); //that is litter text on the status bar
        notification.setWhen(System.currentTimeMillis()); //paste time
        notification.setContentText("Selam, Ben NotificationCompat.Builder etkinliginden setAutoCancel Mtd. setSmallIcon setTicker setWhen setContentText");

        //Notification click halinde olacaklar icin
        Intent intent=new Intent(this,P011NotificationCompatBuilder.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);//dikkat bu blok yeri onemli
        notification.setContentIntent(pendingIntent);
        //temel kurulum burasidir
        NotificationManager notificationManager= (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(uniquId, notification.build());

    }
}*/

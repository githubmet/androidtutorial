package com.example.kkldfkld.myapplication;


import android.app.Activity;  //sonradan basla
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {  //public means accessable the other classes

    @Override
    protected void onCreate(Bundle TravisLoveBacon) {  //void just think this is a method
        super.onCreate(TravisLoveBacon);

        setContentView(R.layout.splash);   //olusturdugumuz layout content olarak yaz
        Thread thread=new Thread(){
          public void run(){
              try{
                  sleep(3000);
              }
              catch(InterruptedException e){
                  e.printStackTrace();
              }
              finally{
                  Intent intent =new Intent(Splash.this,P000Menu.class);//("com.example.kkldfkld.myapplication.MENU");
                  startActivity(intent);
              }
          }
        };
        thread.start();  //bunu unuttun
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

/*
new Runnable(){  //tek basina kullanildiginda  .run() methodunu cagirman gerekir:
@Override
public void run() {
try{
Thread.sleep(3000);
Class className= Class.forName("com.example.kkldfkld.myapplication.P000Menu");
Intent intent =new Intent(Splash.this,className);
startActivity(intent);
}
catch(InterruptedException e){
e.printStackTrace();
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
}
}.run();
*/

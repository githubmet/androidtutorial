package com.example.kkldfkld.myapplication;


import android.content.Context;
import android.widget.Toast;

public class P005ToastClass{
    public static void makeSomeToast(Context context, String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
}

package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import android.app.ProgressDialog;

public class P022AsyncTaskClass extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout relativeLayout=new RelativeLayout(this);
        relativeLayout.setBackgroundColor(Color.parseColor("#006699"));

        Button button =new Button(this);
        button.setText("You can use a task Thread for background task jobs!");
        button.setId(1234);

        RelativeLayout.LayoutParams buttonKonum=new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        buttonKonum.addRule(RelativeLayout.CENTER_HORIZONTAL,relativeLayout.getId());
        buttonKonum.addRule(RelativeLayout.CENTER_VERTICAL,relativeLayout.getId());

        button.setLayoutParams(buttonKonum);
        relativeLayout.addView(button);
        setContentView(relativeLayout);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()== 1234){

            new backGroundTask().execute("geriKontrol");
        }
    }

    public class backGroundTask extends AsyncTask<String, Integer,String>{

        ProgressDialog progressDialog;

        @Override
        protected String doInBackground(String... params) {

            for(int i=0; i<100;i++){
                publishProgress(1);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            progressDialog.dismiss();
            return null;
        }

        @Override
        protected void onPreExecute() {
            progressDialog=new ProgressDialog(P022AsyncTaskClass.this);
            progressDialog.setMax(100);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.show();

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressDialog.incrementProgressBy(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
}





/*

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.graphics.Color;

import android.os.AsyncTask;
import android.app.ProgressDialog;
import android.widget.Toast;

public class P022AsyncTaskClass extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);

        RelativeLayout relativeLayout=new RelativeLayout(this);
        relativeLayout.setBackgroundColor(Color.parseColor("#006699"));

        Button button =new Button(this);
        button.setText("You can use a task Thread for background task jobs!");

        RelativeLayout.LayoutParams buttonKonum=new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        buttonKonum.addRule(RelativeLayout.CENTER_HORIZONTAL,relativeLayout.getId());
        buttonKonum.addRule(RelativeLayout.CENTER_VERTICAL,relativeLayout.getId());

        button.setLayoutParams(buttonKonum);
        relativeLayout.addView(button);
        setContentView(relativeLayout);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new backGroundClass().execute("merhabalar");
                    }
                }
        );

    }
    public class backGroundClass extends AsyncTask<String,Integer,String>{

        ProgressDialog progressDialog;
        @Override
        protected String doInBackground(String... params) {

            for(int i=0;i<20;i++) {
                publishProgress(5);
                try {
                    Thread.sleep(188);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            progressDialog.dismiss();
            return null;
        }

        @Override
        protected void onPreExecute() {
            progressDialog= new ProgressDialog(P022AsyncTaskClass.this);

            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setMax(100);
            progressDialog.show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressDialog.incrementProgressBy(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(P022AsyncTaskClass.this,"Conguralions",Toast.LENGTH_SHORT).show();
        }
    }
}





*/


/*
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.AsyncTask;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.view.View;


public class P022AsyncTaskClass extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout relativeLayout=new RelativeLayout(this);
        Button buttonBackGroudWork=new Button(this);
        buttonBackGroudWork.setText("Arka plan islemleri icin ayri bir Thread kullanilir!");

        RelativeLayout.LayoutParams buttonKonum=new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        buttonKonum.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonKonum.addRule(RelativeLayout.CENTER_VERTICAL);

        buttonBackGroudWork.setLayoutParams(buttonKonum); // bu daha iyi bir yazim

        relativeLayout.addView(buttonBackGroudWork);
        setContentView(relativeLayout);

        buttonBackGroudWork.setOnClickListener(this);
}
    @Override
    public void onClick(View v) {
        new loadSomeStuff().execute("fileName");  //burada new anahtarini unutmana ragmen bunu bile hatirlat ti
    }
    //first parameter fileName,  progress update bar,  thrid one what was returining
    public class loadSomeStuff extends AsyncTask<String,Integer, String> {
        ProgressDialog progressDialog;
        @Override
        protected String doInBackground(String... params) {   //String... yani String[] demek

            for(int i=0;i<20;i++){
                publishProgress(5); //send 5 each time
                try {
                    Thread.sleep(188);  //sadece gormek icin
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
             progressDialog.dismiss(); //kapatmamiz gerekmektedir
            return null;
        }
        protected void onPreExecute(){
            progressDialog=new ProgressDialog(P022AsyncTaskClass.this);  //dialog ekranin gosterilecegi Activity;
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setMax(100);
            progressDialog.show();
        }

        protected void onProgressUpdate(Integer... progress){
            progressDialog.incrementProgressBy(progress[0]);  //which is 5
        }

        protected void onPostExecute(String result){
        }

    }
}
//some time loading data make some time so use seperated thread

*/

package com.example.kkldfkld.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

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
            new backGroundTask().execute("geriKontrol");
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
    }
}

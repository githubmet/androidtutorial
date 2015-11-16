package com.example.kkldfkld.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Dialog;
import android.widget.TextView;

public class P024SqlLite extends Activity implements View.OnClickListener {
    EditText editTextSqlNameP024;
    EditText editTextSqlHotnessP024;
    Button buttonSqlUpdateP024;
    Button buttonSqlViewP024;

    EditText editTextRowIdP024;
    Button buttonGetInfoP024;
    Button buttonEditP024;
    Button buttonDeleteP024;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p024sqllite);

        editTextSqlNameP024=(EditText)findViewById(R.id.editTextSqlNameP024);
        editTextSqlHotnessP024=(EditText)findViewById(R.id.editTextSqlHotnessP024);
        buttonSqlUpdateP024= (Button)findViewById(R.id.buttonSqlUpdateP024);
        buttonSqlViewP024= (Button)findViewById(R.id.buttonSqlViewP024);

        buttonSqlUpdateP024.setOnClickListener(this);
        buttonSqlViewP024.setOnClickListener(this);

        editTextRowIdP024= (EditText)findViewById(R.id.editTextRowIdP024);
        buttonGetInfoP024= (Button)findViewById(R.id.buttonGetInfoP024);
        buttonEditP024= (Button)findViewById(R.id.buttonEditP024);
        buttonDeleteP024= (Button)findViewById(R.id.buttonDeleteP024);

        buttonGetInfoP024.setOnClickListener(this);
        buttonEditP024.setOnClickListener(this);
        buttonDeleteP024.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonSqlUpdateP024:

                boolean didItWork=true;
                try {
                    String Name = editTextSqlNameP024.getText().toString();
                    String Hotness = editTextSqlHotnessP024.getText().toString();

                    P024HotOrNot entry = new P024HotOrNot(P024SqlLite.this);
                    entry.open(); //biliyorsun bundan sonra islemler yapilacak
                    entry.createEntry(Name, Hotness);

                    entry.close();
                }
                catch(Exception ex){
                    didItWork=false;

                    String error=ex.toString();
                    Dialog dialog=new Dialog(this);
                    dialog.setTitle("Ooops");
                    TextView textView=new TextView(this);
                    textView.setText(error);
                    dialog.setContentView(textView);
                    dialog.show();
                }
                finally{
                    if(didItWork){
                        Dialog dialog=new Dialog(this);
                        dialog.setTitle("Yuup pe!");
                        TextView textView =new TextView(this);
                        textView.setText("Success");
                        dialog.setContentView(textView);  //dikkat guzel bir yakladim
                        dialog.show();
                    }

                }
                break;
            case R.id.buttonSqlViewP024:
                Intent intent =new Intent("com.example.kkldfkld.myapplication.P024SQLVIEW");
                startActivity(intent);
                break;

            case R.id.buttonGetInfoP024:
                try{
                String rowId=editTextRowIdP024.getText().toString();
                long rowLong=Long.parseLong(rowId);

                P024HotOrNot p024HotOrNot=new P024HotOrNot(this);
                p024HotOrNot.open();

                String returnedName=p024HotOrNot.getName(rowId);
                String returnedHotness=p024HotOrNot.getHotness(rowLong);

                p024HotOrNot.close();

                editTextSqlNameP024.setText(returnedName);
                editTextSqlHotnessP024.setText(returnedHotness);
                }
                catch(Exception ex){


                    String error=ex.toString();
                    Dialog dialog=new Dialog(this);
                    dialog.setTitle("Ooops");
                    TextView textView=new TextView(this);
                    textView.setText(error);
                    dialog.setContentView(textView);
                    dialog.show();
                }
                break;
            case R.id.buttonEditP024:
                try{
                String rowId2=editTextRowIdP024.getText().toString();
                long rowLong2=Long.parseLong(rowId2);

                String Name=editTextSqlNameP024.getText().toString();
                String Hotness=editTextSqlHotnessP024.getText().toString();

                P024HotOrNot p024HotOrNot2=new P024HotOrNot(this);
                p024HotOrNot2.open();
                p024HotOrNot2.updateEntry(rowLong2, Name, Hotness);

                p024HotOrNot2.close();
                }
                catch(Exception ex){

                    String error=ex.toString();
                    Dialog dialog=new Dialog(this);
                    dialog.setTitle("Ooops");
                    TextView textView=new TextView(this);
                    textView.setText(error);
                    dialog.setContentView(textView);
                    dialog.show();
                }
                break;

            case R.id.buttonDeleteP024:
                try{
                String rowId3=editTextRowIdP024.getText().toString();
                long rowLong3=Long.parseLong(rowId3);

                P024HotOrNot p024HotOrNot3=new P024HotOrNot(this);
                p024HotOrNot3.open();
                p024HotOrNot3.deleteEntry(rowLong3);

                p024HotOrNot3.close();
                }
                catch(Exception ex){

                    String error=ex.toString();
                    Dialog dialog=new Dialog(this);
                    dialog.setTitle("Ooops");
                    TextView textView=new TextView(this);
                    textView.setText(error);
                    dialog.setContentView(textView);
                    dialog.show();
                }
                break;

        }
    }
}


















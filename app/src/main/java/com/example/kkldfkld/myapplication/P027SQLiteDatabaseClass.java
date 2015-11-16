package com.example.kkldfkld.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.app.Dialog;

public class P027SQLiteDatabaseClass extends Activity implements View.OnClickListener{

    EditText editTextNameP027;
    EditText editTextSurnameP027;
    Button buttonInsertP027;
    Button buttonGetAllInfoP027;
    EditText editTextIdP027;
    Button buttonGetInfoByIdP027;
    Button buttonDeleteByIdP027;
    EditText editTextNameByIdP027;
    EditText editTextSurnameByIdP027;
    Button buttonUpdateP027;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.p027sqlitedatabaseclass);

        elemanYakalaMtd();

        buttonInsertP027.setOnClickListener(this);
        buttonGetAllInfoP027.setOnClickListener(this);
        buttonGetInfoByIdP027.setOnClickListener(this);
        buttonDeleteByIdP027.setOnClickListener(this);
        buttonUpdateP027.setOnClickListener(this);

    }

    private void elemanYakalaMtd() {
        editTextNameP027= (EditText)findViewById(R.id.editTextNameP027);
        editTextSurnameP027=(EditText)findViewById(R.id.editTextSurnameP027);
        buttonInsertP027= (Button)findViewById(R.id.buttonInsertP027);
        buttonGetAllInfoP027= (Button)findViewById(R.id.buttonGetAllInfoP027);
        editTextIdP027= (EditText)findViewById(R.id.editTextIdP027);
        buttonGetInfoByIdP027= (Button)findViewById(R.id.buttonGetInfoByIdP027);
        buttonDeleteByIdP027= (Button)findViewById(R.id.buttonDeleteByIdP027);
        editTextNameByIdP027= (EditText)findViewById(R.id.editTextNameByIdP027);
        editTextSurnameByIdP027= (EditText)findViewById(R.id.editTextSurnameByIdP027);
        buttonUpdateP027= (Button)findViewById(R.id.buttonUpdateP027);
    }

    @Override
    public void onClick(View v) {
        P027BSOLiteOpenHelperClass p027BSOLiteOpenHelperClass=new P027BSOLiteOpenHelperClass(this);
        switch(v.getId()){
            case R.id.buttonInsertP027:
                p027BSOLiteOpenHelperClass.openMtd();
                long kontrol= p027BSOLiteOpenHelperClass.InsertMtd(editTextNameP027.getText().toString(),editTextSurnameP027.getText().toString());
                p027BSOLiteOpenHelperClass.closeMtd();
                if( (int)kontrol >0 ){
                    Toast.makeText(this,"Successfull",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.buttonGetAllInfoP027:
                p027BSOLiteOpenHelperClass.openMtd();
                String katar=p027BSOLiteOpenHelperClass.GetAllInfoMtd();
                p027BSOLiteOpenHelperClass.closeMtd();

                Dialog dialog=new Dialog(this);
                dialog.setTitle("Kayitlar");
                TextView textView=new TextView(this);
                textView.setText(katar);

                dialog.setContentView(textView);
                dialog.show();

                break;
            case R.id.buttonGetInfoByIdP027:
                p027BSOLiteOpenHelperClass.openMtd();

                String name= p027BSOLiteOpenHelperClass.GetNameById((editTextIdP027.getText().toString()));
                String surname= p027BSOLiteOpenHelperClass.GetSurnameById(editTextIdP027.getText().toString());

                p027BSOLiteOpenHelperClass.closeMtd();

                editTextNameByIdP027.setText(name);
                editTextSurnameByIdP027.setText(surname);

                break;
            case R.id.buttonUpdateP027:
                p027BSOLiteOpenHelperClass.openMtd();
                int kontrol2=p027BSOLiteOpenHelperClass.UpdateNameAndSurnameById(editTextNameByIdP027.getText().toString(),editTextSurnameByIdP027.getText().toString(),Integer.valueOf(editTextIdP027.getText().toString()));
                p027BSOLiteOpenHelperClass.closeMtd();

                if(kontrol2 >0){
                    Toast.makeText(this,"Successfull",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.buttonDeleteByIdP027:
                p027BSOLiteOpenHelperClass.openMtd();
                int kontrol3= p027BSOLiteOpenHelperClass.DeleteInfoById(Integer.valueOf(editTextIdP027.getText().toString()));
                p027BSOLiteOpenHelperClass.closeMtd();

                if(kontrol3 >0){
                    Toast.makeText(this,"Successfull",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show();
                }
                break;

        }

    }
}





/*

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Dialog;

public class P027SQLiteDatabaseClass extends Activity implements View.OnClickListener {

    EditText editTextNameP027;
    EditText editTextSurnameP027;
    Button buttonInsertP027;
    Button buttonGetAllInfoP027;
    EditText editTextIdP027;
    Button buttonGetInfoByIdP027;
    Button buttonDeleteByIdP027;
    EditText editTextNameByIdP027;
    EditText editTextSurnameByIdP027;
    Button buttonUpdateP027;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.p027sqlitedatabaseclass);

        elemanYakalaMtd();

        buttonInsertP027.setOnClickListener(this);
        buttonGetAllInfoP027.setOnClickListener(this);
        buttonGetInfoByIdP027.setOnClickListener(this);
        buttonDeleteByIdP027.setOnClickListener(this);
        buttonUpdateP027.setOnClickListener(this);

    }

    private void elemanYakalaMtd() {
        editTextNameP027= (EditText)findViewById(R.id.editTextNameP027);
        editTextSurnameP027=(EditText)findViewById(R.id.editTextSurnameP027);
        buttonInsertP027= (Button)findViewById(R.id.buttonInsertP027);
        buttonGetAllInfoP027= (Button)findViewById(R.id.buttonGetAllInfoP027);
        editTextIdP027= (EditText)findViewById(R.id.editTextIdP027);
        buttonGetInfoByIdP027= (Button)findViewById(R.id.buttonGetInfoByIdP027);
        buttonDeleteByIdP027= (Button)findViewById(R.id.buttonDeleteByIdP027);
        editTextNameByIdP027= (EditText)findViewById(R.id.editTextNameByIdP027);
        editTextSurnameByIdP027= (EditText)findViewById(R.id.editTextSurnameByIdP027);
        buttonUpdateP027= (Button)findViewById(R.id.buttonUpdateP027);
    }

    @Override
    public void onClick(View v) {
        P027BSOLiteOpenHelperClass p027SQLiteOpenHelperClass=new P027BSOLiteOpenHelperClass(P027SQLiteDatabaseClass.this);
        switch(v.getId()){

            case R.id.buttonInsertP027:  //database islemlerinde ilgili method throws SQLException olarak modifiye edilebilir
                p027SQLiteOpenHelperClass.openMtd();
                long kontrol= p027SQLiteOpenHelperClass.InsertMtd(editTextNameP027.getText().toString(), editTextSurnameP027.getText().toString());
                p027SQLiteOpenHelperClass.closeMtd();
                if(kontrol>0) {
                    Toast.makeText(this, "Successfull", Toast.LENGTH_SHORT).show();
                }
                else{  //"-1" degeri bize insert komutunun yerine getirilemedigini bildirir!
                    Toast.makeText(this, "Basarisiz", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.buttonGetAllInfoP027:
                p027SQLiteOpenHelperClass.openMtd();
                String veri=p027SQLiteOpenHelperClass.GetAllInfoMtd();
                p027SQLiteOpenHelperClass.closeMtd();

                Dialog dialog=new Dialog(this);
                dialog.setTitle("Kayitlar");
                TextView textView=new TextView(this);
                textView.setText(veri);
                dialog.setContentView(textView);
                dialog.show();

                break;
            case R.id.buttonGetInfoByIdP027:
                p027SQLiteOpenHelperClass.openMtd();
                editTextNameByIdP027.setText(p027SQLiteOpenHelperClass.GetNameById(editTextIdP027.getText().toString()));
                editTextSurnameByIdP027.setText(p027SQLiteOpenHelperClass.GetSurnameById(editTextIdP027.getText().toString()));
                p027SQLiteOpenHelperClass.closeMtd();
                break;
            case R.id.buttonDeleteByIdP027:
                p027SQLiteOpenHelperClass.openMtd();
                p027SQLiteOpenHelperClass.DeleteInfoById(editTextIdP027.getText().toString());
                p027SQLiteOpenHelperClass.closeMtd();
                Toast.makeText(this,"Sucessfull",Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonUpdateP027:
                p027SQLiteOpenHelperClass.openMtd();
                p027SQLiteOpenHelperClass.UpdateNameAndSurnameById(editTextNameByIdP027.getText().toString(), editTextSurnameByIdP027.getText().toString(),
                        editTextIdP027.getText().toString());
                p027SQLiteOpenHelperClass.closeMtd();
                break;
        }
    }
}
*/

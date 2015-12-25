package com.example.kkldfkld.myapplication;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.MenuInflater;
import android.widget.Toast;

public class P007CreateUserFaceOnlyJavaCode2 extends ActionBarActivity {
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        linearLayout=new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);

        TextView textView=new TextView(this);
        textView.setText("Hello World");
        linearLayout.addView(textView);
        setContentView(linearLayout);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater= new MenuInflater(this);
        menuInflater.inflate(R.menu.p005normalmenuitem,menu);

        return true; //super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {

            case R.id.menu_bucky:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                linearLayout.setBackgroundColor(Color.parseColor("#006699"));
                return true;

            case R.id.menu_green:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                linearLayout.setBackgroundColor(Color.parseColor("#009900"));
                return true;

            case R.id.menu_acikmavi:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                linearLayout.setBackgroundColor(Color.parseColor("#b0c4de"));
                return true;

            case R.id.menu_dag:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                linearLayout.setBackgroundResource(R.drawable.dag);
                return true;

            case R.id.menu_ay:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                linearLayout.setBackgroundResource(R.drawable.atmosfer);
                return true;

            case R.id.menu_sol:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                linearLayout.setBackgroundResource(R.drawable.solanahtar);
                return true;

            case R.id.menu_activity:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                Intent intent = new Intent("com.example.kkldfkld.myapplication.P005ACTIVITY");
                startActivity(intent);
                return true;

            case R.id.menu_activity2:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                Intent intent2 = new Intent("com.example.kkldfkld.myapplication.P005ACTIVITY2");
                startActivity(intent2);
                return true;

            case R.id.menu_toast:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                Toast.makeText(P007CreateUserFaceOnlyJavaCode2.this, "Hello from menu item ", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_toastClass:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                P005ToastClass p005ToastClass = new P005ToastClass();
                p005ToastClass.makeSomeToast(P007CreateUserFaceOnlyJavaCode2.this, "Hello from my Toast Class");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

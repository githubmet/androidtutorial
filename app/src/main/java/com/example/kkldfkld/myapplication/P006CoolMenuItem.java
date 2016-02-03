package com.example.kkldfkld.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.view.MenuInflater;
import android.content.Intent;
import android.widget.Toast;

public class P006CoolMenuItem extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout relativeLayout=new RelativeLayout(this);
        relativeLayout.setBackgroundColor(Color.DKGRAY);
        setContentView(relativeLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu){   //(Menu menu) {  modifiye etki karisiklik olmasin

        MenuInflater menuInflater=new MenuInflater(P006CoolMenuItem.this);  //dikkat menu de bir Activity dir
        menuInflater.inflate(R.menu.p006coolmenuitem, menu);
        return super.onCreateOptionsMenu(menu);  //bu sayede tel tus devrede
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.cool_menu:
                Intent intent =new Intent("com.example.kkldfkld.myapplication.P006ABOUTHUS");  //string bir katar olarak yeni bir Activity belirtebilmek icin
                startActivity(intent); //Manifest dosyasinda intent-filter belirtmen gerekir
                return true;
            case R.id.cool_menu2:
                Intent intent2=new Intent(P006CoolMenuItem.this,P005Preference.class);
                startActivity(intent2); //Manifest dosyasinda intent-filter belirtmen gerekir sebep abir ust satir
                return true;
            case R.id.cool_menu3:
                Toast.makeText(P006CoolMenuItem.this,"NoProblemHiko",Toast.LENGTH_SHORT).show();
                finish();  //ilgili Activity kapatmak icin yeterli:):):)
                return true;
            default:return super.onOptionsItemSelected(item);
        }
    }
}

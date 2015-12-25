package com.example.kkldfkld.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class P020TabHostTabSpec extends Activity implements View.OnClickListener {

    TabHost tabHost2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p020tabhosttabspec);


        tabHost2= (TabHost)findViewById(R.id.tabHost2);
        tabHost2.setup();

        TabSpec tabSpec= tabHost2.newTabSpec("TabSpec One");
        tabSpec.setContent(R.id.linearLayout);
        tabSpec.setIndicator("TaB One2");

        tabHost2.addTab(tabSpec);

        TabSpec tabSpec2= tabHost2.newTabSpec("TabSpec Two");
        tabSpec2.setContent(R.id.linearLayout2);
        tabSpec2.setIndicator("TaB TwO2");

        tabHost2.addTab(tabSpec2);

        TabSpec tabSpec3 =tabHost2.newTabSpec("TabSpec Three");
        tabSpec3.setContent(R.id.linearLayout3);
        tabSpec3.setIndicator("TaB ThReE2");

        tabHost2.addTab(tabSpec3);

        Button buttonAddTab2= (Button)findViewById(R.id.buttonAddTab2);
        buttonAddTab2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.buttonAddTab2){
            TabSpec tabSpecNewOne= tabHost2.newTabSpec("New One");
            tabSpecNewOne.setContent(new TabHost.TabContentFactory() {
                @Override
                public View createTabContent(String tag) {

                    TextView textView=new TextView(P020TabHostTabSpec.this);
                    textView.setText("Congrulations");

                    return textView;
                }
            });

            tabSpecNewOne.setIndicator("New OnE2");
            tabHost2.addTab(tabSpecNewOne);
        }
    }
}


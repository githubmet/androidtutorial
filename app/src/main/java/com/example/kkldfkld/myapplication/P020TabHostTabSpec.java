package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.TextView;

public class P020TabHostTabSpec extends Activity implements View.OnClickListener {

    TabHost tabHost2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p020btabhosttabspec);


        tabHost2= (TabHost)findViewById(R.id.tabHost2);
        tabHost2.setup();

        TabSpec tabSpec= tabHost2.newTabSpec("TaB OnE");
        tabSpec.setContent(R.id.linearLayout);
        tabSpec.setIndicator("TaB One2");

        tabHost2.addTab(tabSpec);

        TabSpec tabSpec2= tabHost2.newTabSpec("TaB TwO");
        tabSpec2.setContent(R.id.linearLayout2);
        tabSpec2.setIndicator("TaB TwO2");

        tabHost2.addTab(tabSpec2);

        TabSpec tabSpec3 =tabHost2.newTabSpec("TaB ThReE");
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





/*

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.Button;
import android.widget.TextView;

public class P020TabHostTabSpec extends Activity implements View.OnClickListener {

    TabHost tabHost;
    TextView textViewShowResult;
    Long start,stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.p020tabhosttabspec);

        tabHost= (TabHost)findViewById(R.id.tabHost);
        tabHost.setup();
        TabSpec tabSpec=tabHost.newTabSpec("TAG ONE");
        tabSpec.setContent(R.id.tab1); // refer like a layout:)
        tabSpec.setIndicator("Stop Watch");
        tabHost.addTab(tabSpec);

        tabSpec=tabHost.newTabSpec("TAG Two");   //ayni araci kullandik
        tabSpec.setContent(R.id.tab2); // refer like a layout:)
        tabSpec.setIndicator("Tab 2");
        tabHost.addTab(tabSpec);

        tabSpec=tabHost.newTabSpec("TAG There");
        tabSpec.setContent(R.id.tab3); // refer like a layout:)
        tabSpec.setIndicator("Add a tab");
        tabHost.addTab(tabSpec);

        Button buttonStart= (Button)findViewById(R.id.buttonStart);
        Button buttonStop= (Button)findViewById(R.id.buttonStop);
        Button buttonAddTab= (Button)findViewById(R.id.buttonAddTab);
        textViewShowResult= (TextView)findViewById(R.id.textViewShowResult);

        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);
        buttonAddTab.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.buttonStart:
                start=System.currentTimeMillis();
                break;
            case R.id.buttonStop:
                stop=System.currentTimeMillis();

                if(start != 0){ //kontrollu gitmek her zaman icin iyidir!
                    Long result=stop-start;
//                    int millis= (int)result; //hey, don not talk anybody! We make a deal
//                    int seconds=(int)result/1000;
//                    int minutes=seconds/60;
//                    millis=millis%100;
//                    seconds=seconds % 60;
//                    textViewShowResult.setText(String.format("%d:%02d:%02d",minutes,seconds,millis));

                    textViewShowResult.setText(Long.toString(result)); //dikkat burada cool bir Convert islemi var!
                }
                break;
            case R.id.buttonAddTab:
                TabSpec tabSpecNew=tabHost.newTabSpec("TAG1");
                tabSpecNew.setContent(new TabHost.TabContentFactory() {  //dikkat tamamen tomatik olarak yap�ld� sadece bi layout
                    @Override                                           //olmad��� i�in View donderecek bir�eye ihtiyac�m�z olaca��n� hayal et
                    public View createTabContent(String tag) {

                        TextView textView =new TextView(P020TabHostTabSpec.this);
                        textView.setText("You have created a new tab!");
                        return (textView);
                    }
                });

                tabSpecNew.setIndicator("New One");
                tabHost.addTab(tabSpecNew);
                break;
        }

    }
}

*/

















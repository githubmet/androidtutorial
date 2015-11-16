package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class P005Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout relativeLayout=new RelativeLayout(this);
        relativeLayout.setBackgroundColor(Color.CYAN);
        TextView textView =new TextView(this);
        textView.setText("Hello from normal menu item");

        RelativeLayout.LayoutParams textViewKonum=new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        textViewKonum.addRule(RelativeLayout.CENTER_VERTICAL,relativeLayout.getId());
        textViewKonum.addRule(RelativeLayout.CENTER_HORIZONTAL,relativeLayout.getId());
        textView.setLayoutParams(textViewKonum);

        relativeLayout.addView(textView);
        setContentView(relativeLayout);
    }
}

/*import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.RelativeLayout;
public class P005Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout relativeLayout=new RelativeLayout(this);
        relativeLayout.setBackgroundColor(Color.CYAN);

        TextView textView=new TextView(this);
        textView.setText("Hi from MenuItem");

        RelativeLayout.LayoutParams textViewKonum=new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        textViewKonum.addRule(RelativeLayout.CENTER_HORIZONTAL);
        textViewKonum.addRule(RelativeLayout.CENTER_VERTICAL);
//        textView.setLayoutParams(textViewKonum);  bu sekilde daha profesyonel
        relativeLayout.addView(textView,textViewKonum);

        setContentView(relativeLayout);
    }
}*/

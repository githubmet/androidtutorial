package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;


public class P008GridLayout_Implements_View_OnClickListener extends Activity implements View.OnClickListener {

    Button button;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    RelativeLayout relativeLayoutPDeneme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdeneme);

        button=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);
        button5=(Button)findViewById(R.id.button5);
        button6=(Button)findViewById(R.id.button6);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);

        relativeLayoutPDeneme= (RelativeLayout)findViewById(R.id.relativeLayoutPDename);

    }

    @Override
    public void onClick(View v) {

        RelativeLayout.LayoutParams button6Konum= new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        switch (v.getId()){
            case R.id.button:
                button6Konum.addRule(RelativeLayout.CENTER_VERTICAL,relativeLayoutPDeneme.getId());
                button6Konum.addRule(RelativeLayout.ALIGN_PARENT_LEFT, relativeLayoutPDeneme.getId());
                button6.setText("LEFT");
                break;
            case R.id.button2:
                button6Konum.addRule(RelativeLayout.CENTER_HORIZONTAL,relativeLayoutPDeneme.getId());
                button6Konum.addRule(RelativeLayout.ALIGN_PARENT_TOP,relativeLayoutPDeneme.getId());
                button6.setText("TOP");
                break;
            case R.id.button3:
                button6Konum.addRule(RelativeLayout.CENTER_VERTICAL,relativeLayoutPDeneme.getId());
                button6Konum.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,relativeLayoutPDeneme.getId());
                button6.setText("RIGHT");
                break;
            case R.id.button4:
                button6Konum.addRule(RelativeLayout.CENTER_VERTICAL,relativeLayoutPDeneme.getId());
                button6Konum.addRule(RelativeLayout.CENTER_HORIZONTAL,relativeLayoutPDeneme.getId());
                button6.setText("CENTER");
                break;
            case R.id.button5:
                button6Konum.addRule(RelativeLayout.CENTER_HORIZONTAL,relativeLayoutPDeneme.getId());
                button6Konum.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,relativeLayoutPDeneme.getId());
                button6.setText("BOTTOM");
                break;
            case R.id.button6:
                button6.setText("OK GAME OVER");
                break;
        }
        button6.setLayoutParams(button6Konum);
    }
}


/*

import android.app.Activity;
import android.os.Bundle;

import android.widget.RelativeLayout;
import android.widget.Button;
import android.view.View;
// View > Button oladugundan genel den hareketle islem yapmak hata olasiligini azaltir! orn asagisi
public class P008GridLayout_Implements_View_OnClickListener extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p008gridlayoutandimplements);


        Button buttonLeft= (Button)findViewById(R.id.buttonLeft);
        buttonLeft.setOnClickListener(this);  //implements yaptiktan sonra sadece this demek yetiyor

        Button buttonRight= (Button)findViewById(R.id.buttonRight);
        buttonRight.setOnClickListener(this);

        Button buttonTop= (Button)findViewById(R.id.buttonTop);
        buttonTop.setOnClickListener(this);

        Button buttonBottom= (Button)findViewById(R.id.buttonBottom);
        buttonBottom.setOnClickListener(this);

        Button buttonCenter= (Button)findViewById(R.id.buttonCenter);
        buttonCenter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final Button buttonMove2= (Button) findViewById(R.id.buttonMove);

        RelativeLayout.LayoutParams buttonMoveKonum=new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

       switch(v.getId()) {
           case R.id.buttonLeft:
           buttonMove2.setText("Left");
               buttonMoveKonum.addRule(RelativeLayout.CENTER_VERTICAL);
               buttonMoveKonum.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
               break;
           case R.id.buttonRight:
               buttonMove2.setText("Right");
               buttonMoveKonum.addRule(RelativeLayout.CENTER_VERTICAL);
               buttonMoveKonum.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
               break;
           case R.id.buttonTop:
               buttonMove2.setText("Top");
               buttonMoveKonum.addRule(RelativeLayout.CENTER_HORIZONTAL);
               buttonMoveKonum.addRule(RelativeLayout.ALIGN_PARENT_TOP);
               break;
           case R.id.buttonBottom:
               buttonMove2.setText("Bottom");
               buttonMoveKonum.addRule(RelativeLayout.CENTER_HORIZONTAL);
               buttonMoveKonum.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
               break;
           case R.id.buttonCenter:
               buttonMove2.setText("Center");
               buttonMoveKonum.addRule(RelativeLayout.CENTER_VERTICAL);
               buttonMoveKonum.addRule(RelativeLayout.CENTER_HORIZONTAL);
               break;
       }
        buttonMove2.setLayoutParams(buttonMoveKonum);
    }
}
*/

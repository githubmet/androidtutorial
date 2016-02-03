package com.example.kkldfkld.myapplication;

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


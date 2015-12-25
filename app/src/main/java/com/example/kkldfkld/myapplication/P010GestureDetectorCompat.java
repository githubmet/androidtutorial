package com.example.kkldfkld.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class P010GestureDetectorCompat extends Activity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener{

    GestureDetectorCompat gestureDetectorCompat;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout relativeLayout=new RelativeLayout(this);
        relativeLayout.setBackgroundColor(Color.parseColor("#009966"));

        gestureDetectorCompat=new GestureDetectorCompat(this,this);
        textView=new TextView(this);
        textView.setText("GestureDetectorCompat");

        RelativeLayout.LayoutParams textViewKonum=new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        textViewKonum.addRule(RelativeLayout.CENTER_HORIZONTAL,relativeLayout.getId());
        textViewKonum.addRule(RelativeLayout.CENTER_VERTICAL,relativeLayout.getId());
        textView.setLayoutParams(textViewKonum);

        relativeLayout.addView(textView);
        setContentView(relativeLayout);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        textView.setText("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        textView.setText("onShowPress");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        textView.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        textView.setText("onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        textView.setText("onLongPress");

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        textView.setText("onFling");
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        textView.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        textView.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        textView.setText("onDoubleTabEvent");
        return true;
    }
}

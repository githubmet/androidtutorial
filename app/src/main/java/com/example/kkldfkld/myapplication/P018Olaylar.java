package com.example.kkldfkld.myapplication;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

import android.graphics.Rect;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.Bitmap;

public class P018Olaylar extends View {

    int ustDeger;
    int altDeger;
    public P018Olaylar(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Rect rectTopLeft=new Rect(0,0,canvas.getWidth()/2,canvas.getHeight()/2);
        Rect rectTopRight=new Rect(canvas.getWidth()/2,0,canvas.getWidth(),canvas.getHeight()/2);

        Rect rectBottomLeft=new Rect(0,canvas.getHeight()/2,canvas.getWidth()/2,canvas.getHeight());
        Rect rectBottomRight=new Rect(canvas.getWidth()/2,canvas.getHeight()/2,canvas.getWidth(),canvas.getHeight());

        Paint paint =new Paint();
        paint.setColor(Color.RED);

        Paint paint2 =new Paint();
        paint2.setColor(Color.GREEN);

        Paint paint3 =new Paint();
        paint3.setColor(Color.BLUE);

        Paint paint4 =new Paint();
        paint4.setColor(Color.GRAY);

        canvas.drawRect(rectTopLeft, paint);
        canvas.drawRect(rectTopRight, paint2);
        canvas.drawRect(rectBottomLeft, paint3);
        canvas.drawRect(rectBottomRight, paint4);


        Drawable drawable= getResources().getDrawable(R.drawable.icon_top);
        Bitmap bitmap= ((BitmapDrawable)drawable).getBitmap();

        canvas.drawBitmap(bitmap,canvas.getWidth()/4-128,ustDeger,null);

        canvas.drawBitmap(bitmap,(canvas.getWidth()/4)*3-128,ustDeger,null);

        canvas.drawBitmap(bitmap,canvas.getWidth()/4-128,altDeger,null);

        canvas.drawBitmap(bitmap,(canvas.getWidth()/4)*3-128,altDeger,null);
        //canvas.drawRect();

        if(ustDeger<canvas.getHeight()/2-256){
            ustDeger=ustDeger+10;
        }
        else{
            ustDeger=0;
        }

        if(altDeger<canvas.getHeight()-256){
            altDeger=altDeger+10;
        }
        else{
            altDeger=canvas.getHeight()/2;
        }
        invalidate();
    }
}
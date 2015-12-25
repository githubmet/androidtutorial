package com.example.kkldfkld.myapplication;

import android.content.Context;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Bitmap;
import android.graphics.Paint;


public class P018BCanvasAraclari extends View {

    public P018BCanvasAraclari(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.YELLOW); //Bize heryer sari

        Rect rect=new Rect(0, 100,canvas.getWidth(),25);
        Rect rect2=new Rect(0, 200,canvas.getWidth(),25);
        Rect rect3=new Rect(0, 300,canvas.getWidth(),25);
        Rect rect4=new Rect(0, 400,canvas.getWidth(),25);


        Paint paint=new Paint();
        Paint paint2=new Paint();
        Paint paint3=new Paint();
        Paint paint4=new Paint();

        paint.setColor(Color.BLUE);
        paint2.setColor(Color.CYAN);
        paint3.setColor(Color.GRAY);
        paint4.setColor(Color.GREEN);

        canvas.drawRect(rect4, paint4);
        canvas.drawRect(rect3,paint3);
        canvas.drawRect(rect2,paint2);
        canvas.drawRect(rect, paint);
        //invalidate();
    }
}


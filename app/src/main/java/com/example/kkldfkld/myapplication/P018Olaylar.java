package com.example.kkldfkld.myapplication;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Paint;

public class P018Olaylar extends View {

    public P018Olaylar(Context context) {
        super(context);
    }

    float changingY;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.parseColor("#006699"));

        Rect rectNoktalar=new Rect();
        rectNoktalar.set(0, 0, canvas.getWidth() / 2, canvas.getHeight());

        Paint paint=new Paint();
        paint.setColor(Color.WHITE);
        canvas.drawRect(rectNoktalar, paint);

        Rect rectNoktalar2=new Rect();
        rectNoktalar2.set(canvas.getWidth() / 2, 0, canvas.getWidth(), canvas.getHeight());
        Paint paint2=new Paint();
        paint2.setColor(Color.GRAY);
        canvas.drawRect(rectNoktalar2, paint2);

        Drawable drawable=getResources().getDrawable(R.drawable.bulleticon);
        Bitmap bitmap= ((BitmapDrawable)drawable).getBitmap();
        canvas.drawBitmap(bitmap,0,changingY,null);

         Bitmap bitmap22= BitmapFactory.decodeResource(getResources(),R.drawable.bulleticon);
        canvas.drawBitmap(bitmap22,canvas.getWidth()/2,changingY,null);


        if(changingY<canvas.getHeight()){
            changingY=changingY+10;
        }
        else{
            changingY=0;
        }

        invalidate();
    }
}






/*

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;


public class P018Olaylar extends View {

    Bitmap gBall;

    float changingY;

    //this is a reciever  Cunstructor
    public P018Olaylar(Context context) {
        super(context);
        gBall= BitmapFactory.decodeResource(getResources(),R.drawable.bulleticon);
    }

    //Canvas is the background what ever has
    @Override
    protected void onDraw(Canvas canvas) { //Canvas background ile alakali
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE); //senin yaptigin gibi surekli ciziyor
        //canvas.drawBitmap(gBall,(canvas.getWidth())/2,0,null);  //parametreler x y kordinatlaridir.
        //ekranin ortasindan ve en alta kadar diye kordinatladik  -->sonu en ustte ve ekranin ortasinda bir yeil top

        //hareketli top
        canvas.drawBitmap(gBall,(canvas.getWidth())/2,changingY,null);
        if(changingY <canvas.getHeight()){
            changingY +=10;
        }
        else{
            changingY=0;
        }


        Rect rect= new Rect();
        rect.set(0, (canvas.getHeight()) / 2, canvas.getWidth(), 300);

        Paint paint=new Paint();
        paint.setColor(Color.CYAN);
        canvas.drawRect(rect, paint);

        //ikinci rectangle
        Rect rect2=new Rect();
        rect2.set(0, 0, canvas.getWidth() / 2, canvas.getHeight());
        Paint paint2=new Paint();
        paint2.setColor(Color.GRAY);
        canvas.drawRect(rect2,paint2);

        //hareketli resim
        Drawable drawable=getResources().getDrawable(R.drawable.bulleticon);
        Bitmap bitmap=((BitmapDrawable)drawable).getBitmap();
        canvas.drawBitmap(bitmap,0,changingY,null);


        invalidate(); //do it over again  gibi
    }
}

*/

//
//package com.example.kkldfkld.myapplication2;
//
//        import android.content.Context;
//        import android.graphics.BitmapFactory;
//        import android.graphics.Canvas;
//        import android.graphics.Color;
//        import android.view.View;
//        import android.graphics.Bitmap;
//        import android.graphics.Rect;
//        import android.graphics.Color;
//        import android.graphics.Paint;
//
//public class P03MyBringBack extends View {
//
//    Bitmap gBall;
//
//    float changingY;
//
//    //this is a reciever  Cunstructor
//    public P03MyBringBack(Context context) {
//        super(context);
//        gBall= BitmapFactory.decodeResource(getResources(),R.drawable.bulleticon);
//    }
//
//    //Canvas is the background what ever has
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        canvas.drawColor(Color.WHITE);
//        //canvas.drawBitmap(gBall,(canvas.getWidth())/2,0,null);
//
//
//        //hareketli top
//        canvas.drawBitmap(gBall,(canvas.getWidth())/2,changingY,null);
//        if(changingY <canvas.getHeight()){
//            changingY +=10;
//        }
//        else{
//            changingY=0;
//        }
//
//        //rectangle alan ciz
//        Rect rect= new Rect();
//        rect.set(0, canvas.getHeight() / 2, canvas.getWidth(), 300);
//
//        Paint paint=new Paint();
//        paint.setColor(Color.CYAN);
//        canvas.drawRect(rect,paint);
//
//        invalidate(); //do it over again  gibi
//    }
//}

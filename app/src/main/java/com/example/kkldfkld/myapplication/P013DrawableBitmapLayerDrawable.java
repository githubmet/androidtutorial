package com.example.kkldfkld.myapplication;

/*

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class P013DrawableBitmapLayerDrawable extends Activity {

    ImageView imageView_Left;
    ImageView imageView_Right;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p013drawablebitmaplayerdrawable);

        imageView_Left= (ImageView)findViewById(R.id.imageView_left);
        imageView_Right=(ImageView)findViewById(R.id.imageView_right);


        imageView_Left.setImageResource(R.drawable.icon_top);
        imageView_Right.setImageResource(R.drawable.icon_bottom);


    }

    public void onClickMtdP013(View view) {
        ImageView imageView_bottomLeft= (ImageView)findViewById(R.id.imageView_bottomleft);

        Drawable drawableImage= getResources().getDrawable(R.drawable.icon_top);
        Bitmap bitmapImage= ((BitmapDrawable)drawableImage).getBitmap();

        Bitmap bitmapImageGHost= getImageGHost(bitmapImage);
        imageView_bottomLeft.setImageBitmap(bitmapImageGHost);

    }

    private Bitmap getImageGHost(Bitmap bitmapImage) {

        Bitmap skeleton=Bitmap.createBitmap(bitmapImage.getHeight(),bitmapImage.getWidth(),bitmapImage.getConfig());

        int j =bitmapImage.getHeight();
        int i=bitmapImage.getWidth();

        int r,g,b,a;

        for(int ifor=0; ifor<i;ifor++){
            for(int jfor=0; jfor<j; jfor++){
                int pixel= bitmapImage.getPixel(ifor,jfor);
                r=255- Color.red(pixel);
                g=255-Color.green(pixel);
                b=255-Color.blue(pixel);
                a=Color.alpha(pixel);
                skeleton.setPixel(i,j,Color.argb(a,r,g,b));
            }
        }
        return skeleton;
    }

    public void onClickMtd2P013(View view) {
        Drawable[] katmalar=new Drawable[2];
        katmalar[0]= imageView_Left.getDrawable();
        katmalar[1]=imageView_Right.getDrawable();

        LayerDrawable layerDrawable=new LayerDrawable(katmalar);


        ImageView imageView_bottomRight=(ImageView)findViewById(R.id.imageView_bottomright);
        imageView_bottomRight.setImageDrawable(layerDrawable);

    }
}

*/




import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import android.graphics.drawable.Drawable;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.LayerDrawable;

public class P013DrawableBitmapLayerDrawable extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p013drawablebitmaplayerdrawable);

        ImageView imageView_left= (ImageView)findViewById(R.id.imageView_left);
        ImageView imageView_right= (ImageView)findViewById(R.id.imageView_right);

        imageView_left.setImageResource(R.drawable.icon_top);
        imageView_right.setImageResource(R.drawable.icon_bottom);

    }
    public void onClickMtdP013(View view) {
        Drawable drawable=getResources().getDrawable(R.drawable.icon_top);
        Bitmap bitmap=((BitmapDrawable)drawable).getBitmap();  //hazir

        Bitmap newBitmap= invertToGhostMtd(bitmap);
        ImageView imageViewBottomLeft= (ImageView)findViewById(R.id.imageView_bottomleft);
        imageViewBottomLeft.setImageBitmap(newBitmap);
    }
    private Bitmap invertToGhostMtd(Bitmap bitmap) {

        Bitmap skeleton= Bitmap.createBitmap(bitmap.getHeight(), bitmap.getWidth(), bitmap.getConfig());

        int j=bitmap.getWidth();
        int i=bitmap.getHeight();

        int A,R,G,B;
        for(int ifor=0; ifor<i; ifor++)
        {
            for(int jfor=0; jfor<j; jfor++){
                int tinyCracks= bitmap.getPixel(ifor,jfor);
                R=255 - Color.red(tinyCracks);  //bu bir renk elemani bu kadar basit
                G=255 - Color.green(tinyCracks); //bu bir renk elemani bu kadar basit
                B=255 - Color.blue(tinyCracks); //bu bir renk elemani bu kadar basit
                A=Color.alpha(tinyCracks);          //toplamda Color yapar

                skeleton.setPixel(ifor,jfor,Color.argb(A,R,G,B));
            }
        }
        return skeleton;
    }
    public void onClickMtd2P013(View view) {
        LayerDrawable layerDrawable=pasteTwoDrawableBitmapMtd();
        ImageView imageView_bottomright= (ImageView)findViewById(R.id.imageView_bottomright);
        imageView_bottomright.setImageDrawable(layerDrawable);
    }
    private LayerDrawable pasteTwoDrawableBitmapMtd() {

        Drawable[] drawableDizi=new Drawable[2];
        drawableDizi[0]=getResources().getDrawable(R.drawable.icon_top);
        drawableDizi[1]=getResources().getDrawable(R.drawable.icon_bottom);

        LayerDrawable layerDrawable=new LayerDrawable(drawableDizi);
        return layerDrawable;
    }
}

















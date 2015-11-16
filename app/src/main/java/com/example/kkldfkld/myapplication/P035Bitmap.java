package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.Toast;


public class P035Bitmap extends Activity implements ImageView.OnClickListener{

    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout =new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        ImageView imageView=new ImageView(this);
        imageView.setImageResource(R.drawable.icon_cheltenham);

        button=new Button(this);
        button.setId(1245);

        ImageView imageView2=new ImageView(this);

        linearLayout.addView(imageView);
        linearLayout.addView(button);
        linearLayout.addView(imageView2);
        setContentView(linearLayout);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==button.getId()){
            Toast.makeText(this,"yakalandi",Toast.LENGTH_SHORT).show();
        }
    }
}

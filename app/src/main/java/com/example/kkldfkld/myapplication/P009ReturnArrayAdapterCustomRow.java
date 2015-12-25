package com.example.kkldfkld.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

public class P009ReturnArrayAdapterCustomRow extends ArrayAdapter<String> {


    public P009ReturnArrayAdapterCustomRow(Context context, String[] resource) {
        super(context,R.layout.p009returnarrayadaptercustomrow ,resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=LayoutInflater.from(getContext());
        View viewElde= layoutInflater.inflate(R.layout.p009returnarrayadaptercustomrow, parent, false);

        TextView textViewP009= (TextView)viewElde.findViewById(R.id.textViewP009);
        ImageView imageViewP009= (ImageView)viewElde.findViewById(R.id.imageViewP009);

        String teamName= getItem(position);  //dikkat getItem() metodu ne buyuk bir nimet GOR
        textViewP009.setText(teamName);

        switch(teamName) {
            case "Alfreton":
                imageViewP009.setImageResource(R.drawable.icon_alfreton);
                break;
            case "Braintree":
                imageViewP009.setImageResource(R.drawable.icon_braintree);
                break;
            case "Cheltenham":
                imageViewP009.setImageResource(R.drawable.icon_cheltenham);
                break;
            case "Coventry":
                imageViewP009.setImageResource(R.drawable.icon_coventry);
                break;
            case "Crawley":
                imageViewP009.setImageResource(R.drawable.icon_crawley);
                break;
            case "Fleetwood":
                imageViewP009.setImageResource(R.drawable.icon_fleetwood);
                break;
            case "Grimsby":
                imageViewP009.setImageResource(R.drawable.icon_grimsby);
                break;
            case "Huddersfield":
                imageViewP009.setImageResource(R.drawable.icon_huddersfield);
                break;
            case "Hull":
                imageViewP009.setImageResource(R.drawable.icon_hull);
                break;
            case "Manchester":
                imageViewP009.setImageResource(R.drawable.icon_manchester);
                break;
        }

        return viewElde;
    }
}

































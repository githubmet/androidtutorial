package com.example.kkldfkld.myapplication;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.EditText;
import android.widget.TextView;


public class P030TeaspoonConversion extends ActionBarActivity {
    private Spinner spinnerUnitType;
    private EditText editTextAmount;

    TextView textViewTeaspoon,textViewCups,textViewTbs,textViewOz,textViewKg,textViewQuart,textViewGallon,
            textViewPound,textViewMl,textViewLiter,textViewMg,textViewPint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p030teaspoonconversion);

        addItemsToUnitSpinner();
        addListenerToUnitTypeSpinner();
        editTextAmount=(EditText)findViewById(R.id.editTextAmountP030);
        initializeTextViews();
    }

    private void initializeTextViews() {
        textViewTeaspoon= (TextView)findViewById(R.id.tsp_text_view);
        textViewCups= (TextView)findViewById(R.id.cup_text_view);
        textViewTbs= (TextView)findViewById(R.id.tbs_text_view);
        textViewOz= (TextView)findViewById(R.id.oz_text_view);
        textViewKg= (TextView)findViewById(R.id.kg_text_view);
        textViewQuart= (TextView)findViewById(R.id.quart_text_view);
        textViewGallon= (TextView)findViewById(R.id.gallon_text_view);
        textViewPound= (TextView)findViewById(R.id.pound_text_view);
        textViewMl= (TextView)findViewById(R.id.ml_text_view);
        textViewLiter= (TextView)findViewById(R.id.liter_text_view);
        textViewMg= (TextView)findViewById(R.id.mg_text_view);
        textViewPint= (TextView)findViewById(R.id.pint_text_view);

    }

    private void addItemsToUnitSpinner() {
        spinnerUnitType=(Spinner)findViewById(R.id.spinnerUnitTypeP030);
        //bunu values dosyasinda biz olusturduk   //en son parametre isedefault kalip
        ArrayAdapter<CharSequence> spinnerAdapter=ArrayAdapter.createFromResource(this,R.array.concersion_types,android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUnitType.setAdapter(spinnerAdapter);
    }

    private void addListenerToUnitTypeSpinner() {
        spinnerUnitType = (Spinner) findViewById(R.id.spinnerUnitTypeP030);

        spinnerUnitType.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String itemSelectedSpinner = parent.getItemAtPosition(position).toString();
                        checkIfConvertingFromTsp(itemSelectedSpinner);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
    }

        public void checkIfConvertingFromTsp(String currentUnit){
        if(currentUnit.equals("teaspoon")){
            updateUnitTypeUsingTsp(P030TeaspoonQuantity.Unit.tsp); //neden static oldugunu simdi anladin mi
        }
            else{
            if(currentUnit.equals("tablespoon")){
                updateUnitTypeUsingOther(P030TeaspoonQuantity.Unit.tbs);
            }
            else if(currentUnit.equals("cup")){
                updateUnitTypeUsingOther(P030TeaspoonQuantity.Unit.cup);
            }
            else if(currentUnit.equals("ounce")){
                updateUnitTypeUsingOther(P030TeaspoonQuantity.Unit.oz);
            }
            else if(currentUnit.equals("pint")){
                updateUnitTypeUsingOther(P030TeaspoonQuantity.Unit.pint);
            }
            else if(currentUnit.equals("milligram")){
                updateUnitTypeUsingOther(P030TeaspoonQuantity.Unit.mg);
            }
            else if(currentUnit.equals("liter")){
                updateUnitTypeUsingOther(P030TeaspoonQuantity.Unit.liter);
            }
            else if(currentUnit.equals("milliliter")){
                updateUnitTypeUsingOther(P030TeaspoonQuantity.Unit.ml);
            }
            else if(currentUnit.equals("pound")){
                updateUnitTypeUsingOther(P030TeaspoonQuantity.Unit.pound);
            }
            else if(currentUnit.equals("gallon")){
                updateUnitTypeUsingOther(P030TeaspoonQuantity.Unit.gallon);
            }
            else if(currentUnit.equals("quart")){
                updateUnitTypeUsingOther(P030TeaspoonQuantity.Unit.quart);
            }
            else{
                updateUnitTypeUsingOther(P030TeaspoonQuantity.Unit.kg);
            }
        }
    }

    private void updateUnitTypeUsingTsp(P030TeaspoonQuantity.Unit currentUnit) {
        double doubleToConvert=Double.parseDouble(editTextAmount.getText().toString());
        String teaspoonValueAndUnit= doubleToConvert+" tsp";

        textViewTeaspoon.setText(teaspoonValueAndUnit);

        updateUnitTextFieldUsingTsp(doubleToConvert, P030TeaspoonQuantity.Unit.tbs, textViewTbs);
        updateUnitTextFieldUsingTsp(doubleToConvert,P030TeaspoonQuantity.Unit.cup,textViewCups);
        updateUnitTextFieldUsingTsp(doubleToConvert,P030TeaspoonQuantity.Unit.oz,textViewOz);
        updateUnitTextFieldUsingTsp(doubleToConvert,P030TeaspoonQuantity.Unit.pint,textViewPint);
        updateUnitTextFieldUsingTsp(doubleToConvert,P030TeaspoonQuantity.Unit.quart,textViewQuart);
        updateUnitTextFieldUsingTsp(doubleToConvert,P030TeaspoonQuantity.Unit.gallon,textViewGallon);
        updateUnitTextFieldUsingTsp(doubleToConvert,P030TeaspoonQuantity.Unit.pound,textViewPound);
        updateUnitTextFieldUsingTsp(doubleToConvert,P030TeaspoonQuantity.Unit.ml,textViewMl);
        updateUnitTextFieldUsingTsp(doubleToConvert,P030TeaspoonQuantity.Unit.liter,textViewLiter);
        updateUnitTextFieldUsingTsp(doubleToConvert,P030TeaspoonQuantity.Unit.mg,textViewMg);
        updateUnitTextFieldUsingTsp(doubleToConvert,P030TeaspoonQuantity.Unit.kg,textViewKg);
    }

    private void updateUnitTextFieldUsingTsp(double doubleToConvert, P030TeaspoonQuantity.Unit UnitConvertingTo, TextView ThetextView) {

        P030TeaspoonQuantity p030TeaspoonQuantity=new P030TeaspoonQuantity(doubleToConvert,P030TeaspoonQuantity.Unit.tsp);
        String tempUnit=p030TeaspoonQuantity.to(UnitConvertingTo).toString();
        ThetextView.setText(tempUnit);
    }

    private void updateUnitTypeUsingOther(P030TeaspoonQuantity.Unit currentUnit) {
        double doubleToConvert=Double.parseDouble(editTextAmount.getText().toString());
        P030TeaspoonQuantity p030TeaspoonQuantity=new P030TeaspoonQuantity(doubleToConvert,currentUnit); //aslinda bu objeye currentQuantitySelected adi vermelisin
        String valueInTeaspoon=p030TeaspoonQuantity.to(P030TeaspoonQuantity.Unit.tsp).toString();
        textViewTeaspoon.setText(valueInTeaspoon);


        updateUnitTextFieldUsingTsp222(doubleToConvert, currentUnit, P030TeaspoonQuantity.Unit.tbs, textViewTbs);
        updateUnitTextFieldUsingTsp222(doubleToConvert, currentUnit, P030TeaspoonQuantity.Unit.cup, textViewCups);
        updateUnitTextFieldUsingTsp222(doubleToConvert, currentUnit, P030TeaspoonQuantity.Unit.oz, textViewOz);
        updateUnitTextFieldUsingTsp222(doubleToConvert, currentUnit, P030TeaspoonQuantity.Unit.pint, textViewPint);
        updateUnitTextFieldUsingTsp222(doubleToConvert, currentUnit, P030TeaspoonQuantity.Unit.quart, textViewQuart);
        updateUnitTextFieldUsingTsp222(doubleToConvert, currentUnit, P030TeaspoonQuantity.Unit.gallon, textViewGallon);
        updateUnitTextFieldUsingTsp222(doubleToConvert, currentUnit, P030TeaspoonQuantity.Unit.pound, textViewPound);
        updateUnitTextFieldUsingTsp222(doubleToConvert, currentUnit, P030TeaspoonQuantity.Unit.ml, textViewMl);
        updateUnitTextFieldUsingTsp222(doubleToConvert, currentUnit, P030TeaspoonQuantity.Unit.liter, textViewLiter);
        updateUnitTextFieldUsingTsp222(doubleToConvert, currentUnit, P030TeaspoonQuantity.Unit.mg, textViewMg);
        updateUnitTextFieldUsingTsp222(doubleToConvert, currentUnit, P030TeaspoonQuantity.Unit.kg, textViewKg);

        if(currentUnit.name().equals(p030TeaspoonQuantity.unit.name())){

            String currentUnitTextViewText=doubleToConvert+" "+p030TeaspoonQuantity.unit.name();
            String currentTextViewName=p030TeaspoonQuantity.unit.name()+"_text_view";

            int currentId=getResources().getIdentifier(currentTextViewName,"id",P030TeaspoonConversion.this.getPackageName());
            TextView currentTextView=(TextView)findViewById(currentId);
            currentTextView.setText(currentUnitTextViewText);
        }

    }

    private void updateUnitTextFieldUsingTsp222(double doubleToConvert,P030TeaspoonQuantity.Unit currentUnit, P030TeaspoonQuantity.Unit prefferedUnit, TextView targetTextView) {

        P030TeaspoonQuantity currentQuantitySelected=new P030TeaspoonQuantity(doubleToConvert,currentUnit);
        String tempTextViewText= currentQuantitySelected.to( P030TeaspoonQuantity.Unit.tsp).to(prefferedUnit).toString();

        targetTextView.setText(tempTextViewText);
    }

}







































































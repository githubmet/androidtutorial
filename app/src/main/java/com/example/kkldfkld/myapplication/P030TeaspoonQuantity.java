package com.example.kkldfkld.myapplication;


import java.text.DecimalFormat;

public class P030TeaspoonQuantity {

    final double value;
    final Unit unit;

    public static enum Unit{
        tsp(1.0d),tbs(0.3333d),cup(0.0208d),oz(0.1666d),pint(0.0104d),quart(0.0052d),gallon(0.0013),
        pound(0.0125d), ml(4.9289d), liter(0.0049d), mg(5687.5d), kg(0.0057d);

        final static Unit baseUnit=tsp;
        final double byBaseUnit;

        private Unit(double inTsp){
            this.byBaseUnit=inTsp;
        }

        public double toBaseUnit(double value){
            return value/byBaseUnit;
        }
        public double fromBaseUnit(double value){
            return value*byBaseUnit;
        }
    }

    public P030TeaspoonQuantity(double value,Unit unit ){
        super();
        this.value=value;
        this.unit=unit;
    }

    public P030TeaspoonQuantity to(Unit newUnit){
        Unit oldUnit=this.unit;
        return new P030TeaspoonQuantity(newUnit.fromBaseUnit(oldUnit.toBaseUnit(value)),newUnit);
    }
    public String toString(){
        DecimalFormat decimalFormat=new DecimalFormat("#.0000");
        return decimalFormat.format(value)+ " "+unit.name();
    }

}

package com.robson;

/**
 *
 * @author Sara
 */
public class InstrukcjaDzielenie extends Instrukcja{
    public Argument argument1;
    public Argument argument2;
    
    public InstrukcjaDzielenie(double pArg1, double pArg2) {
        super ();
        argument1 = new Argument(pArg1, Instrukcja.TYP_INST_LICZBA);
        argument2 = new Argument(pArg2, Instrukcja.TYP_INST_LICZBA);
    }
    
    @Override
    public void fromInstrukcja(Instrukcja pInstrukcja) {
        this.argument1.fromArgument(((InstrukcjaDzielenie)pInstrukcja).argument1);
        this.argument2.fromArgument(((InstrukcjaDzielenie)pInstrukcja).argument2);
    }
    
    @Override
    public double getValue() {
        double vValue = 0.0;
        if (0 != argument2.wartosc) vValue = argument1.wartosc / argument2.wartosc;
        return vValue;
    }

    @Override
    public String getType() {
        return Instrukcja.TYP_INST_DZIELENIE;
    }
    
    @Override
    public String toJava() {
        return String.format("%f / %f", argument1.wartosc, argument2.wartosc);
    }
}

package com.robson;

/**
 *
 * @author Sara
 */
public class InstrukcjaPlus extends Instrukcja{
    public Argument argument1;
    public Argument argument2;
    
    public InstrukcjaPlus(double pArg1, double pArg2) {
        super ();
        argument1 = new Argument(pArg1, Instrukcja.TYP_INST_LICZBA);
        argument2 = new Argument(pArg2, Instrukcja.TYP_INST_LICZBA);
    }
    
    @Override
    public void fromInstrukcja(Instrukcja pInstrukcja) {
        this.argument1.fromArgument(((InstrukcjaPlus)pInstrukcja).argument1);
        this.argument2.fromArgument(((InstrukcjaPlus)pInstrukcja).argument2);
    }
    
    @Override
    public double getValue() {
        return argument1.wartosc + argument2.wartosc;
    }

    @Override
    public String getType() {
        return Instrukcja.TYP_INST_PLUS;
    }
    
    @Override
    public String toJava() {
        return String.format("%f + %f", argument1.wartosc, argument2.wartosc);
    }
}

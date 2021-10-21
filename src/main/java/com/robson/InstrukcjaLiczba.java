package com.robson;

/**
 *
 * @author Sara
 */
public class InstrukcjaLiczba extends Instrukcja{
    public double wartosc;
    
    public InstrukcjaLiczba(double pWartosc) {
        super ();
        wartosc = pWartosc;
    }
    
    @Override
    public void fromInstrukcja(Instrukcja pInstrukcja) {
        this.wartosc = ((InstrukcjaLiczba)pInstrukcja).wartosc;
    }
    
    @Override
    public double getValue() {
        return this.wartosc;
    }

    @Override
    public String getType() {
        return Instrukcja.TYP_INST_LICZBA;
    }
    
    @Override
    public String toJava() {
        return String.format("%f", this.wartosc);
    }
}

package com.robson;

/**
 *
 * @author Sara
 */
public class Argument {
    public double wartosc;
    public String typ;
    
    public Argument(double pWartosc, String pTyp) {
        this.wartosc = pWartosc;
        this.typ = pTyp;
    }
    
    public void fromArgument(Argument pArgument) {
        this.wartosc = pArgument.wartosc;
        this.typ = pArgument.typ;
    }
}

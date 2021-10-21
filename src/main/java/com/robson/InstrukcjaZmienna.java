package com.robson;

/**
 *
 * @author Sara
 */
public class InstrukcjaZmienna extends Instrukcja{
    public String nazwa;
    
    public InstrukcjaZmienna(String pNazwa) {
        super ();
        nazwa = pNazwa;
    }
    
    @Override
    public void fromInstrukcja(Instrukcja pInstrukcja) {
        this.nazwa = ((InstrukcjaZmienna)pInstrukcja).nazwa;
    }
    
    @Override
    public double getValue() {
        System.out.println("ERROR: In InstrukcjaZmienna in getValue(). Not implemented");
        return 0;
    }

    @Override
    public String getType() {
        return Instrukcja.TYP_INST_ZMIENNA;
    }
    
    @Override
    public String toJava() {
        return String.format("%s", this.nazwa);
    }
}

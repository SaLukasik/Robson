package com.robson;

/**
 *
 * @author Sara
 */
public class InstrukcjaIf extends Instrukcja{
    private BlokInstrukcji blok_prawda;
    private BlokInstrukcji blok_falsz;
    
    public InstrukcjaIf(BlokInstrukcji pBlok_prawda, BlokInstrukcji pBlok_falsz) {
        super ();
        blok_prawda = new BlokInstrukcji(pBlok_prawda);
        blok_falsz = new BlokInstrukcji(pBlok_falsz);
    }
    
    @Override
    public void fromInstrukcja(Instrukcja pInstrukcjaIf) {
        this.blok_prawda.fromBlokInstrukcji(((InstrukcjaIf)pInstrukcjaIf).getBlok_prawda());
        this.blok_falsz.fromBlokInstrukcji(((InstrukcjaIf)pInstrukcjaIf).getBlok_falsz());
    }
    
    @Override
    public double getValue() {
        return INST_ARYTMETYCZNA_DEF_ARG_VALUE;
    }

    @Override
    public String getType() {
        return Instrukcja.TYP_INST_IF;
    }
    
    @Override
    public String toJava() {
        System.out.println("ERROR: In InstrukcjaIf in toJava() - not implemented");
        return "";
    }

    public BlokInstrukcji getBlok_prawda() {
        return blok_prawda;
    }

    public void setBlok_prawda(BlokInstrukcji blok_prawda) {
        this.blok_prawda.fromBlokInstrukcji(blok_prawda);
    }

    public BlokInstrukcji getBlok_falsz() {
        return blok_falsz;
    }

    public void setBlok_falsz(BlokInstrukcji blok_falsz) {
        this.blok_falsz.fromBlokInstrukcji(blok_falsz);
    }
}

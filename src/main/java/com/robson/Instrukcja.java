package com.robson;

/**
 *
 * @author Sara
 */
public abstract class Instrukcja {
    public static final String TYP_INST = "typ";
    public static final String TYP_INST_INSTRUKCJA = "Instrukcja";
    public static final String TYP_INST_BLOK = "Blok";
    public static final String TYP_INST_IF = "If";
    public static final String TYP_INST_PLUS = "Plus";
    public static final String TYP_INST_MINUS = "Minus";
    public static final String TYP_INST_RAZY = "Razy";
    public static final String TYP_INST_DZIELENIE = "Dzielenie";
    public static final String TYP_INST_LICZBA = "Liczba";
    public static final String TYP_INST_ZMIENNA = "Zmienna";
    
    //Default 
    public static final double INST_ARYTMETYCZNA_DEF_ARG_VALUE = 0.0;
    public static final String INST_ZMIENNA_DEF_NAME = "zmienna_def_name";
    
  
    
    public Instrukcja() {
    }
    
    public abstract void fromInstrukcja(Instrukcja pInstrukcja);
    public abstract double getValue();
    public abstract String getType();
    public abstract String toJava();
}

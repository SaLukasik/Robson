package com.robson;

/**
 *
 * @author Sara
 */
public class InstrukcjaFactory {
    private static final InstrukcjaFactory _instance = new InstrukcjaFactory();
    
    private InstrukcjaFactory(){};
    
    public static InstrukcjaFactory getInstance() {
        return _instance;
    }
    
    public Instrukcja getInstrukcja(String pInstrukcjaTypeStr) {
        Instrukcja vInstrukcja = null;
        if (RobsonHelper.isStringNotNullAndNotEmpty(pInstrukcjaTypeStr)) {
            switch (pInstrukcjaTypeStr) {
                case Instrukcja.TYP_INST_PLUS: vInstrukcja = new InstrukcjaPlus(Instrukcja.INST_ARYTMETYCZNA_DEF_ARG_VALUE, Instrukcja.INST_ARYTMETYCZNA_DEF_ARG_VALUE); break;
                case Instrukcja.TYP_INST_MINUS: vInstrukcja = new InstrukcjaMinus(Instrukcja.INST_ARYTMETYCZNA_DEF_ARG_VALUE, Instrukcja.INST_ARYTMETYCZNA_DEF_ARG_VALUE); break;
                case Instrukcja.TYP_INST_RAZY: vInstrukcja = new InstrukcjaRazy(Instrukcja.INST_ARYTMETYCZNA_DEF_ARG_VALUE, Instrukcja.INST_ARYTMETYCZNA_DEF_ARG_VALUE); break;
                case Instrukcja.TYP_INST_DZIELENIE: vInstrukcja = new InstrukcjaDzielenie(Instrukcja.INST_ARYTMETYCZNA_DEF_ARG_VALUE, Instrukcja.INST_ARYTMETYCZNA_DEF_ARG_VALUE); break;
                case Instrukcja.TYP_INST_LICZBA: vInstrukcja = new InstrukcjaLiczba(Instrukcja.INST_ARYTMETYCZNA_DEF_ARG_VALUE); break;
                case Instrukcja.TYP_INST_ZMIENNA: vInstrukcja = new InstrukcjaZmienna(Instrukcja.INST_ZMIENNA_DEF_NAME); break;
                default: System.out.println("ERROR: Unknown Instrukcja type string: " + pInstrukcjaTypeStr); break;
            }
        }
        else System.out.println("ERROR: In InstrukcjaFactory in getInstrukcja(). pInstrukcjaTypeStr is empty or null");
        return vInstrukcja;
    }
}

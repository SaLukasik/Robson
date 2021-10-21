package com.robson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Sara
 */
public class Robson {
    public String typ;
    public List <Instrukcja> instrukcje; 
    
    public Robson() {
        typ = Instrukcja.TYP_INST_BLOK;
        instrukcje = new ArrayList<>(); 
        instrukcje.add(new InstrukcjaPlus(2.0, 5.0));
        instrukcje.add(new InstrukcjaMinus(7.0, 8.0));
    }
    
    void fromRobson(Robson pRobson) {
        if (null != pRobson) {
            this.typ = pRobson.typ;
            instrukcje.clear();
            Iterator vIt;
            vIt = pRobson.instrukcje.iterator();
            while (vIt.hasNext()) {
                Instrukcja vInstrukcja = (Instrukcja)vIt.next();
                String vType = vInstrukcja.getType();
                this.instrukcje.add(InstrukcjaFactory.getInstance().getInstrukcja(vType));
            }
        }
        else System.out.println("ERROR: In Robson in fromRobson(). pRobson is null");
        
    }
    
    public void fromJSON(String pFilePathAndName) throws InvalidProgramException {
        try {
            Robson vRobson = this.getGson().fromJson(RobsonHelper.fileToString(pFilePathAndName), Robson.class);
            this.fromRobson(vRobson);
        }
        catch (Exception ex) {
            throw new InvalidProgramException(ex.getMessage());
        }
    }
    
    private Gson getGson() {
        RuntimeTypeAdapterFactory<Instrukcja> instrukcjaAdapterFactory = RuntimeTypeAdapterFactory.of(Instrukcja.class, Instrukcja.TYP_INST);
        instrukcjaAdapterFactory.registerSubtype(InstrukcjaPlus.class, Instrukcja.TYP_INST_PLUS);
        instrukcjaAdapterFactory.registerSubtype(InstrukcjaMinus.class, Instrukcja.TYP_INST_MINUS);
        instrukcjaAdapterFactory.registerSubtype(InstrukcjaRazy.class, Instrukcja.TYP_INST_RAZY);
        instrukcjaAdapterFactory.registerSubtype(InstrukcjaDzielenie.class, Instrukcja.TYP_INST_DZIELENIE);
        instrukcjaAdapterFactory.registerSubtype(InstrukcjaLiczba.class, Instrukcja.TYP_INST_LICZBA);
        instrukcjaAdapterFactory.registerSubtype(InstrukcjaZmienna.class, Instrukcja.TYP_INST_ZMIENNA);
        Gson vGson = new GsonBuilder()
        .registerTypeAdapterFactory(instrukcjaAdapterFactory)
        .setPrettyPrinting()
        .create();
        return vGson;
    }
    
    public void toJSON(String pFilePathAndName) {
        String vJsonStr = this.getGson().toJson(this);
        String vErrorStr = RobsonHelper.stringToFile(vJsonStr, pFilePathAndName);
        if (0 < vErrorStr.length()) System.out.println("ERROR: In toJSON()." + vErrorStr);
    }
    
    public void toJava(String pFilePathAndName) throws ExecutionErrorException {
        System.out.println("ERROR: fromJSON not implemented");
    }
}

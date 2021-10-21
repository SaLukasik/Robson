package com.robson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Sara
 */
public class BlokInstrukcji {
    private List <Instrukcja> instrukcje;
    private String typ;
    
    public BlokInstrukcji() {
        this.typ = Instrukcja.TYP_INST_BLOK;
        instrukcje = new ArrayList<>(); 
    }

    public BlokInstrukcji(BlokInstrukcji pBlockInstrukcji) {
        this.typ = Instrukcja.TYP_INST_BLOK;
        instrukcje = new ArrayList<>(); 
        this.fromBlokInstrukcji(pBlockInstrukcji);
    }
    
    public final void fromBlokInstrukcji(BlokInstrukcji pBlockInstrukcji) {
        if (null != pBlockInstrukcji) {
            this.typ = pBlockInstrukcji.typ;
            this.instrukcje.clear();
            this.setInstrukcje(pBlockInstrukcji.getInstrukcje());
        }
        else System.out.println("ERROR: In BlockInstrukcji in fromBlokInstrukcji(). pBlockInstrukcji is null");
    }

    public List <Instrukcja> getInstrukcje() {
        return instrukcje;
    }

    public void setInstrukcje(List <Instrukcja> pInstrukcje) {
        this.instrukcje.clear();
        if (null != pInstrukcje) {
            Iterator vIt = pInstrukcje.iterator();
            while (vIt.hasNext()) {
                Instrukcja vInstrukcja = (Instrukcja)vIt.next();
                this.instrukcje.add(vInstrukcja);
            }
        }
        else System.out.println("ERROR: In BlockInstrukcji in setInstrukcje(). instrukcje is null");
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
}

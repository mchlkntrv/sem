package itemy;

import hra.*;

import javax.swing.*;
import java.util.*;

public class Inventar<E extends Predmet> implements InvPocuvac {
    private Predmet[] predmetyInv;
    private Predmet aktivnyPredmet;
    private InvPocuvac pocuvac;
    public Inventar() {
        this.predmetyInv = new Predmet[8];
        Arrays.fill(this.predmetyInv, null);
        this.aktivnyPredmet = null;
    }

    public void setAktivnyPredmet(Predmet aktivnyPredmet) {
        this.aktivnyPredmet = aktivnyPredmet;
    }

    public void addPredmet(Predmet predmet) {
        if (this.jeMiesto()) {
            for (int i = 0; i < this.predmetyInv.length; i++) {
                if (this.predmetyInv[i] == null) {
                    this.predmetyInv[i] = predmet;
                    break;
                }
            }
            this.upozorniPocuvac();
        } else {
//            JOptionPane.showMessageDialog(Mapa, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }



    }

    public void upozorniPocuvac() {
        if (this.pocuvac != null) {
            this.pocuvac.zmenaInv(this);
        }
    }

    public void setListener(InvPocuvac pocuvac) {
        this.pocuvac = pocuvac;
    }

    public boolean jeMiesto() {
        for (Predmet predmet : this.predmetyInv) {
            if (predmet == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void zmenaInv(Inventar inv) {

    }
}

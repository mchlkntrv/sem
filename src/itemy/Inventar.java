package itemy;
import java.util.*;

public class Inventar implements InvPocuvac {
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

    public Predmet getAktivnyPredmet() {
        return this.aktivnyPredmet;
    }

    public Predmet getPredmet(int i) {
        return this.predmetyInv[i];
    }

    public Predmet[] getPredmetyInv() {
        return Arrays.copyOf(this.predmetyInv, this.predmetyInv.length);
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

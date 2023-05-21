package itemy;
import java.util.Arrays;
import hra.Mapa;
import tiles.*;

public class Inventar {
    private Predmet[] predmetyInv;
    private Predmet aktivnyPredmet;

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

    public void removePredmet(Predmet predmet) {
        for (int i = 0; i < this.predmetyInv.length; i++) {
            if (this.predmetyInv[i] == predmet) {
                this.predmetyInv[i] = null;
            }
        }
    }

    public void addNovyPredmet(Predmet predmet) {
        if (!this.jeMiesto()) {
            return;
        }

        for (int i = 0; i < this.predmetyInv.length; i++) {
            if (this.predmetyInv[i] == null || this.predmetyInv[i].getNazov().equals(predmet.getNazov())) {
                GameTile tile = Mapa.getInstance().getPolicka()[i];
                if (tile instanceof InvTile) {
                    ((InvTile)tile).setPredmet(predmet);
                    int prvyPocet = predmet.getPocet();
                    int druhyPocet = this.predmetyInv[i] != null ? this.predmetyInv[i].getPocet() : 0;
                    String overlayTlacitka = predmet.getNazov();
                    if (predmet instanceof Crop) {
                        overlayTlacitka += (((Crop)predmet).getAktFaza() + 1);
                    }
                    Mapa.getInstance().getPolicka()[i].getTlacitko().setOverlayTlacitka(String.valueOf(prvyPocet + druhyPocet), overlayTlacitka);
                    this.predmetyInv[i] = predmet;
                    Mapa.getInstance().setPolicko(tile, i);
                    break;
                }
            }
        }
    }
    public boolean jeMiesto() {
        for (Predmet predmet : this.predmetyInv) {
            if (predmet == null) {
                return true;
            }
        }
        return false;
    }
}

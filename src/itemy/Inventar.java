package itemy;

public class Inventar {
    private Predmet[] predmetyInv;
    private Predmet aktivnyPredmet;

    public Inventar() {
        this.predmetyInv = new Predmet[8];
        for (int i = 0; i < this.predmetyInv.length; i++) {
            this.predmetyInv[i] = null;
        }
        this.aktivnyPredmet = null;
    }

    public void setAktivnyPredmet(Predmet aktivnyPredmet) {
        this.aktivnyPredmet = aktivnyPredmet;
    }
}

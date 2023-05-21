package hra;
import itemy.CviklaSeed;
import itemy.Krhla;
import itemy.KukuricaSeed;
import itemy.Ryl;

public class Hra {
    private Hrac hrac;
    private Mapa mapa;
    public Hra() {
        this.hrac = Hrac.getInstance();
        this.hrac.pridajPredmetDoInv(new Krhla());
        this.hrac.pridajPredmetDoInv(new Ryl());
        this.hrac.pridajPredmetDoInv(new KukuricaSeed(2));
        this.hrac.pridajPredmetDoInv(new CviklaSeed(1));

        this.mapa = Mapa.getInstance();
    }
}

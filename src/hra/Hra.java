package hra;

import itemy.Krhla;
import itemy.Kukurica;
import itemy.Ryl;

public class Hra {
    private Hrac hrac;
    private Mapa mapa;
    public Hra() {
        this.hrac = Hrac.getInstance();
        this.hrac.pridajPredmetDoInv(new Krhla());
        this.hrac.pridajPredmetDoInv(new Ryl());
        this.hrac.pridajPredmetDoInv(new Kukurica(5));

        this.mapa = Mapa.getInstance();
    }
}

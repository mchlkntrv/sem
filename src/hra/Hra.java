package hra;

import itemy.Krhla;

public class Hra {
    private Hrac hrac;
    private Mapa mapa;
    public Hra() {
        this.hrac = Hrac.getInstance("Michaela");
        this.hrac.pridajPredmetDoInv(new Krhla());
        this.hrac.pridajPredmetDoInv(new Krhla());

        this.mapa = new Mapa(this.hrac);
    }
}

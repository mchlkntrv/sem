package hra;

import itemy.*;

public class Hra {
    private Hrac hrac;
    private Mapa mapa;
    public Hra() {
        this.hrac = new Hrac("Michaela");
        this.mapa = new Mapa(this.hrac);
        this.hrac.getInventar().setListener(this.mapa);
        this.hrac.pridajPredmetDoInv(new Predmet("krhlaempty"));
    }
}

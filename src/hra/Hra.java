package hra;

import itemy.*;

public class Hra {
    private Hrac hrac;
    private Mapa mapa;
    public Hra() {
        this.hrac = Hrac.getInstance("Michaela");
        this.hrac.pridajPredmetDoInv(new Krhla());
        this.hrac.pridajPredmetDoInv(new Krhla());
        this.hrac.pridajPredmetDoInv(new Ryl());

        this.mapa = Mapa.getInstance();
    }
}

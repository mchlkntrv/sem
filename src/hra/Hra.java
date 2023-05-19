package hra;

import itemy.*;

public class Hra {
    private Mapa mapa;
    public Hra() {
        Hrac.StaticHrac staticHrac = new Hrac.StaticHrac("Michaela");
        staticHrac.pridajPredmetDoInv(new Krhla());
        staticHrac.pridajPredmetDoInv(new Krhla());
        staticHrac.getInventar().setListener(this.mapa);

    }
}

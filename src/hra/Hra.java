package hra;

import javax.swing.*;

public class Hra {
    private Hrac hrac;
    private Mapa mapa;
    public Hra() {
        this.hrac = new Hrac("Michaela");
        this.mapa = new Mapa(this.hrac);

    }
}

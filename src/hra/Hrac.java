package hra;

import itemy.*;

public class Hrac {
    private String meno;
    private Inventar inventarHraca;
    private int peniaze;

    public Hrac(String meno) {
        this.peniaze = 50;
        this.meno = meno;
        this.inventarHraca = new Inventar();
    }
    public String getMeno() {
        return this.meno;
    }

    public int getPeniaze() {
        return this.peniaze;
    }

    public Inventar getInventar() {
        return this.inventarHraca;
    }

    public void pridajPredmetDoInv(Predmet predmet) {
        this.inventarHraca.addPredmet(predmet);

    }
}

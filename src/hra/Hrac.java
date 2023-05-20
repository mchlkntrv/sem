package hra;

import itemy.Inventar;
import itemy.Predmet;

public class Hrac {
    private static Hrac instanceHrac;
    private Inventar inventarHraca;
    private int peniaze;

    private Hrac() {
        this.peniaze = 50;
        this.inventarHraca = new Inventar();
    }

    public static Hrac getInstance() {
        if (Hrac.instanceHrac == null) {
            Hrac.instanceHrac = new Hrac();
        }
        return Hrac.instanceHrac;
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

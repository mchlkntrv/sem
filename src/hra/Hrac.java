package hra;

import itemy.Inventar;
import itemy.Predmet;

public class Hrac {
    private static Hrac instanceHrac;
    private static String meno;
    private static Inventar inventarHraca;
    private static int peniaze;

    private Hrac(String meno) {
        this.peniaze = 50;
        this.meno = meno;
        inventarHraca = new Inventar();
    }

    public static Hrac getInstance(String meno) {
        if (Hrac.instanceHrac == null) {
            Hrac.instanceHrac = new Hrac(meno);
        }
        return Hrac.instanceHrac;
    }

    public static String getMeno() {
        return meno;
    }

    public int getPeniaze() {
        return this.peniaze;
    }

    public static Inventar getInventar() {
        return inventarHraca;
    }

    public void pridajPredmetDoInv(Predmet predmet) {
        inventarHraca.addPredmet(predmet);
    }
}

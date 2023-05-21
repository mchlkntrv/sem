package hra;

import itemy.Inventar;
import itemy.Predmet;

public class Hrac {
    private static Hrac instanceHrac;
    private Inventar inventarHraca;
    private int peniaze;
    private final int fullEnergia = 100;
    private int aktEnergia;


    private Hrac() {
        this.peniaze = 50;
        this.inventarHraca = new Inventar();
        this.aktEnergia = this.fullEnergia;
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
//        this.inventarHraca.addPredmet(predmet);
        this.inventarHraca.addNovyPredmet(predmet);
    }

    public String getEnergiaStringStav() {
        return "Energia: " + this.aktEnergia + "/" + this.fullEnergia;
    }

    public void pridajEnergiu(int energia) {
        this.aktEnergia += energia;
        Mapa.getInstance().setEnergiaText();
    }

    public void urobilCinnost(int minulEnerg) {
        this.aktEnergia -= minulEnerg;
        Mapa.getInstance().setEnergiaText();
    }

    public boolean mozeUrobitCinnost() {
        return this.aktEnergia >= 15;
    }

    public int getAktEnergia() {
        return this.aktEnergia;
    }

    public void setEnergia(int i) {
        this.aktEnergia = i;
    }
}

package hra;

public class Hra {
    private Hrac hrac;
    private Mapa mapa;
    public Hra() {
        this.hrac = new Hrac();
        this.mapa = new Mapa(this.hrac);
    }
}

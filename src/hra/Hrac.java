package hra;

import itemy.*;

public class Hrac {
    private String meno;
    private Inventar inventarHraca;

    public Hrac(String meno) {
        this.meno = meno;
        this.inventarHraca = new Inventar();
    }
    public String getMeno() {
        return this.meno;
    }
}

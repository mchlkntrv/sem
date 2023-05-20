package itemy;

import hra.Hrac;
import hra.Mapa;
import tiles.GameTile;
import tiles.InvTile;

public abstract class Crop implements Predmet {
    private int aktFaza;
    private int pocet;
    private int maxFaza;
    private String nazov;
    public Crop(String nazov, int maxFaza, int pocet) {
        this.nazov = nazov;
        this.aktFaza = 0;
        this.pocet = pocet;
        this.maxFaza = maxFaza;
    }

    @Override
    public int getPocet() {
        return this.pocet;
    }

    @Override
    public String getNazov() {
        return this.nazov;
    }

    public void zasad() {
        this.pocet--;

        for (GameTile tile : Mapa.getInstance().getPolicka()) {
            if (tile instanceof InvTile) {
                InvTile invTile = (InvTile)tile;
                if (invTile.getPredmet() == Hrac.getInstance().getInventar().getAktivnyPredmet()) {
                    String text = this.getNazov();
                    String pocetStr = String.valueOf(this.pocet);
                    invTile.getTlacitko().setOverlayTlacitka(pocetStr, text);
                }
            }
        }
    }
}

package itemy;

import hra.Hrac;
import hra.Mapa;
import tiles.GameTile;
import tiles.SoilTile;
import tiles.InvTile;

public abstract class CropSeed implements Predmet {
    private int pocet;
    private String nazov;
    private Crop crop;
    public CropSeed(String nazov, int pocet) {
        this.nazov = nazov;
        this.pocet = pocet;
    }

    @Override
    public int getPocet() {
        return this.pocet;
    }

    @Override
    public void setPocet(int pocet) {
        this.pocet = pocet;
    }

    @Override
    public String getNazov() {
        return this.nazov;
    }

    public void zasad(SoilTile soilTile) {
        if (this.pocet > 1) {
            this.pocet--;
            for (GameTile tile : Mapa.getInstance().getPolicka()) {
                if (tile instanceof InvTile) {
                    InvTile invTile = (InvTile)tile;
                    if (invTile.getPredmet() == Hrac.getInstance().getInventar().getAktivnyPredmet()) {
                        String text = this.getNazov();
                        String pocetStr = String.valueOf(this.pocet);
                        invTile.getTlacitko().setOverlayTlacitka(pocetStr, text);
//                        soilTile.getTlacitko().setOverlayTlacitka(null, soilTile.getRastlina().getNazov());
                    }
                }
            }
        } else if (this.pocet == 1) {
            this.pocet--;
            for (GameTile tile : Mapa.getInstance().getPolicka()) {
                if (tile instanceof InvTile) {
                    InvTile invTile = (InvTile)tile;
                    if (invTile.getPredmet() == Hrac.getInstance().getInventar().getAktivnyPredmet()) {
//                        Mapa.getInstance().setPolicko(null, invTile.getStlpec() - 1);
                        invTile.getTlacitko().setOverlayTlacitka(null, null);
                        invTile.setPredmet(null);
                        Hrac.getInstance().getInventar().removePredmet(Hrac.getInstance().getInventar().getAktivnyPredmet());
                        Hrac.getInstance().getInventar().setAktivnyPredmet(null);
                    }
                }
            }
        }
    }
}

package itemy;

import hra.Hrac;
import hra.Mapa;
import tiles.GameTile;
import tiles.InvTile;

public class Krhla extends Naradie {
    private int mnozstvoVody;
    private final int pocet = 1;
    public Krhla() {
        super("krhlaempty", 5, 20);
        this.mnozstvoVody = 0;
    }

    public void naplnKrhlu() {
        this.mnozstvoVody = 2;
        Mapa.getInstance().setTerminalText("Nabral si vodu.");
    }

    public void pouziKrhlu() {
        this.mnozstvoVody--;
        for (GameTile tile : Mapa.getInstance().getPolicka()) {
            if (tile instanceof InvTile) {
                InvTile invTile = (InvTile)tile;
                if (invTile.getPredmet() == Hrac.getInstance().getInventar().getAktivnyPredmet()) {
                    String text = this.getNazov();
                    invTile.getTlacitko().setOverlayTlacitka("1", text);
                }
            }
        }
    }

    @Override
    public String getNazov() {
        return switch (this.mnozstvoVody) {
            case 0 -> "krhlaempty";
            case 1 -> "krhlahalf";
            case 2 -> "krhlafull";
            default -> "krhla";
        };
    }

    public int getMnozstvoVody() {
        return this.mnozstvoVody;
    }

    @Override
    public int getPocet() {
        return this.pocet;
    }

    @Override
    public void setPocet(int i) {

    }

    @Override
    public int getCena() {
        return 0;
    }

}

package tiles;
import hra.Hrac;
import hra.Mapa;
import itemy.*;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class SoilTile extends GameTile {
    private boolean zaliata;
    private boolean zasadena;
    private boolean dnesZaliata;
    private Crop rastlina;
    public SoilTile(int riadok, int stlpec) {
        super(riadok, stlpec, new TileButton("rylnezaliate.png"));
        this.zaliata = false;
        this.dnesZaliata = false;
    }

    public boolean getDnesZaliata() {
        return this.dnesZaliata;
    }

    public void setDnesZaliata(boolean b) {
        this.dnesZaliata = b;
    }

    @Override
    public void onClickLeft() {
        super.onClickLeft();
    }

    @Override
    public void onClickRight() {
        super.onClickRight();
    }

    @Override
    public TileButton getTlacitko() {
        TileButton tlacitko = super.getTlacitko();
        tlacitko.setComponentPopupMenu(this.createPopupMenu());
        return tlacitko;
    }

    public void setZaliata(boolean zaliata) {
        this.zaliata = zaliata;
        if (zaliata) {
            this.setObrazokTlacitka("rylzaliate");
        } else {
            this.setObrazokTlacitka("rylnezaliate");
        }
    }

    public Crop getRastlina() {
        return this.rastlina;
    }

    public JPopupMenu popupZaliatie() {
        JPopupMenu moznostiKliknutia = new JPopupMenu();
        JMenuItem moznost1 = new JMenuItem("Zalej");
        moznost1.addActionListener(e -> {
            Predmet predmet = Hrac.getInstance().getInventar().getAktivnyPredmet();
            if (predmet instanceof Krhla && ((Krhla)predmet).getMnozstvoVody() > 0) {
                if (Hrac.getInstance().mozeUrobitCinnost()) {
                    ((Krhla)Hrac.getInstance().getInventar().getAktivnyPredmet()).pouziKrhlu();
                    this.setZaliata(true);
                    Mapa.getInstance().setTerminalText("Zalial si pôdu!");

                    if (SoilTile.this.getRastlina() == null) {
                        super.setMoznostiKliknutia(this.popupMozeSadit());
                    } else if (SoilTile.this.getRastlina().getIsGrown()) {
                        super.setMoznostiKliknutia(this.popupZber());
                    }

                    Hrac.getInstance().urobilCinnost(5);
                    SoilTile.this.setDnesZaliata(true);
                } else {
                    Mapa.getInstance().setTerminalText("Nemáš dostatok energie! Vyspi sa.");
                }
            } else if (predmet instanceof Krhla && ((Krhla)predmet).getMnozstvoVody() == 0) {
                Mapa.getInstance().setTerminalText("V krhle nemáš vodu.");
            } else {
                Mapa.getInstance().setTerminalText("Kde máš krhlu?");
            }
        });
        moznostiKliknutia.add(moznost1);

        return moznostiKliknutia;
    }

    private JPopupMenu popupZber() {
        JPopupMenu moznostiKliknutia = new JPopupMenu();
        JMenuItem moznost1 = new JMenuItem("Zber.");
        moznost1.addActionListener(e -> {
            Crop crop = SoilTile.this.getRastlina();
            Hrac.getInstance().getInventar().addNovyPredmet(crop);
            Mapa.getInstance().setTerminalText("Dobrá úroda!");
            SoilTile.this.setMoznostiKliknutia(this.popupZaliatie());
            SoilTile.this.removeRastlina();
            SoilTile.this.getTlacitko().setOverlayTlacitka(null, null);
        });
        moznostiKliknutia.add(moznost1);
        return moznostiKliknutia;
    }

    public JPopupMenu popupMozeSadit() {
        JPopupMenu moznostiKliknutia = new JPopupMenu();
        JMenuItem moznost1 = new JMenuItem("Zasad");
        moznost1.addActionListener(e -> {
            Predmet predmet = Hrac.getInstance().getInventar().getAktivnyPredmet();
            if (predmet instanceof CropSeed && predmet.getPocet() > 0) {
                if (Hrac.getInstance().mozeUrobitCinnost()) {
                    this.zaliata = true;
                    SoilTile.this.getTlacitko().setOverlayTlacitka(null, predmet.getNazov());
                    Mapa.getInstance().setTerminalText("Zasadil si semienko!");
                    super.setMoznostiKliknutia(this.popupZaliatie());
                    Hrac.getInstance().urobilCinnost(5);
                    SoilTile.this.vytvorPlodinu(predmet.getNazov());
                    ((CropSeed)Hrac.getInstance().getInventar().getAktivnyPredmet()).zasad(SoilTile.this);
                } else {
                    Mapa.getInstance().setTerminalText("Nemáš dostatok energie! Vyspi sa.");
                }
            }
        });
        moznostiKliknutia.add(moznost1);
        return moznostiKliknutia;
    }

    public void vytvorPlodinu(String menoSeedu) {
        Crop novaRastlina;
        switch (menoSeedu) {
            case "k0":
                novaRastlina = new Kukurica();
                break;
            case "cv0":
                novaRastlina = new Cvikla();
                break;
            case "j0":
                novaRastlina = new Jahoda();
                break;
            default:
                Mapa.getInstance().setTerminalText("Niečo sa pokazilo. :(");
                return;
        }
        this.rastlina = novaRastlina;
    }

    @Override
    public JPopupMenu createPopupMenu() {
        return this.popupZaliatie();
    }

    public void removeRastlina() {
        this.rastlina = null;
    }

    public void changeToGrass() {
        for (int i = 0; i < Mapa.getInstance().getPolicka().length; i++) {
            if (Mapa.getInstance().getPolicka()[i] == SoilTile.this) {
                Mapa.getInstance().getMapa().remove(this.getTlacitko());
                int riadok = this.getRiadok();
                int stlpec = this.getStlpec();
                GrassTile newTile = new GrassTile(riadok, stlpec);
                Mapa.getInstance().setPolicko(newTile, i);
                Mapa.getInstance().getMapa().add(newTile.getTlacitko(), i - 8);
                break;
            }
        }
    }
}
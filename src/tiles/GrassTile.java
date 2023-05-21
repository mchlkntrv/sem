package tiles;
import hra.Hrac;
import hra.Mapa;
import itemy.Ryl;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class GrassTile extends GameTile {
    public GrassTile(int riadok, int stlpec) {
        super(riadok, stlpec, new TileButton("trava.png"));
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
    public int getRiadok() {
        return super.getRiadok();
    }

    @Override
    public int getStlpec() {
        return super.getStlpec();
    }

    @Override
    public JPopupMenu createPopupMenu() {
        JPopupMenu moznostiKliknutia = new JPopupMenu();

        JMenuItem moznost1 = new JMenuItem("Poryluj");
        moznost1.addActionListener(e -> {
            if (Hrac.getInstance().getInventar().getAktivnyPredmet() instanceof Ryl) {
                for (int i = 0; i < Mapa.getInstance().getPolicka().length; i++) {
                    if (Mapa.getInstance().getPolicka()[i] == GrassTile.this) {
                        if (Hrac.getInstance().mozeUrobitCinnost()) {
                            Mapa.getInstance().getMapa().remove(this.getTlacitko());
                            int riadok = this.getRiadok();
                            int stlpec = this.getStlpec();
                            SoilTile newTile = new SoilTile(riadok, stlpec);
                            Mapa.getInstance().setPolicko(newTile, i);
                            Mapa.getInstance().getMapa().add(newTile.getTlacitko(), i - 8);
                            Mapa.getInstance().setTerminalText("Porýľoval si pôdu! Ešte ju musíš zaliať.");
                            Hrac.getInstance().urobilCinnost(15);
                            break;
                        } else {
                            Mapa.getInstance().setTerminalText("Nemáš dostatok energie! Vyspi sa.");
                        }
                    }
                }
            } else {
                Mapa.getInstance().setTerminalText("Na rýľovanie použi rýľ.");
            }
        });

        moznostiKliknutia.add(moznost1);

        JMenuItem moznost2 = new JMenuItem("Ľahni si do trávičky.");
        moznost2.addActionListener(e -> {
            if (Hrac.getInstance().getAktEnergia() <= 98) {
                Hrac.getInstance().pridajEnergiu(2);
                Mapa.getInstance().setTerminalText("Aká mäkká trávička...");
            } else {
                Mapa.getInstance().setTerminalText("Energie máš dosť!");
            }
        });
        moznostiKliknutia.add(moznost2);

        return moznostiKliknutia;
    }
}

package tiles;
import hra.Hrac;
import hra.Mapa;
import itemy.Ryl;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class GrassTile extends GameTile {
    public GrassTile(int riadok, int stlpec) {
        super(riadok, stlpec, new TileButton("trava"));
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
            if (Hrac.getInventar().getAktivnyPredmet() instanceof Ryl) {
                int counter = 0;
                for (GameTile tile : Mapa.getPolicka()) {
                    if (tile == GrassTile.this) {
                        GameTile[] policka = Mapa.getPolicka();
                        int riadok = policka[counter].getRiadok();
                        int stlpec = policka[counter].getStlpec();
//                        policka[counter].getTlacitko().remove(counter);
//                        policka[counter] = null;
                        policka[counter] = new SoilTile(riadok, stlpec);
                        Mapa.setPolicka(policka);
                        break;
                    }
                    counter++;
                }
            }
        });

        moznostiKliknutia.add(moznost1);

        JMenuItem moznost2 = new JMenuItem("Lahni si do travicky.");
        moznost2.addActionListener(e -> System.out.println("abcd"));
        moznostiKliknutia.add(moznost2);

        return moznostiKliknutia;
    }
}
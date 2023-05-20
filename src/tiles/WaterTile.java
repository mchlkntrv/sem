package tiles;
import hra.Hrac;
import hra.Mapa;
import itemy.Krhla;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class WaterTile extends GameTile {
    public WaterTile(int riadok, int stlpec) {
        super(riadok, stlpec, new TileButton("voda"));
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
    public JPopupMenu createPopupMenu() {
        JPopupMenu moznostiKliknutia = new JPopupMenu();

        JMenuItem moznost1 = new JMenuItem("Naber vodu.");
        moznost1.addActionListener(e -> {
            if (Hrac.getInstance().getInventar().getAktivnyPredmet() instanceof Krhla) {
                ((Krhla)Hrac.getInstance().getInventar().getAktivnyPredmet()).naplnKrhlu();

                for (GameTile tile : Mapa.getInstance().getPolicka()) {
                    if (tile instanceof InvTile) {
                        InvTile invTile = (InvTile)tile;
                        if (invTile.getPredmet() == Hrac.getInstance().getInventar().getAktivnyPredmet()) {
                            ((Krhla)Hrac.getInstance().getInventar().getAktivnyPredmet()).naplnKrhlu();
                            invTile.getTlacitko().setOverlayTlacitka("1", "krhlafull");
                        }
                    }
                }
            }
        });
        moznostiKliknutia.add(moznost1);


        JMenuItem moznost2 = new JMenuItem("Napi sa.");
        moznost2.addActionListener(e -> System.out.println("abcd"));
        moznostiKliknutia.add(moznost2);

        return moznostiKliknutia;
    }
}
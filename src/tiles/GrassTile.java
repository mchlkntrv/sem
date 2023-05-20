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
            if (Hrac.getInstance().getInventar().getAktivnyPredmet() instanceof Ryl) {
                for (int i = 0; i < Mapa.getInstance().getPolicka().length; i++) {
                    if (Mapa.getInstance().getPolicka()[i] == GrassTile.this) {
                        Mapa.getInstance().getMapa().remove(this.getTlacitko());

                        int riadok = this.getRiadok();
                        int stlpec = this.getStlpec();

                        SoilTile newTile = new SoilTile(riadok, stlpec);

                        Mapa.getInstance().setPolicko(newTile, i);
                        Mapa.getInstance().getMapa().add(newTile.getTlacitko(), i - 8);
                        Mapa.getInstance().setTerminalText("Porýľoval si pôdu! Ešte ju musíš zaliať.");
                        break;
                    }
                }
            } else {
                Mapa.getInstance().setTerminalText("Na rýľovanie použi rýľ.");
            }
        });

        moznostiKliknutia.add(moznost1);

        JMenuItem moznost2 = new JMenuItem("Lahni si do travicky.");
        moznost2.addActionListener(e -> System.out.println("abcd"));
        moznostiKliknutia.add(moznost2);

        return moznostiKliknutia;
    }
}

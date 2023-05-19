package tiles;
import hra.Hrac;
import itemy.Predmet;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class InvTile extends GameTile {
    private Predmet predmetVTile;
    public InvTile(int riadok, int stlpec, Hrac hrac, Predmet predmet) {
        super(riadok, stlpec, new TileButton("inv"), hrac);
        this.predmetVTile = predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmetVTile = predmet;
    }

    public Predmet getPredmet() {
        return this.predmetVTile;
    }

    @Override
    public void onClick() {
        super.onClick();
    }

    @Override
    public JPopupMenu createPopupMenu() {
        JPopupMenu moznostiKliknutia = new JPopupMenu();

        JMenuItem moznost1 = new JMenuItem("Naber vodu.");
        moznost1.addActionListener(e -> System.out.println(super.getHrac().getMeno()));
        moznostiKliknutia.add(moznost1);

        return moznostiKliknutia;
    }
}
package tiles;
import hra.Hrac;
import itemy.Predmet;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class InvTile extends GameTile {
    private Predmet predmetVTile;
    public InvTile(int riadok, int stlpec, Hrac hrac) {
        super("inv", riadok, stlpec, new TileButton("inv"), hrac);
        this.predmetVTile = null;
    }

    @Override
    public void onClick() {
        System.out.println("voda");
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
package tiles;
import hra.Hrac;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class GrassTile extends GameTile {
    public GrassTile(int riadok, int stlpec, Hrac hrac) {
        super("trava", riadok, stlpec, new TileButton("trava"), hrac);
    }

    @Override
    public void onClick() {
        System.out.println("trava");
    }

    @Override
    public JPopupMenu createPopupMenu() {
        JPopupMenu moznostiKliknutia = new JPopupMenu();

        JMenuItem moznost1 = new JMenuItem("Poryluj");
        moznost1.addActionListener(e -> System.out.println("abcd"));
        moznostiKliknutia.add(moznost1);

        JMenuItem moznost2 = new JMenuItem("Lahni si do travicky.");
        moznost2.addActionListener(e -> System.out.println("abcd"));
        moznostiKliknutia.add(moznost2);

        return moznostiKliknutia;
    }
}
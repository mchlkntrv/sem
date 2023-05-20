package tiles;
import hra.Mapa;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class GrassTile extends GameTile {
    public GrassTile(Mapa mapa, int riadok, int stlpec) {
        super(mapa, riadok, stlpec, new TileButton("trava"));
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

        JMenuItem moznost1 = new JMenuItem("Poryluj");
        moznost1.addActionListener(e -> System.out.println("abcd"));
        moznostiKliknutia.add(moznost1);

        JMenuItem moznost2 = new JMenuItem("Lahni si do travicky.");
        moznost2.addActionListener(e -> System.out.println("abcd"));
        moznostiKliknutia.add(moznost2);

        return moznostiKliknutia;
    }
}
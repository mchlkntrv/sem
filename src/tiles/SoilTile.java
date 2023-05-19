package tiles;
import hra.Hrac;
import hra.Mapa;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class SoilTile extends GameTile {
    public SoilTile(Mapa mapa, int riadok, int stlpec, Hrac hrac) {
        super(mapa, riadok, stlpec, new TileButton("trava"), hrac);
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

        JMenuItem moznost1 = new JMenuItem("Zalej");
        moznost1.addActionListener(e -> System.out.println("abcd"));
        moznostiKliknutia.add(moznost1);

        return moznostiKliknutia;
    }
}
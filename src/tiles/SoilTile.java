package tiles;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class SoilTile extends GameTile {
    public SoilTile(int riadok, int stlpec) {
        super(riadok, stlpec, new TileButton("rylovane"));
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
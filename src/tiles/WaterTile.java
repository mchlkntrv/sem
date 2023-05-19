package tiles;
import hra.Hrac;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class WaterTile extends GameTile {
    public WaterTile(int riadok, int stlpec, Hrac hrac) {
        super(riadok, stlpec, new TileButton("voda"), hrac);
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
        moznost1.addActionListener(e -> System.out.println(super.getHrac().getMeno()));
        moznostiKliknutia.add(moznost1);

        JMenuItem moznost2 = new JMenuItem("Napi sa.");
        moznost2.addActionListener(e -> System.out.println("abcd"));
        moznostiKliknutia.add(moznost2);

        return moznostiKliknutia;
    }
}
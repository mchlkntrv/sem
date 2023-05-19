package tiles;
import hra.Hrac;
import hra.Mapa;
import itemy.Predmet;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class InvTile extends GameTile {
    private Predmet predmetVTile;
    public InvTile(Mapa mapa, int riadok, int stlpec, Hrac hrac, Predmet predmet) {
        super(mapa, riadok, stlpec, new TileButton("inv"), hrac);
        this.predmetVTile = predmet;

    }

    public void setZobrazeniePoctu(String pocet) {
        super.getTlacitko().updateTextButtonu(pocet);
    }

    public void setPredmet(Predmet predmet) {
        this.predmetVTile = predmet;
    }

    public Predmet getPredmet() {
        return this.predmetVTile;
    }

    @Override
    public void onClickLeft() {
        super.onClickRight();
    }

    @Override
    public void onClickRight() {
        super.onClickLeft();
    }

    @Override
    public JPopupMenu createPopupMenu() {
        JPopupMenu moznostiKliknutia = new JPopupMenu();

        JMenuItem moznost1 = new JMenuItem("Predaj");
        moznost1.addActionListener(e -> System.out.println(super.getHrac().getMeno()));
        moznostiKliknutia.add(moznost1);

        return moznostiKliknutia;
    }
}
package tiles;

import hra.Hrac;
import hra.Mapa;
import itemy.Krhla;
import itemy.Predmet;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class SoilTile extends GameTile {
    private boolean zaliata;
    public SoilTile(int riadok, int stlpec) {
        super(riadok, stlpec, new TileButton("rylnezaliate"));
        this.zaliata = false;
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
    public TileButton getTlacitko() {
        TileButton tlacitko = super.getTlacitko();
        tlacitko.setComponentPopupMenu(this.createPopupMenu());
        return tlacitko;
    }

    @Override
    public JPopupMenu createPopupMenu() {
        JPopupMenu moznostiKliknutia = new JPopupMenu();

        JMenuItem moznost1 = new JMenuItem("Zalej");
        moznost1.addActionListener(e -> {
            Predmet predmet = Hrac.getInstance().getInventar().getAktivnyPredmet();
            if (predmet instanceof Krhla && ((Krhla)predmet).getMnozstvoVody() > 0) {
                ((Krhla)Hrac.getInstance().getInventar().getAktivnyPredmet()).pouziKrhlu();
                this.zaliata = true;
                this.setObrazokTlacitka("rylzaliate");
                Mapa.getInstance().setTerminalText("Zalial si pôdu! Môžeš sadiť.");
            } else if (((Krhla)predmet).getMnozstvoVody() == 0) {
                Mapa.getInstance().setTerminalText("V krhle nemáš vodu.");
            } else {
                Mapa.getInstance().setTerminalText("Na zalievanie si vezmi krhlu!");
            }
        });
        moznostiKliknutia.add(moznost1);

        return moznostiKliknutia;
    }
}

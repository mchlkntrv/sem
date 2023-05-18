package tiles;
import hra.*;
import javax.swing.JPopupMenu;

public abstract class GameTile implements Clickable {
    private TileButton tlacitko;
    private int riadok;
    private int stlpec;
    private final JPopupMenu moznostiKliknutia;

    public GameTile(String nazov, int riadok, int stlpec, TileButton tlacitko, Hrac hrac) {
        this.tlacitko = tlacitko;
        this.tlacitko.addActionListener(e -> this.onClick());

        this.moznostiKliknutia = this.createPopupMenu();
        this.tlacitko.addActionListener(e -> this.moznostiKliknutia.show(tlacitko, 40, 40));

        this.riadok = riadok;
        this.stlpec = stlpec;

    }

    public TileButton getTlacitko() {
        return this.tlacitko;
    }
    @Override
    public abstract void onClick();

    public abstract JPopupMenu createPopupMenu();
}

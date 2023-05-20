package tiles;
import hra.Mapa;

import javax.swing.BorderFactory;
import javax.swing.JPopupMenu;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class GameTile implements Clickable {
    private TileButton tlacitko;
    private int riadok;
    private int stlpec;
    private final JPopupMenu moznostiKliknutia;

    public GameTile(Mapa mapa, int riadok, int stlpec, TileButton tlacitko) {
        this.tlacitko = tlacitko;
        this.nastavMouseListener();
        this.moznostiKliknutia = this.createPopupMenu();

        this.riadok = riadok;
        this.stlpec = stlpec;

    }

    public TileButton getTlacitko() {
        return this.tlacitko;
    }

    @Override
    public void onClickLeft() {
        this.moznostiKliknutia.show(this.tlacitko, 40, 40);
    }
    @Override
    public void onClickRight() {
        System.out.println(this.tlacitko.getNazovObrazku());
    }

    public abstract JPopupMenu createPopupMenu();

//    public Hrac getHrac() {
//        return this.hrac;
//    }


    public void nastavMouseListener() {
        this.tlacitko.setBorderPainted(false);
        this.tlacitko.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        this.tlacitko.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int button = e.getButton();
                        if (button == MouseEvent.BUTTON1) {
                            GameTile.this.onClickLeft();
                        } else if (button == MouseEvent.BUTTON3) {
                            GameTile.this.onClickRight();
                        }
                    }
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        GameTile.this.tlacitko.setBorderPainted(true);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        GameTile.this.tlacitko.setBorderPainted(false);
                    }
                }
        );
    }
}
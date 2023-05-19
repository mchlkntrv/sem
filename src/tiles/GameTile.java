package tiles;
import hra.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class GameTile implements Clickable {
    private TileButton tlacitko;
    private int riadok;
    private int stlpec;
    private final JPopupMenu moznostiKliknutia;
    private Hrac hrac;

    public GameTile(int riadok, int stlpec, TileButton tlacitko, Hrac hrac) {
        this.tlacitko = tlacitko;
        this.nastavMouseListener();
        this.moznostiKliknutia = this.createPopupMenu();
        this.tlacitko.addActionListener(e -> this.onClick());

        this.riadok = riadok;
        this.stlpec = stlpec;

        this.hrac = hrac;
    }

    public TileButton getTlacitko() {
        return this.tlacitko;
    }

    @Override
    public void onClick() {
        this.moznostiKliknutia.show(this.tlacitko, 40, 40);
        System.out.println(this.tlacitko.getNazovObrazku());
    }

    public abstract JPopupMenu createPopupMenu();

    public Hrac getHrac() {
        return this.hrac;
    }

    public void nastavMouseListener() {
        this.tlacitko.setBorderPainted(false);
        this.tlacitko.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        this.tlacitko.addMouseListener(
                new MouseAdapter() {
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
package tiles;

import javax.swing.*;
import java.awt.Dimension;

public class TileButton extends JButton {
    private String nazovObrazku;
    public TileButton(String nazovObrazku) {
        this.nazovObrazku = nazovObrazku;
        this.setPreferredSize(new Dimension(80, 80));
        Icon obrazokTlacitka = new ImageIcon("Assets\\" + nazovObrazku + ".png");
        this.setIcon(obrazokTlacitka);
    }

    public String getNazovObrazku() {
        return this.nazovObrazku;
    }
}

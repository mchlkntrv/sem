package tiles;

import javax.swing.*;
import java.awt.*;

public class TileButton extends JButton {
    public TileButton(String nazovObrazku) {
        this.setPreferredSize(new Dimension(80, 80));
        Icon obrazokTlacitka = new ImageIcon("Assets\\" + nazovObrazku + ".png");
        this.setIcon(obrazokTlacitka);
    }
}

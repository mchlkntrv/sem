package tiles;
import hra.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;

public class TlacitkoSpanie extends JButton {
    public TlacitkoSpanie() {
        super();
        this.setBorder(null);
        this.setBorderPainted(false);
        this.setIcon(new ImageIcon("Assets\\postel.png"));
        this.setPreferredSize(new Dimension(46, 30));
        this.setFocusPainted(false);
        this.setBackground(Color.LIGHT_GRAY);

        this.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int button = e.getButton();
                        if (button == MouseEvent.BUTTON1) {
                            if (Hrac.getInstance().getAktEnergia() > 98) {
                                Mapa.getInstance().setTerminalText("Ešte nie je čas na spánok!");
                            } else {
                                Mapa.getInstance().pridajDen();
                            }
                        }
                    }
                }
        );
    }
}

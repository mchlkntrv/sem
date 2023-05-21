package tiles;
import hra.*;
import itemy.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ObchodButton extends JButton {
    public ObchodButton() {
        super();
        this.setBorder(null);
        this.setBorderPainted(false);
        this.setBackground(Color.LIGHT_GRAY);
        this.setIcon(new ImageIcon("Assets\\seedbag.png"));
        this.setPreferredSize(new Dimension(30, 30));
        this.setFocusPainted(false);

        this.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (Hrac.getInstance().getPeniaze() >= 10) {
                            Hrac.getInstance().setPeniaze(Hrac.getInstance().getPeniaze() - 10);
                            Mapa.getInstance().setPeniazeText();
                            Random rnd = new Random();
                            int nahodacislo = rnd.nextInt(3); // Generates a random number between 0 and 2 (inclusive)
                            if (nahodacislo == 0) {
                                Hrac.getInstance().pridajPredmetDoInv(new JahodaSeed(1));
                            } else if (nahodacislo == 1) {
                                Hrac.getInstance().pridajPredmetDoInv(new KukuricaSeed(1));
                            } else {
                                Hrac.getInstance().pridajPredmetDoInv(new CviklaSeed(1));
                            }
                        } else {
                            Mapa.getInstance().setTerminalText("Nemáš peniaze...");
                        }
                    }
                }
        );
    }
}
package tiles;

import javax.swing.*;
import java.awt.*;

public class TileButton extends JButton {
    private String nazovObrazku;
    private JLabel textButtonu;
    public TileButton(String nazovObrazku) {
        this.textButtonu = new JLabel("");
        this.textButtonu.setHorizontalAlignment(SwingConstants.CENTER);
        this.textButtonu.setForeground(Color.WHITE);

        this.nazovObrazku = nazovObrazku;
        this.setPreferredSize(new Dimension(80, 80));
        Icon obrazokTlacitka = new ImageIcon("Assets\\" + nazovObrazku + ".png");
        this.setIcon(obrazokTlacitka);

        JPanel overlayPanel = new JPanel(new BorderLayout());
        overlayPanel.setOpaque(false);
        overlayPanel.add(this.textButtonu, BorderLayout.NORTH);

        setLayout(new BorderLayout());
        add(overlayPanel, BorderLayout.CENTER);
    }

    public void updateTextButtonu(String text) {
        this.textButtonu.setText(text);
    }

    public String getNazovObrazku() {
        return this.nazovObrazku;
    }
}

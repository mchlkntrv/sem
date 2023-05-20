package tiles;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class TileButton extends JButton {
    private String nazovObrazku;
    private JLabel textButtonu;
    public TileButton(String nazovObrazku) {
        this.nazovObrazku = nazovObrazku;
        this.setPreferredSize(new Dimension(80, 80));
        Icon obrazokTlacitka = new ImageIcon("Assets\\" + nazovObrazku + ".png");
        this.setIcon(obrazokTlacitka);

//        this.setOverlayTlacitka("tersefe0", "krhlaempty");

    }

    public void updateTextButtonu(String text) {
        this.textButtonu.setText(text);
    }


    public void setOverlayTlacitka(String text, String nazovOverlayObr) {
        JLabel obrazokOverlay = new JLabel();
        ImageIcon imageOverlayIcon = new ImageIcon("Assets\\" + nazovOverlayObr + ".png");
        obrazokOverlay.setIcon(imageOverlayIcon);
        obrazokOverlay.setBounds(0, 0, this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
        obrazokOverlay.setHorizontalAlignment(SwingConstants.CENTER);
        obrazokOverlay.setVerticalAlignment(SwingConstants.CENTER);

        JLabel textOverlay = new JLabel(text);
        textOverlay.setHorizontalAlignment(SwingConstants.CENTER);
        textOverlay.setForeground(Color.WHITE);
        textOverlay.setBounds(0, 0, 120, 20);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);
        layeredPane.setPreferredSize(new Dimension(80, 80));
        layeredPane.add(obrazokOverlay, Integer.valueOf(0));
        layeredPane.add(textOverlay, Integer.valueOf(1));
        this.setLayout(new BorderLayout());
        this.add(layeredPane);

        this.setLayout(new BorderLayout());
        this.add(layeredPane, BorderLayout.CENTER);
    }

    public String getNazovObrazku() {
        return this.nazovObrazku;
    }
}

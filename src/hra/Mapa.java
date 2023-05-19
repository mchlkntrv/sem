package hra;
import tiles.*;
import javax.swing.*;
import java.awt.*;
public class Mapa {
    private GameTile[] policka;
    private int den;
    public Mapa(Hrac hrac) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Farmovanie");


        this.policka = new GameTile[64];
        this.den = 1;

        JPanel info = new JPanel();
        info.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel denLabel = new JLabel();
        denLabel.setText("Deň: " + this.den);
        info.add(denLabel);
        JLabel peniazeLabel = new JLabel();
        peniazeLabel.setText("Peniaze: " + hrac.getPeniaze());
        info.add(peniazeLabel);

        JLabel coin = new JLabel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("Assets\\coin.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        coin.setIcon(imageIcon);
        info.add(coin);

        info.setBackground(Color.lightGray);
        frame.add(info, BorderLayout.NORTH);

        JPanel inventar = new JPanel();
        inventar.setLayout(new GridLayout(1, 8));
        for (int r = 0; r < 1; r++) {
            for (int s = 0; s < 8; s++) {
                this.policka[s] = new InvTile(r + 1, s + 1, hrac, null);
                inventar.add(this.policka[s].getTlacitko());
            }
        }

        JPanel mapa = new JPanel();
        mapa.setLayout(new GridLayout(7, 8));
        for (int r = 0; r < 7; r++) {
            for (int s = 0; s < 8; s++) {
                if ((r == 1 || r == 2) && (s == 1 || s == 2)) {
                    this.policka[(r + 1) * 8 + s] = new WaterTile(r + 1, s + 1, hrac);
                    mapa.add(this.policka[(r + 1) * 8 + s].getTlacitko());
                } else {
                    this.policka[(r + 1) * 8 + s] = new GrassTile(r + 1, s + 1, hrac);
                    mapa.add(this.policka[(r + 1) * 8 + s].getTlacitko());
                }
            }
        }

        JPanel invAMapa = new JPanel();
        invAMapa.setLayout(new BorderLayout());
        invAMapa.add(inventar, BorderLayout.NORTH);
        invAMapa.add(mapa, BorderLayout.CENTER);

        frame.add(invAMapa, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }
}
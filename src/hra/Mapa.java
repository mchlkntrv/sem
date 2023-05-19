package hra;
import itemy.*;
import tiles.GameTile;
import tiles.GrassTile;
import tiles.InvTile;
import tiles.WaterTile;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

public class Mapa implements InvPocuvac {
    private GameTile[] policka;
    private int den;
    private Inventar inventar;
    private JFrame frame;

    public Mapa() {
        this.frame = new JFrame();
        this.frame.setLayout(new BorderLayout());
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.setTitle("Farmovanie");

        this.policka = new GameTile[64];
        this.den = 1;

        JPanel info = new JPanel();
        info.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel denLabel = new JLabel();
        denLabel.setText("Deň: " + this.den);
        info.add(denLabel);
        JLabel peniazeLabel = new JLabel();
        peniazeLabel.setText("Peniaze: " + Hrac.static());
        info.add(peniazeLabel);

        JLabel coin = new JLabel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("Assets\\coin.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        coin.setIcon(imageIcon);
        info.add(coin);

        info.setBackground(Color.lightGray);
        this.frame.add(info, BorderLayout.NORTH);

        JPanel inventarPanel = new JPanel();
        inventarPanel.setLayout(new GridLayout(1, 8));
        for (int r = 0; r < 1; r++) {
            for (int s = 0; s < 8; s++) {
                if (hrac.getInventar().getPredmet(s) != null) {
                    this.policka[s] = new InvTile(this, r + 1, s + 1, hrac, hrac.getInventar().getPredmet(s));
                } else {
                    this.policka[s] = new InvTile(this, r + 1, s + 1, hrac, null);
                }
                inventarPanel.add(this.policka[s].getTlacitko());
            }
        }


        JPanel mapa = new JPanel();
        mapa.setLayout(new GridLayout(7, 8));
        for (int r = 0; r < 7; r++) {
            for (int s = 0; s < 8; s++) {
                if ((r == 1 || r == 2) && (s == 1 || s == 2)) {
                    this.policka[(r + 1) * 8 + s] = new WaterTile(this, r + 1, s + 1, hrac);
                    mapa.add(this.policka[(r + 1) * 8 + s].getTlacitko());
                } else {
                    this.policka[(r + 1) * 8 + s] = new GrassTile(this, r + 1, s + 1, hrac);
                    mapa.add(this.policka[(r + 1) * 8 + s].getTlacitko());
                }
            }
        }

        InvTile policko = (InvTile)this.policka[0];
        policko.setPredmet(hrac.getInventar().getPredmet(0));
        this.policka[0] = policko;



        JPanel invAMapa = new JPanel();
        invAMapa.setLayout(new BorderLayout());
        invAMapa.add(inventarPanel, BorderLayout.NORTH);
        invAMapa.add(mapa, BorderLayout.CENTER);

        this.frame.add(invAMapa, BorderLayout.CENTER);

        this.frame.pack();
        this.frame.setVisible(true);



        this.inventar = hrac.getInventar();

    }

    @Override
    public void zmenaInv(Inventar inv) {

    }
}
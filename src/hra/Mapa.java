package hra;
import tiles.GameTile;
import tiles.GrassTile;
import tiles.InvTile;
import tiles.WaterTile;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.*;

public class Mapa {
    private static Mapa instanceMapa;
    private static GameTile[] policka;
    private int den;
    private JFrame frame;

    private Mapa() {
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
        peniazeLabel.setText("Peniaze: " + Hrac.getPeniaze());
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
                if (Hrac.getInventar().getPredmet(s) != null) {
                    this.policka[s] = new InvTile( r + 1, s + 1, Hrac.getInventar().getPredmet(s));
                } else {
                    this.policka[s] = new InvTile( r + 1, s + 1, null);
                }
                inventarPanel.add(this.policka[s].getTlacitko());
            }
        }


        JPanel mapa = new JPanel();
        mapa.setLayout(new GridLayout(7, 8));
        for (int r = 0; r < 7; r++) {
            for (int s = 0; s < 8; s++) {
                if ((r == 1 || r == 2) && (s == 1 || s == 2)) {
                    this.policka[(r + 1) * 8 + s] = new WaterTile(r + 1, s + 1);
                    mapa.add(this.policka[(r + 1) * 8 + s].getTlacitko());
                } else {
                    this.policka[(r + 1) * 8 + s] = new GrassTile(r + 1, s + 1);
                    mapa.add(this.policka[(r + 1) * 8 + s].getTlacitko());
                }
            }
        }

        InvTile policko = (InvTile)this.policka[0];
        policko.setPredmet(Hrac.getInventar().getPredmet(0));
        this.policka[0] = policko;



        JPanel invAMapa = new JPanel();
        invAMapa.setLayout(new BorderLayout());
        invAMapa.add(inventarPanel, BorderLayout.NORTH);
        invAMapa.add(mapa, BorderLayout.CENTER);

        this.frame.add(invAMapa, BorderLayout.CENTER);

        this.frame.pack();
        this.frame.setVisible(true);

    }

    public static Mapa getInstance() {
        if (Mapa.instanceMapa == null) {
            Mapa.instanceMapa = new Mapa();
        }
        return Mapa.instanceMapa;
    }

    public static GameTile[] getPolicka() {
        return Arrays.copyOf(policka, policka.length);
    }

    public static void setPolicka(GameTile[] polickaPrepis) {
        System.arraycopy(polickaPrepis, 0, policka, 0, policka.length);
//        policka = polickaPrepis;
    }
}
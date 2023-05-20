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

public class Mapa {
    private static Mapa instanceMapa;
    private GameTile[] policka;
    private JPanel mapa;
    private JPanel info;
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

        this.info = new JPanel();
        this.info.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel denLabel = new JLabel();
        denLabel.setText("Deň: " + this.den);
        this.info.add(denLabel);

        JLabel peniazeLabel = new JLabel();
        peniazeLabel.setText("Peniaze: " + Hrac.getInstance().getPeniaze());
        this.info.add(peniazeLabel);

        JLabel coin = new JLabel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("Assets\\coin.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        coin.setIcon(imageIcon);
        this.info.add(coin);

        JLabel terminalLabel = new JLabel();
        terminalLabel.setText("Terminal");
        this.info.add(terminalLabel);
        this.info.setBackground(Color.lightGray);

        this.frame.add(this.info, BorderLayout.NORTH);

        JPanel inventarPanel = new JPanel();
        inventarPanel.setLayout(new GridLayout(1, 8));
        for (int r = 0; r < 1; r++) {
            for (int s = 0; s < 8; s++) {
                if (Hrac.getInstance().getInventar().getPredmet(s) != null) {
                    this.policka[s] = new InvTile( r + 1, s + 1, Hrac.getInstance().getInventar().getPredmet(s));
                } else {
                    this.policka[s] = new InvTile( r + 1, s + 1, null);
                }
                inventarPanel.add(this.policka[s].getTlacitko());
            }
        }

        this.mapa = new JPanel();

        this.mapa.setLayout(new GridLayout(7, 8));
        for (int r = 0; r < 7; r++) {
            for (int s = 0; s < 8; s++) {
                if ((r == 1 || r == 2) && (s == 1 || s == 2)) {
                    this.policka[(r + 1) * 8 + s] = new WaterTile(r + 1, s + 1);
                    this.mapa.add(this.policka[(r + 1) * 8 + s].getTlacitko());
                } else {
                    this.policka[(r + 1) * 8 + s] = new GrassTile(r + 1, s + 1);
                    this.mapa.add(this.policka[(r + 1) * 8 + s].getTlacitko());
                }
            }
        }

        InvTile policko = (InvTile)this.policka[0];
        policko.setPredmet(Hrac.getInstance().getInventar().getPredmet(0));
        this.policka[0] = policko;



        JPanel invAMapa = new JPanel();
        invAMapa.setLayout(new BorderLayout());
        invAMapa.add(inventarPanel, BorderLayout.NORTH);
        invAMapa.add(this.mapa, BorderLayout.CENTER);

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

    public GameTile[] getPolicka() {
        GameTile[] polickaReturn = new GameTile[this.policka.length];
        for (int i = 0; i < this.policka.length; i++) {
            polickaReturn[i] = this.policka[i];
        }
        return polickaReturn;
    }

    public void setPolicko(GameTile policko, int index) {
        this.policka[index] = policko;
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public JPanel getMapa() {
        return this.mapa;
    }

    public void setTerminalText(String text) {
        this.info.remove(3);
        this.info.add(new JLabel(text));
        this.info.repaint();
        this.info.revalidate();
    }
}
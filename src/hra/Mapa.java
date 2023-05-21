package hra;
import itemy.*;
import tiles.*;
import javax.swing.*;
import java.awt.BorderLayout;
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
        ImageIcon icon = new ImageIcon("Assets\\ikona.png");
        this.frame.setIconImage(icon.getImage());

        this.policka = new GameTile[64];
        this.den = 1;

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel denLabel = new JLabel();
        denLabel.setText("Deň: " + this.den);
        infoPanel.add(denLabel);

        JLabel peniazeLabel = new JLabel();
        peniazeLabel.setText("Peniaze: " + Hrac.getInstance().getPeniaze());
        infoPanel.add(peniazeLabel);

        JLabel coin = new JLabel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("Assets\\coin.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        coin.setIcon(imageIcon);
        infoPanel.add(coin);

        JLabel energia = new JLabel();
        energia.setText(Hrac.getInstance().getEnergiaStringStav());
        infoPanel.add(energia);

        JPanel terminalSpaniePanel = new JPanel();
        terminalSpaniePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JLabel terminalLabel = new JLabel();
        terminalLabel.setText("Tu sa ti zobrazia informácie.");
        terminalSpaniePanel.add(terminalLabel);

        TlacitkoSpanie spanie = new TlacitkoSpanie();
        terminalSpaniePanel.add(spanie);

        this.info = new JPanel();
        this.info.setLayout(new GridLayout(1, 2));
        this.info.add(infoPanel);
        this.info.add(terminalSpaniePanel);
        this.frame.add(this.info, BorderLayout.NORTH);

        JPanel inventarPanel = new JPanel();
        inventarPanel.setLayout(new GridLayout(1, 8));

        for (int r = 0; r < 1; r++) {
            for (int s = 0; s < 8; s++) {
                this.policka[s] = new InvTile( r + 1, s + 1, Hrac.getInstance().getInventar().getPredmet(s));
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

//        InvTile policko = (InvTile)this.policka[0];
//        policko.setPredmet(Hrac.getInstance().getInventar().getPredmet(0));
//        this.policka[0] = policko;


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

//    public JFrame getFrame() {
//        return this.frame;
//    }

    public JPanel getMapa() {
        return this.mapa;
    }

    public JPanel getInfo() {
        return this.info;
    }

    public void setTerminalText(String text) {
        JPanel terminalSpaniePanel = (JPanel)this.info.getComponent(1);
        JLabel terminalLabel = (JLabel)terminalSpaniePanel.getComponent(0);
        terminalLabel.setText(text);
        this.info.repaint();
        this.info.revalidate();
    }

    public void pridajDen() {
        this.den++;
        JPanel jp = (JPanel)this.info.getComponent(0);
        JLabel denLabel = (JLabel)jp.getComponent(0);
        denLabel.setText("Deň: " + this.den);
        this.info.repaint();
        this.info.revalidate();
        Hrac.getInstance().setEnergia(100);
        this.setEnergiaText();

        for (GameTile gameTile : this.policka) {
            if (gameTile instanceof SoilTile) {
                if (((SoilTile)gameTile).getDnesZaliata()) {
                    ((SoilTile)gameTile).setZaliata(false);
                    ((SoilTile)gameTile).setDnesZaliata(false);
                    if (((SoilTile)gameTile).getRastlina() != null) {
                        Crop crop = ((SoilTile)gameTile).getRastlina();
                        crop.pridajFazu();
                        gameTile.getTlacitko().setOverlayTlacitka("", crop.getNazov() + crop.getAktFaza());
                        this.setTerminalText("Nový deň. Nezabudni na rastliny!");
                    } else {
                        gameTile.setMoznostiKliknutia(((SoilTile)gameTile).popupZaliatie());
                    }
                } else {
                    ((SoilTile)gameTile).setZaliata(false);
                    ((SoilTile)gameTile).setDnesZaliata(false);
                    ((SoilTile)gameTile).removeRastlina();
                    gameTile.getTlacitko().setOverlayTlacitka("", "");
                    ((SoilTile)gameTile).changeToGrass();
                    this.setTerminalText("Zabudol si na nejaké rastliny. :(");
                }
            }
        }

    }

    public void setEnergiaText() {
        JPanel jp = (JPanel)this.info.getComponent(0);
        JLabel energiaLabel = (JLabel)jp.getComponent(3);
        energiaLabel.setText(Hrac.getInstance().getEnergiaStringStav());
        this.info.repaint();
        this.info.revalidate();
    }

    public void setPeniazeText() {
        JPanel jp = (JPanel)this.info.getComponent(0);
        JLabel peniazeLabel = (JLabel)jp.getComponent(1);
        peniazeLabel.setText("Peniaze: " + Hrac.getInstance().getPeniaze());
        this.info.repaint();
        this.info.revalidate();
    }
}
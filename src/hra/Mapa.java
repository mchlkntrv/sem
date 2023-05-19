package hra;
import tiles.*;
import javax.swing.*;
import java.awt.*;
public class Mapa {
    private GameTile[] policka;
    public Mapa(Hrac hrac) {
        this.policka = new GameTile[64];

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.setLayout(new GridLayout(1, 3));

        WaterTile tile1 = new WaterTile(1, 1, hrac);
        GrassTile tile2 = new GrassTile(1, 2, hrac);
        InvTile tile3 = new InvTile(1, 3, hrac, null);

        frame.add(tile1.getTlacitko());
        frame.add(tile2.getTlacitko());
        frame.add(tile3.getTlacitko());
        frame.pack();
    }
}
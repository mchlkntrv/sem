package hra;
import tiles.*;
import javax.swing.*;
import java.awt.*;
public class Mapa {
    public Mapa(Hrac hrac) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.setLayout(new GridLayout(1, 2));

        WaterTile tile1 = new WaterTile(1, 1, hrac);
        GrassTile tile2 = new GrassTile(1, 2, hrac);


        frame.add(tile1.getTlacitko());
        frame.add(tile2.getTlacitko());
        frame.pack();
    }
}
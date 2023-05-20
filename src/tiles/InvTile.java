package tiles;
import hra.Hrac;
import hra.Mapa;
import itemy.Predmet;
import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Optional;

public class InvTile extends GameTile {
    private Predmet predmetVTile;
    public InvTile(int riadok, int stlpec, Predmet predmet) {
        super(riadok, stlpec, new TileButton("inv"));
        this.predmetVTile = predmet;

        Optional<Predmet> optionalPredmet = Optional.ofNullable(predmet);
        String nazov = optionalPredmet.map(Predmet::getNazov).orElse(null);
        int pocet = optionalPredmet.map(Predmet::getPocet).orElse(0);
        String pocetToString;

        if (pocet == 0) {
            pocetToString = "";
        } else {
            pocetToString = String.valueOf(pocet);
        }

        super.getTlacitko().setOverlayTlacitka(pocetToString, nazov);
    }

    public void setZobrazeniePoctu(String pocet) {
        super.getTlacitko().updateTextButtonu(pocet);
    }

    public void setPredmet(Predmet predmet) {
        this.predmetVTile = predmet;
    }

    public Predmet getPredmet() {
        return this.predmetVTile;
    }

    @Override
    public void onClickLeft() {
        if (Hrac.getInventar().getAktivnyPredmet() != this.predmetVTile) {
            Hrac.getInventar().setAktivnyPredmet((this.predmetVTile));
            super.getTlacitko().setBorderPainted(true);
        } else {
            super.getTlacitko().setBorderPainted(false);
            Hrac.getInventar().setAktivnyPredmet(null);
        }
    }

    @Override
    public void onClickRight() {
        super.onClickLeft();
    }

    @Override
    public JPopupMenu createPopupMenu() {
        JPopupMenu moznostiKliknutia = new JPopupMenu();

        JMenuItem moznost1 = new JMenuItem("Predaj");
        moznost1.addActionListener(e -> System.out.println(Hrac.getMeno()));
        moznostiKliknutia.add(moznost1);

        return moznostiKliknutia;
    }

    @Override
    public void nastavMouseListener() {
        super.getTlacitko().setBorderPainted(false);
        super.getTlacitko().setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        super.getTlacitko().addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int button = e.getButton();
                        if (button == MouseEvent.BUTTON1) {
                            InvTile.this.onClickLeft();
                        } else if (button == MouseEvent.BUTTON3) {
                            InvTile.this.onClickRight();
                        }
                    }
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        InvTile.super.getTlacitko().setBorderPainted(true);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        if (Hrac.getInventar().getAktivnyPredmet() != InvTile.this.predmetVTile || InvTile.this.predmetVTile == null ) {
                            InvTile.super.getTlacitko().setBorderPainted(false);
                        }
                    }
                }
        );
    }
}
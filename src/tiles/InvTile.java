package tiles;
import hra.*;
import itemy.*;

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
        super(riadok, stlpec, new TileButton("inv.png"));
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
        Inventar inventar = Hrac.getInstance().getInventar();
        Predmet aktivnyPredmet = inventar.getAktivnyPredmet();

        boolean isActive = (aktivnyPredmet == this.predmetVTile);
        super.getTlacitko().setBorderPainted(!isActive);

        for (GameTile policko : Mapa.getInstance().getPolicka()) {
            if (policko instanceof InvTile && policko != this) {
                InvTile otherTile = (InvTile)policko;
                otherTile.getTlacitko().setBorderPainted(false);
            }
        }

        if (!isActive) {
            inventar.setAktivnyPredmet(this.predmetVTile);
        } else {
            inventar.setAktivnyPredmet(null);
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
        moznost1.addActionListener(e -> {
            if (this.getPredmet() == null) {
                Mapa.getInstance().setTerminalText("Čo chceš predať?");
            } else {
                for (int i = 0; i < Mapa.getInstance().getPolicka().length; i++) {
                    if (Mapa.getInstance().getPolicka()[i] instanceof InvTile tileInvMapa) {
                        if (tileInvMapa.getPredmet() == this.predmetVTile) {
                            int pocet = InvTile.this.getPredmet().getPocet();
                            if (pocet > 1) {
                                Predmet predmet = InvTile.this.getPredmet();
                                predmet.setPocet(pocet - 1);
                                InvTile.this.setPredmet(predmet);
                                InvTile.this.getTlacitko().setOverlayTlacitka(String.valueOf(pocet - 1), InvTile.this.predmetVTile.getNazov());
                                Hrac.getInstance().setPeniaze(Hrac.getInstance().getPeniaze() + InvTile.this.getPredmet().getCena());
                                Mapa.getInstance().setPeniazeText();
                                tileInvMapa.setPredmet(InvTile.this.getPredmet());
                                Mapa.getInstance().setPolicko(tileInvMapa, i);
                                break;
                            } else if (pocet == 1) {
                                int cena = this.getPredmet().getCena();
                                Hrac.getInstance().getInventar().removePredmet(this.getPredmet());
                                InvTile.this.getPredmet().setPocet(0);
                                InvTile.this.getTlacitko().setOverlayTlacitka(null, null);
                                InvTile.this.setPredmet(null);
                                Hrac.getInstance().getInventar().setAktivnyPredmet(null);
                                Hrac.getInstance().setPeniaze(Hrac.getInstance().getPeniaze() + cena);
                                Mapa.getInstance().setPeniazeText();
//                                Mapa.getInstance().setPolicko(null, InvTile.this.getStlpec() - 1);
                                break;
                            }
                        }
                    }
                }
            }
        });
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
                        if ((Hrac.getInstance().getInventar().getAktivnyPredmet() != InvTile.this.predmetVTile) || InvTile.this.predmetVTile == null ) {
                            InvTile.super.getTlacitko().setBorderPainted(false);
                        }
                    }
                }
        );
    }
}
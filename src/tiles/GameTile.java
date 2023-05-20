package tiles;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class GameTile implements Clickable {
    private TileButton tlacitko;
    private int riadok;
    private int stlpec;

    private JPopupMenu moznostiKliknutia;

    public GameTile(int riadok, int stlpec, TileButton tlacitko) {
        this.tlacitko = tlacitko;
        this.nastavMouseListener();
        this.moznostiKliknutia = this.createPopupMenu();

        this.riadok = riadok;
        this.stlpec = stlpec;
    }


//    public void setTileType(String tileType) {
//        this.tlacitko.setIcon(new ImageIcon("Assets/" + tileType + ".png"));
//        this.tlacitko.revalidate();
//        this.tlacitko.repaint();
//    }

    public void setObrazokTlacitka(String obrazokTlacitka) {
        this.tlacitko.setIcon(new ImageIcon("Assets/" + obrazokTlacitka + ".png"));
        this.tlacitko.revalidate();
        this.tlacitko.repaint();
    }

    public TileButton getTlacitko() {
        return this.tlacitko;
    }

    @Override
    public void onClickLeft() {
        this.moznostiKliknutia.show(this.tlacitko, 40, 40);
    }
    @Override
    public void onClickRight() {
        System.out.println(this.tlacitko.getNazovObrazku());
    }

    public abstract JPopupMenu createPopupMenu();
    public void updatePopupMenu(JPopupMenu newPopupMenu) {
        this.setMoznostiKliknutia(newPopupMenu);
    }

    public void nastavMouseListener() {
        this.tlacitko.setBorderPainted(false);
        this.tlacitko.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        this.tlacitko.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int button = e.getButton();
                        if (button == MouseEvent.BUTTON1) {
                            GameTile.this.onClickLeft();
                        } else if (button == MouseEvent.BUTTON3) {
                            GameTile.this.onClickRight();
                        }
                    }
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        GameTile.this.tlacitko.setBorderPainted(true);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        GameTile.this.tlacitko.setBorderPainted(false);
                    }
                }
        );
    }

    public JPopupMenu getMoznostiKliknutia() {
        return this.moznostiKliknutia;
    }

    public void setMoznostiKliknutia(JPopupMenu menu) {
        this.moznostiKliknutia = menu;
    }

    public void removeMoznostiKliknutia() {
        this.moznostiKliknutia = null;
    }

    @Override
    public int getRiadok() {
        return this.riadok;
    }

    @Override
    public int getStlpec() {
        return this.stlpec;
    }


}
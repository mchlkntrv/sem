package tiles;
import hra.Mapa;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.*;

public class TlacitkoSpanie extends JButton {
    public TlacitkoSpanie() {
        super();
        this.setIcon(new ImageIcon("Assets\\postel.png"));
        this.setPreferredSize(new Dimension(46, 30));
    }
}

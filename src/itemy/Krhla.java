package itemy;

public class Krhla extends Naradie {
    private int mnozstvoVody;
    private final int pocet = 1;
    public Krhla() {
        super("emptykrhla", 50, 3);
        this.mnozstvoVody = 0;
    }

    public void naplnKrhlu() {
        this.mnozstvoVody = 2;
    }

    public void pouziKrhlu() {
        this.mnozstvoVody--;
    }

    @Override
    public String getNazov() {
        switch (this.mnozstvoVody) {
            case 0:
                return "krhlaempty";
            case 1:
                return "krhlahalf";
            case 2:
                return "krhlafull";
            default:
                return "krhla";
        }
    }

    @Override
    public int getPocet() {
        return this.pocet;
    }

}

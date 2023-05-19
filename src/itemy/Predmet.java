package itemy;

public class Predmet {
    private boolean jeAktivny;
    private String nazov;

    public Predmet(String nazov) {
        this.jeAktivny = false;
    }

    public String getNazov() {
        return this.nazov;
    }
}

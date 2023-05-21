package itemy;

public abstract class Crop implements Predmet {
    private int aktFaza;
    private int maxFaza;
    private String nazov;
    private int pocet;

    public Crop(int aktFaza, int maxFaza, String nazov) {
        this.aktFaza = aktFaza;
        this.maxFaza = maxFaza;
        this.nazov = nazov;
    }

    public void pridajFazu() {
        if (this.aktFaza < this.maxFaza) {
            this.aktFaza++;
        }
    }

    public boolean getIsGrown() {
        return this.aktFaza == this.maxFaza - 1;
    }

    public int getAktFaza() {
        return this.aktFaza;
    }

    @Override
    public String getNazov() {
        return this.nazov;
    }

    @Override
    public void setPocet(int pocet) {
        this.pocet = pocet;
    }
}

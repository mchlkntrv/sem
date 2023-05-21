package itemy;

public abstract class Naradie implements Predmet {
    private String nazov;
    private int cenaOpravy;
    private int maxDurability;
    private int aktDurability;
    public Naradie(String nazov, int cenaOpravy, int maxDurability) {
        this.nazov = nazov;
        this.cenaOpravy = cenaOpravy;
        this.maxDurability = maxDurability;
        this.aktDurability = maxDurability;
    }

    @Override
    public String getNazov() {
        return this.nazov;
    }

}

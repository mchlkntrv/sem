package itemy;

public abstract class Naradie implements Predmet {
    private String nazov;
    private int cenaOpravy;
    private int durability;
    public Naradie(String nazov, int cenaOpravy, int durability) {
        this.nazov = nazov;
        this.cenaOpravy = cenaOpravy;
        this.durability = durability;
    }

    @Override
    public String getNazov() {
        return this.nazov;
    }

}

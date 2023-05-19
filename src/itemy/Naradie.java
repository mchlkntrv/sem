package itemy;

public abstract class Naradie implements Predmet {
    private String nazov;
    private int cena;
    private int durability;
    public Naradie(String nazov, int cena, int durability) {
        this.nazov = nazov;
        this.cena = cena;
        this.durability = durability;
    }
}

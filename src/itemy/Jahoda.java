package itemy;

public class Jahoda extends Crop {
    public Jahoda() {
        super(0, 2, "j");
    }

    @Override
    public String getNazov() {
        return super.getNazov();
    }

    @Override
    public int getPocet() {
        return 1;
    }

    @Override
    public void setPocet(int pocet) {
        super.setPocet(pocet);
    }

    @Override
    public int getCena() {
        return 20;
    }
}
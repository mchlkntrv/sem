package itemy;

public class Kukurica extends Crop {
    public Kukurica() {
        super(0, 3, "k");
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
        return 15;
    }
}
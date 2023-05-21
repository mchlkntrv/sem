package itemy;

public class Cvikla extends Crop {
    public Cvikla() {
        super(0, 3, "cv");
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
        return 10;
    }
}
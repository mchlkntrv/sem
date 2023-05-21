package itemy;

public class CviklaSeed extends CropSeed {
    public CviklaSeed(int pocet) {
        super("cv0", pocet);
    }

    @Override
    public String getNazov() {
        return super.getNazov();
    }
    @Override
    public int getPocet() {
        return super.getPocet();
    }
    @Override
    public int getCena() {
        return 1;
    }
}

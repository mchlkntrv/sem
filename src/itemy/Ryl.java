package itemy;

public class Ryl extends Naradie {
    public Ryl() {
        super("ryl", 10, 5);
    }



    @Override
    public String getNazov() {
        return "ryl";
    }

    @Override
    public int getPocet() {
        return 1;
    }

    @Override
    public void setPocet(int i) {

    }

    @Override
    public int getCena() {
        return 0;
    }
}

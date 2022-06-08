package SysAtm;

public class AtmSysteam {
    private  int atmmoeny;

    public AtmSysteam(int atmmoeny) {
        this.atmmoeny = atmmoeny;
    }

    public AtmSysteam() {
    }

    @Override
    public String toString() {
        return "AtmSysteam{" +
                "atmmoeny=" + atmmoeny +
                '}';
    }

    public int getAtmmoeny() {
        return atmmoeny;
    }

    public void setAtmmoeny(int atmmoeny) {
        this.atmmoeny = atmmoeny;
    }
}

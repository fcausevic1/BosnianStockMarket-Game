package sample;

public class Roba {
    int ID;
    String ime;
    double trenutnaVrijednostJedinice;
    double minimalnaVrijednostJedinice;
    double maximalnaVrijednostJedinice;

    public Roba(int ID, String ime, double trenutnaVrijednostJedinice, double minimalnaVrijednostJedinice, double maximalnaVrijednostJedinice) {
        this.ID = ID;
        this.ime = ime;
        this.trenutnaVrijednostJedinice = trenutnaVrijednostJedinice;
        this.minimalnaVrijednostJedinice = minimalnaVrijednostJedinice;
        this.maximalnaVrijednostJedinice = maximalnaVrijednostJedinice;
    }

    public Roba(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public double getTrenutnaVrijednostJedinice() {
        return trenutnaVrijednostJedinice;
    }


    public void setTrenutnaVrijednostJedinice(double trenutnaVrijednostJedinice) {
        this.trenutnaVrijednostJedinice = trenutnaVrijednostJedinice;
    }

    public double getMinimalnaVrijednostJedinice() {
        return minimalnaVrijednostJedinice;
    }

    public void setMinimalnaVrijednostJedinice(double minimalnaVrijednostJedinice) {
        this.minimalnaVrijednostJedinice = minimalnaVrijednostJedinice;
    }

    public double getMaximalnaVrijednostJedinice() {
        return maximalnaVrijednostJedinice;
    }

    public void setMaximalnaVrijednostJedinice(double maximalnaVrijednostJedinice) {
        this.maximalnaVrijednostJedinice = maximalnaVrijednostJedinice;
    }


}

package sample;

public class Roba {
    int ID;
    String ime;
    int trenutnaVrijednostJedinice;

    public Roba(int ID, String ime, int trenutnaVrijednostJedinice) {
        this.ID = ID;
        this.ime = ime;
        this.trenutnaVrijednostJedinice = trenutnaVrijednostJedinice;
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

    public int getTrenutnaVrijednostJedinice() {
        return trenutnaVrijednostJedinice;
    }

    public void setTrenutnaVrijednostJedinice(int trenutnaVrijednostJedinice) {
        this.trenutnaVrijednostJedinice = trenutnaVrijednostJedinice;
    }


}

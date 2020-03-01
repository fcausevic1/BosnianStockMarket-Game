package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Random;

public class Roba {
    int ID;
    SimpleStringProperty ime;
    SimpleIntegerProperty kolicina;
    SimpleDoubleProperty trenutnaVrijednostJedinice;
    SimpleDoubleProperty minimalnaVrijednostJedinice;
    SimpleDoubleProperty maximalnaVrijednostJedinice;

    public Roba(int ID, String ime,int količina, double trenutnaVrijednostJedinice, double minimalnaVrijednostJedinice, double maximalnaVrijednostJedinice) {
        this.ID = ID;
        this.ime = new SimpleStringProperty(ime);
        this.kolicina = new SimpleIntegerProperty(količina);
        this.trenutnaVrijednostJedinice = new SimpleDoubleProperty(trenutnaVrijednostJedinice);
        this.minimalnaVrijednostJedinice = new SimpleDoubleProperty(minimalnaVrijednostJedinice);
        this.maximalnaVrijednostJedinice = new SimpleDoubleProperty(maximalnaVrijednostJedinice);
    }

    public Roba() {
    }

    public int getKolicina() {
        return kolicina.get();
    }

    public SimpleIntegerProperty kolicinaProperty() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina.set(kolicina);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getIme() {
        return ime.get();
    }

    public SimpleStringProperty imeProperty() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime.set(ime);
    }

    public double getTrenutnaVrijednostJedinice() {
        return trenutnaVrijednostJedinice.get();
    }

    public SimpleDoubleProperty trenutnaVrijednostJediniceProperty() {
        return trenutnaVrijednostJedinice;
    }

    public void setTrenutnaVrijednostJedinice(double trenutnaVrijednostJedinice) {
        this.trenutnaVrijednostJedinice.set(trenutnaVrijednostJedinice);
    }

    public double getMinimalnaVrijednostJedinice() {
        return minimalnaVrijednostJedinice.get();
    }

    public SimpleDoubleProperty minimalnaVrijednostJediniceProperty() {
        return minimalnaVrijednostJedinice;
    }

    public void setMinimalnaVrijednostJedinice(double minimalnaVrijednostJedinice) {
        this.minimalnaVrijednostJedinice.set(minimalnaVrijednostJedinice);
    }

    public double getMaximalnaVrijednostJedinice() {
        return maximalnaVrijednostJedinice.get();
    }

    public SimpleDoubleProperty maximalnaVrijednostJediniceProperty() {
        return maximalnaVrijednostJedinice;
    }

    public void setMaximalnaVrijednostJedinice(double maximalnaVrijednostJedinice) {
        this.maximalnaVrijednostJedinice.set(maximalnaVrijednostJedinice);
    }

    public int rand(int granica) {
        int num = (int) (Math.random()*100);
        if(num > granica) {
            //    if(granica > 25) granica -= 2;                    // OVO JE SVE BESKORISNO ZATO STO SVAKI PUT KAO PARAMETAR PRIMI NOVU GRANICU
            //  if(granica < 20) granica = 100 - granica;
            num = 1;
        }
        else {
            //  if(granica < 75) granica += 5;                       // ISTO
            // if(granica > 80) granica = 100 - granica;
            num = 0;
        }
        return num;
    }
/*
    public void novaCijena() {
        Random r= new Random(System.currentTimeMillis());
        int num = rand((int)trenutnaVrijednostJedinice.get() % 100);
        if((trenutnaVrijednostJedinice.get() / (maximalnaVrijednostJedinice.get() - minimalnaVrijednostJedinice.get()))*100 <= 40) {
            if(num == 0) trenutnaVrijednostJedinice.get() -= (trenutnaVrijednostJedinice.get() /100)*(r.nextDouble()*5);
            else trenutnaVrijednostJedinice += (trenutnaVrijednostJedinice/100)*(r.nextDouble()*10);
        }
        else if((trenutnaVrijednostJedinice/ (maximalnaVrijednostJedinice-minimalnaVrijednostJedinice))*100 >= 60) {
            if(num == 0)
                trenutnaVrijednostJedinice -= (trenutnaVrijednostJedinice/100)*(r.nextDouble()*35);
            else trenutnaVrijednostJedinice += (trenutnaVrijednostJedinice/100)*(r.nextDouble()*5);
        }
        else {
            if(num == 0) trenutnaVrijednostJedinice -= (trenutnaVrijednostJedinice/100)*(r.nextDouble()*5);
            else trenutnaVrijednostJedinice += (trenutnaVrijednostJedinice/100)*(r.nextDouble()*3);
        }

        trenutnaVrijednostJedinice*=100;
        trenutnaVrijednostJedinice = (int) trenutnaVrijednostJedinice;
        trenutnaVrijednostJedinice /= 100;
    }

    void napadNaRobu () {
        System.out.println(trenutnaVrijednostJedinice);
        System.out.println("Desilo se nešto jebeno baš! Vrijednost " + ime  + " je opala za 35%");
        trenutnaVrijednostJedinice = trenutnaVrijednostJedinice - (trenutnaVrijednostJedinice / 3.5);
        System.out.println(trenutnaVrijednostJedinice);

    }

    */

    @Override
    public String toString() {
        return ime.get();
    }
}

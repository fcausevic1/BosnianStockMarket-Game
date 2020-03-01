package sample;

import javafx.beans.property.SimpleDoubleProperty;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Igrac {

    ArrayList<Roba> listaRobe;
   SimpleDoubleProperty stanjeNovca;

    public Igrac(ArrayList<Roba> listaRobe, double stanjeNovca) {
        this.listaRobe = listaRobe;
        this.stanjeNovca = new SimpleDoubleProperty(stanjeNovca);
    }

    public Igrac() {
    }

    public ArrayList<Roba> getListaRobe() {
        return listaRobe;
    }

    public void setListaRobe(ArrayList<Roba> listaRobe) {
        this.listaRobe = listaRobe;
    }

    public double getStanjeNovca() {
        return stanjeNovca.get();
    }

    public SimpleDoubleProperty stanjeNovcaProperty() {
        return stanjeNovca;
    }

    public void setStanjeNovca(double stanjeNovca) {
        this.stanjeNovca.set(stanjeNovca);
    }
/*
    void IspisiStanjeIgraca () {
        for (Artikal artikal : stanjeRobe) {
            System.out.println(artikal.roba.ime + " " + artikal.kolicina);
        }
        System.out.println("Imate $" + stanjeNovca);
    }


    void Kupi (Roba roba, int kolicina) throws Exception {
        if (kolicina*roba.trenutnaVrijednostJedinice > stanjeNovca) throw new Exception("nemate para");
boolean daLiJeDodao=false;
        for (Artikal artikal : stanjeRobe ) {
            if (artikal.roba.ID == roba.ID) {
                artikal.kolicina += kolicina;
                daLiJeDodao = true;
            }
        }
            if (!daLiJeDodao) {
                stanjeRobe.add(new Artikal(roba, kolicina));
            }
        setStanjeNovca(getStanjeNovca()-kolicina * roba.trenutnaVrijednostJedinice);
    }

    void Prodaj (Roba roba, int kolicina) throws  Exception {
        Artikal a = null;
        for (Artikal artikal : stanjeRobe) {

            if (artikal.roba.ID == roba.ID && artikal.kolicina >= kolicina) {
                artikal.kolicina -= kolicina;
                if (artikal.kolicina == 0) a = artikal;
                setStanjeNovca(getStanjeNovca() + kolicina * roba.trenutnaVrijednostJedinice);
            }
            else throw new Exception("nemate dovoljno robe");
        }
        if (a!=null) {
            stanjeRobe.remove(a);
        }
    }

    void napadNaNovac () {

        System.out.println("Konvertibilna marka je devalvirala! Izgubili ste 33% vašeg novca!");
        stanjeNovca= stanjeNovca-( stanjeNovca/33.0);
    }

*/

}


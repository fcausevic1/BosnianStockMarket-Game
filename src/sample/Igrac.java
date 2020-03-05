package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Igrac {
    private ArrayList<Roba> listaRobe;
    private SimpleDoubleProperty stanjeNovca;
    private ArrayList<Boolean> nivo;               // 0-19999 1, 20k-39999 2, 40k-59999 3, 60k-99999 4, nesto na ovaj fazon


    public int kojiJeNivo() {                                   // Vraca nivo na kojem je igrac trenutno.
    int level=0;
        for (Boolean bool : nivo) {
            if (bool) level++;
        }
        return level;
    }


    public int daLiJePresaoNivo () {                                            // Vrati nivo ako si presao na njega.
        double ukupnaVrijednost = getUkupnaVrijednost();
        int level=0;

        for (int i=0 ; i<nivo.size(); i++) {
            if (ukupnaVrijednost>=60000 && nivo.get(3)) {
                nivo.set(3,true);
                return 4;
            }
            else if (ukupnaVrijednost>=40000 && nivo.get(2)) {
                nivo.set(2,true);
                return 3;
            }
            else if (ukupnaVrijednost>=20000 && nivo.get(1)) {
                nivo.set(1,true);
                return 2;
            }
        }
        return level;
    }


    public Igrac(double stanjeNovca) {
        this.stanjeNovca = new SimpleDoubleProperty(stanjeNovca);
        this.listaRobe = new ArrayList<>();
        this.nivo = new ArrayList<>();
      //  nivo.set(0,true);                               // Ovo ovdje ne radI! ne znam kako da postavim prvi na true?

    }
    public Igrac() {
        this.listaRobe = new ArrayList<>();
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

    public double getUkupnaVrijednost() {
        double v = 0;
        for (Roba r: listaRobe) {
            v += r.getKolicina() * r.getTrenutnaVrijednostJedinice();
        }
        return  v;
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


package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Igrac {
    private ArrayList<Roba> listaRobe;
    private SimpleDoubleProperty stanjeNovca;
    private ArrayList<Boolean> nivo;               // 0-19999 1, 20k-39999 2, 40k-59999 3, 60k-99999 4, nesto na ovaj fazon

    public void restartujNivoe () {
        for (int i=0 ; i<nivo.size(); i++ ) {
            nivo.set(i,false);
        }
    }


    public int kojiJeNivo() {                                   // Vraca nivo na kojem je igrac trenutno.
    int level=1;
        for (Boolean bool : nivo) {
            if (bool) ++level;
        }
        return level;
    }


    public int daLiJePresaoNivo () {  // Vrati nivo ako si presao na njega.
        double ukupnaVrijednost = getUkupnaVrijednost();
        int level=0;

            if (ukupnaVrijednost>=60000    && !nivo.get(3) ) {
                nivo.add(3,true);                                         //  Baca izuzetak kada pokusam ovo pozvat. moze bit da nije inicijalizovano
                return 4;
            }
            else if (ukupnaVrijednost>=40000  && nivo.get(2) ) {
                nivo.add(2,true);
                return 3;
            }

             else if (ukupnaVrijednost>=20000   && !nivo.get(1) ) {
                nivo.add(1,true);
                return 2;
            }


        return level;
    }


    public Igrac(double stanjeNovca) {

        this.stanjeNovca = new SimpleDoubleProperty(stanjeNovca);
        this.listaRobe = new ArrayList<>();
        this.nivo = new ArrayList<>();

        nivo.add(0,true);
        nivo.add(1,false);
        nivo.add(2,false);
        nivo.add(3,false);

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
        return  v+getStanjeNovca();
    }

    public ArrayList<Boolean> getNivo() {
        return nivo;
    }

    public void setNivo(ArrayList<Boolean> nivo) {
        this.nivo = nivo;
    }

    @Override
    public String toString() {
        return kojiJeNivo() + "";
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


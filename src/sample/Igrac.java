package sample;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Igrac {


   private class Artikal {
       Roba roba;
       int kolicina;

       public Artikal(Roba roba, int kolicina) {
           this.roba = roba;
           this.kolicina = kolicina;
       }

       public int getKolicina() {
           return kolicina;
       }

       public void setKolicina(int kolicina) {
           this.kolicina = kolicina;
       }

       public Roba getRoba() {
           return roba;
       }

       public void setRoba(Roba roba) {
           this.roba = roba;
       }

       public Artikal() {
       }

   };

   ArrayList<Artikal> stanjeRobe;               // ATRIBUTI KLASE IGRAC
   double stanjeNovca;

    public Igrac(double stanjeNovca) {
        this.stanjeRobe = new ArrayList<Artikal>();
        this.stanjeNovca = stanjeNovca;
    }

    public Igrac() { }

    public ArrayList<Artikal> getStanjeRobe() {
        return stanjeRobe;
    }

    public void setStanjeRobe(ArrayList<Artikal> stanjeRobe) {
        this.stanjeRobe = stanjeRobe;
    }

    public double getStanjeNovca() {
        return stanjeNovca;
    }

    public void setStanjeNovca(double stanjeNovca) {
        this.stanjeNovca = stanjeNovca;
    }


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



}


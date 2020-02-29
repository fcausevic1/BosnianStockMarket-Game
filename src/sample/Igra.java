package sample;

import java.util.ArrayList;
import java.util.Random;

public class Igra {
    private Berza berza;
    private Igrac igrac;
    private ArrayList<Roba> listaRobe;

    public Igra(Berza berza, Igrac igrac, ArrayList<Roba> listaRobe) {
        this.berza = berza;
        this.igrac = igrac;
        this.listaRobe = listaRobe;
    }

    void Kupi(Roba roba, int kolicina) throws Exception {
        igrac.Kupi(roba,kolicina);
    }

    void Prodaj (Roba roba, int kolicina) throws  Exception {
        igrac.Prodaj(roba,kolicina);
    }
    void novaSedmica () {                                // SAMO PROMIJENITI CIJENE ZA SVAKI PROIZVOD
        for (Roba roba: listaRobe ) {
                novaCijena(roba);
        }
    }

    void stanjeBerze () {                                   // ISPISUJE TRENUTNE CIJENE ROBE
        for (Roba roba : listaRobe ) {
            System.out.println("Vrijednost " + roba.ime +  " je: " + roba.trenutnaVrijednostJedinice);
        }
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

    public void novaCijena(Roba roba) {
        Random r= new Random(System.currentTimeMillis());
        int num = rand((int)roba.trenutnaVrijednostJedinice%100);
        if((roba.trenutnaVrijednostJedinice / (roba.maximalnaVrijednostJedinice-roba.minimalnaVrijednostJedinice))*100 <= 40) {
            if(num == 0) roba.trenutnaVrijednostJedinice -= (roba.trenutnaVrijednostJedinice/100)*(r.nextDouble()*5);
            else roba.trenutnaVrijednostJedinice += (roba.trenutnaVrijednostJedinice/100)*(r.nextDouble()*10);
        }
        else if((roba.trenutnaVrijednostJedinice/ (roba.maximalnaVrijednostJedinice-roba.minimalnaVrijednostJedinice))*100 >= 60) {
            if(num == 0) roba.trenutnaVrijednostJedinice -= (roba.trenutnaVrijednostJedinice/100)*(r.nextDouble()*35);
            else roba.trenutnaVrijednostJedinice += (roba.trenutnaVrijednostJedinice/100)*(r.nextDouble()*5);
        }
        else {
            if(num == 0) roba.trenutnaVrijednostJedinice -= (roba.trenutnaVrijednostJedinice/100)*(r.nextDouble()*5);
            else roba.trenutnaVrijednostJedinice += (roba.trenutnaVrijednostJedinice/100)*(r.nextDouble()*3);
        }

        roba.trenutnaVrijednostJedinice*=100;
        roba.trenutnaVrijednostJedinice = (int) roba.trenutnaVrijednostJedinice;
        roba.trenutnaVrijednostJedinice /= 100;
    }

    void napadNaNovac (Igrac igrac) {

        System.out.println("Konvertibilna marka je devalvirala! Izgubili ste 33% vašeg novca!");
        igrac.stanjeNovca= igrac.stanjeNovca-( igrac.stanjeNovca/33.0);
    }

    void napadNaRobu (Roba roba) {
        System.out.println(roba.trenutnaVrijednostJedinice);
        System.out.println("Desilo se nešto jebeno baš! Vrijednost " + roba.ime  + " je opala za 35%");
        roba.trenutnaVrijednostJedinice = roba.trenutnaVrijednostJedinice - (roba.trenutnaVrijednostJedinice / 3.5);
        System.out.println(roba.trenutnaVrijednostJedinice);

    }



}

package sample;

import java.util.ArrayList;

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
}

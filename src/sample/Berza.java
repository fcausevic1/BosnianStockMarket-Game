package sample;

public class Berza {
    int granica = 50;
    public int rand(int granica) {
        int num = (int) (Math.random()*100);
        if(num > granica) {
            if(granica > 25) granica -= 2;
            if(granica < 20) granica = 100 - granica;
            num = 1;
        }
        else {
            if(granica < 75) granica += 5;
            if(granica > 80) granica = 100 - granica;
            num = 0;
        }
        return num;
    }

    public void novaCijena(Roba roba) {
        int num = rand((int)roba.trenutnaVrijednostJedinice%100);
        if((roba.trenutnaVrijednostJedinice / (roba.maximalnaVrijednostJedinice-roba.minimalnaVrijednostJedinice))*100 <= 40) {
            if(num == 0) roba.trenutnaVrijednostJedinice -= (roba.trenutnaVrijednostJedinice/100)*(Math.random()*5);
            else roba.trenutnaVrijednostJedinice += (roba.trenutnaVrijednostJedinice/100)*(Math.random()*10);
        }
        else if((roba.trenutnaVrijednostJedinice/ (roba.maximalnaVrijednostJedinice-roba.minimalnaVrijednostJedinice))*100 >= 60) {
            if(num == 0) roba.trenutnaVrijednostJedinice -= (roba.trenutnaVrijednostJedinice/100)*(Math.random()*35);
            else roba.trenutnaVrijednostJedinice += (roba.trenutnaVrijednostJedinice/100)*(Math.random()*5);
        }
        else {
            if(num == 0) roba.trenutnaVrijednostJedinice -= (roba.trenutnaVrijednostJedinice/100)*(Math.random()*5);
            else roba.trenutnaVrijednostJedinice += (roba.trenutnaVrijednostJedinice/100)*(Math.random()*3);
        }

        roba.trenutnaVrijednostJedinice*=100;
        roba.trenutnaVrijednostJedinice = (int) roba.trenutnaVrijednostJedinice;
        roba.trenutnaVrijednostJedinice /= 100;
    }

}

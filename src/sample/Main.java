package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) throws Exception {

        ArrayList<Roba> listRobe = new ArrayList<Roba>();
        listRobe.add(new Roba(1, "Zlato", 100, 10, 300));
        listRobe.add(new Roba(2, "Srebro", 40, 4, 120));
        listRobe.add(new Roba(3, "Nafta", 130, 13, 360));
        Berza berza = new Berza();

        Igrac igrac = new Igrac(10000);
        Igra igrica = new Igra(berza, igrac, listRobe);

     /*
     igrac.IspisiStanje();
     igrica.Kupi(listRobe.get(0),10);
     igrac.IspisiStanje();
     igrica.Prodaj(listRobe.get(0),10);
     igrac.IspisiStanje();
*//*
        for (int i = 0; i < 1000; i++) {
            berza.novaCijena(listRobe.get(0));
            berza.novaCijena(listRobe.get(1));
            berza.novaCijena(listRobe.get(2));
            if(i % 50 == 0) {
                System.out.println("Zlato:  " + listRobe.get(0).trenutnaVrijednostJedinice);
                System.out.println("Srebro: " + listRobe.get(1).trenutnaVrijednostJedinice);
                System.out.println("Nafta:  " + listRobe.get(2).trenutnaVrijednostJedinice);


        }
*/
        int unos;
        Scanner Odabir = new Scanner(System.in);
        do {
            System.out.println("Dobro došli u novu semdicu!");
            igrica.novaSedmica();
            igrica.stanjeBerze();
            igrac.IspisiStanjeIgraca();

            System.out.println("1-Kupi 2-Prodaj 3-Sljedeca sedmica");
            unos=Odabir.nextInt();
            //System.out.println(listRobe.get().trenutnaVrijednostJedinice);
            if (unos==1) {
                System.out.println("1-Zlato 2-Srebro 3-Nafta 4-Zajebo sam se");
                unos=Odabir.nextInt();
                if (unos == 1) {
                    System.out.println("Koliko?");
                    igrac.Kupi(listRobe.get(0), Odabir.nextInt());
                }
                else if(unos == 2) {
                    System.out.println("Koliko?");
                    igrac.Kupi(listRobe.get(1), Odabir.nextInt());
                }
                else if(unos == 3) {
                    System.out.println("Koliko?");
                    igrac.Kupi(listRobe.get(2), Odabir.nextInt());
                }
            }
            else if  (unos == 2) {
                System.out.println("1-Zlato 2-Srebro 3-Nafta 4-Zajebo sam se");
                unos=Odabir.nextInt();
                if (unos == 1) {
                    System.out.println("Koliko?");
                    igrac.Prodaj(listRobe.get(0), Odabir.nextInt());
                } else if (unos == 2) {
                    System.out.println("Koliko?");
                    igrac.Prodaj(listRobe.get(1), Odabir.nextInt());
                } else if (unos == 3) {
                    System.out.println("Koliko?");
                    igrac.Prodaj(listRobe.get(2), Odabir.nextInt());
                }
            }



        } while (unos != -1);

System.exit(0);
    }
}
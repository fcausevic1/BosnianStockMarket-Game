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
        Scanner stahos = new Scanner(System.in);
        do {
            System.out.println("STAHOS");
            System.out.println(listRobe.get(0).trenutnaVrijednostJedinice);
            if (stahos.nextInt()==1) {
                System.out.println("KOLKO");
                igrac.Kupi(listRobe.get(0), stahos.nextInt());
            }
            else {
                System.out.println("KOLKO");
                igrac.Prodaj(listRobe.get(0), stahos.nextInt());
            }
            igrac.IspisiStanje();
            berza.novaCijena(listRobe.get(0));
        } while (stahos.nextInt() != -1);

System.exit(0);
    }
}
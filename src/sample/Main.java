package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) throws Exception {

        ArrayList<Roba> listRobe = new ArrayList<Roba>();
        listRobe.add(new Roba(1,"Zlato",100));
        listRobe.add(new Roba(2,"Srebro",40));
        listRobe.add(new Roba(3,"Nafta",130));
        Berza berza = new Berza();

        Igrac igrac= new Igrac (10000);
     Igra igrica= new Igra(berza,igrac,listRobe);

     igrac.IspisiStanje();
     igrica.Kupi(listRobe.get(0),10);
     igrac.IspisiStanje();
     igrica.Prodaj(listRobe.get(0),10);
     igrac.IspisiStanje();


    }

}

package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class Controller implements Initializable {
    public LineChart berzaGraf;
    public NumberAxis yOsa;
    public NumberAxis xOsa;
    public ListView<Roba> listaRobe;
    public Label nazivRobeLabela;
    public Label trenutnaVrijednostLabela;
    public Label kolicinaLabela;
    public Label ukupnaVrijednostLabela;
    public Label prethodnaVrijednostLabela;
    public TableView<Roba> stanjeTabela;
    public TableColumn nazivRobeKolona;
    public TableColumn kolicinaKolona;
    public TableColumn trentnaVrijednostKolona;
    public TableColumn<Roba, String> rastKolona;
    public TableColumn<Roba, String> ukupnaVrijednostKolona;
    public Label novacLabela;
    public Label netoLabela;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ArrayList<Roba>  roba = new ArrayList<>();
        roba.add(new Roba (0,"Zlato",25,100,10,400));
        roba.add(new Roba (1,"Srebro",35,60,6,240));
        roba.add(new Roba (2,"Nafta",55,130,13,420));
        ObservableList<Roba> listaZaPromatranje = FXCollections.observableArrayList(roba);
        listaRobe.setItems(listaZaPromatranje);
        listaRobe.getSelectionModel().selectedItemProperty().addListener((vrijednost,staraVrijednost,novaVrijednost) -> {
            nazivRobeLabela.setText(novaVrijednost.getIme());
            trenutnaVrijednostLabela.setText(novaVrijednost.getTrenutnaVrijednostJedinice() + "KM");
            kolicinaLabela.setText(novaVrijednost.getKolicina() + "");
            ukupnaVrijednostLabela.setText(novaVrijednost.getTrenutnaVrijednostJedinice()* novaVrijednost.getKolicina() + "KM");
        });
        listaRobe.getSelectionModel().selectFirst();

        ObservableList<Roba> nova = FXCollections.observableArrayList(roba);

        stanjeTabela.setItems(nova);
        nazivRobeKolona.setCellValueFactory(new PropertyValueFactory("ime"));
        kolicinaKolona.setCellValueFactory(new PropertyValueFactory("kolicina"));
        trentnaVrijednostKolona.setCellValueFactory(new PropertyValueFactory("trenutnaVrijednostJedinice"));
        rastKolona.setCellValueFactory(data -> new SimpleStringProperty("0"));
        ukupnaVrijednostKolona.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTrenutnaVrijednostJedinice() * data.getValue().getKolicina() + ""));
    }
   /*

    int i = 6;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        XYChart.Series zlato = new XYChart.Series();
        zlato.setName("Zlato");
        zlato.getData().add(new XYChart.Data<>(1, 100));
        zlato.getData().add(new XYChart.Data<>(2, 110));
        zlato.getData().add(new XYChart.Data<>(3, 120));
        zlato.getData().add(new XYChart.Data<>(4, 115));
        zlato.getData().add(new XYChart.Data<>(5, 95));
        berzaGraf.getData().add(zlato);

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
              zlato.getData().add(new XYChart.Data<>(i, Math.random()*200));
              i++;
              if(i > 10) {
                  xOsa.setLowerBound(i-10);
                  xOsa.setUpperBound(i);
              }
            }
        };

        timer.scheduleAtFixedRate(task, 1000, 2000);
    }
    */

}

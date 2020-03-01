package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public LineChart<Number, Number> berzaGraf;
    public NumberAxis yOsa;
    public NumberAxis xOsa;
    public ListView<Roba> listaRobe;
    public Label nazivRobeLabela;
    public Label trenutnaVrijednostLabela;
    public Label kolicinaLabela;
    public Label ukupnaVrijednostLabela;
    public Label prethodnaVrijednostLabela;
    public TableView<Roba> stanjeTabela;
    public TableColumn<Roba, String> nazivRobeKolona;
    public TableColumn<Roba, Integer> kolicinaKolona;
    public TableColumn<Roba, Double> trentnaVrijednostKolona;
    public TableColumn<Roba, String> rastKolona;
    public TableColumn<Roba, String> ukupnaVrijednostKolona;
    public Label novacLabela;
    public Label netoLabela;
    private ArrayList<Roba> roba;
    private int brojSedmice;
    private DecimalFormat df;


    public void novaSedmica() {
        for (Roba r: roba) {
            r.historija.add(r.getTrenutnaVrijednostJedinice());
            r.setTrenutnaVrijednostJedinice(Math.round((Math.random() * 200)*100)/100.0); // Dvije decimale
        }
        brojSedmice++;

        //Update slekcije
        Roba t = listaRobe.getSelectionModel().getSelectedItem();
        listaRobe.getSelectionModel().clearSelection();
        listaRobe.getSelectionModel().select(t);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        brojSedmice = 1;
        df = new DecimalFormat("#.00"); // Za labele
        roba = new ArrayList<>();
        roba.add(new Roba (0,"Zlato",25,100,10,400));
        roba.add(new Roba (1,"Srebro",35,60,6,240));
        roba.add(new Roba (2,"Nafta",55,130,13,420));
        roba.get(0).getHistorija().add(roba.get(0).getTrenutnaVrijednostJedinice());
        roba.get(1).getHistorija().add(roba.get(1).getTrenutnaVrijednostJedinice());
        roba.get(2).getHistorija().add(roba.get(2).getTrenutnaVrijednostJedinice());

        //Ubacivanje u Listu
        ObservableList<Roba> listaZaPromatranje = FXCollections.observableArrayList(roba);
        listaRobe.setItems(listaZaPromatranje);
        listaRobe.getSelectionModel().selectedItemProperty().addListener((vrijednost,staraVrijednost,novaVrijednost) -> {
            if(novaVrijednost != null) {
                nazivRobeLabela.setText(novaVrijednost.getIme());
                trenutnaVrijednostLabela.setText(df.format(novaVrijednost.getTrenutnaVrijednostJedinice()) + "KM");
                kolicinaLabela.setText(novaVrijednost.getKolicina() + "");
                ukupnaVrijednostLabela.setText(df.format(novaVrijednost.getTrenutnaVrijednostJedinice() * novaVrijednost.getKolicina()) + "KM");
                prethodnaVrijednostLabela.setText(df.format(novaVrijednost.getHistorija().get(brojSedmice-1))+ "KM");

                // Postavka grafa
                berzaGraf.getData().clear();
                XYChart.Series<Number, Number> s = new XYChart.Series<>();
                s.setName(novaVrijednost.getIme());
                for(int i = 0; i < novaVrijednost.historija.size(); i++) {
                    s.getData().add(new XYChart.Data<>(i, novaVrijednost.historija.get(i)));
                    if(i == novaVrijednost.historija.size()-1 && i >= 15) {
                        xOsa.setLowerBound(i-14);
                        xOsa.setUpperBound(i+1);
                    }
                }
                s.getData().add(new XYChart.Data<>(s.getData().size(), novaVrijednost.getTrenutnaVrijednostJedinice()));
                berzaGraf.getData().add(s);
            }
        });
        listaRobe.getSelectionModel().selectFirst();

        // Ubacivanje u tabelu
        ObservableList<Roba> nova = FXCollections.observableArrayList(roba);
        stanjeTabela.setItems(nova);
        nazivRobeKolona.setCellValueFactory(new PropertyValueFactory<>("ime"));
        kolicinaKolona.setCellValueFactory(new PropertyValueFactory<>("kolicina"));
        trentnaVrijednostKolona.setCellValueFactory(new PropertyValueFactory<>("trenutnaVrijednostJedinice"));
        rastKolona.setCellValueFactory(data -> new SimpleStringProperty("0"));
        ukupnaVrijednostKolona.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTrenutnaVrijednostJedinice() * data.getValue().getKolicina() + ""));
    }
}

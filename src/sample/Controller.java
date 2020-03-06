package sample;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
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
    public javafx.scene.chart.BarChart<String, Number> barChart;
    public PieChart pieChart;
    public Label Sedmica;
    public Label Nivo;
    public Label maxNetoVrijednost;
    public Label minNetoVrijednost;
    public Label najdrazaRoba;
    public Label najveciProfit;
    private ArrayList<Roba> roba;
    private int brojSedmice;
    private DecimalFormat df;
    private Igrac igrac;

    public void novaSedmica() {
        for (Roba r : roba) {
            r.historija.add(r.getTrenutnaVrijednostJedinice());
            r.setTrenutnaVrijednostJedinice(Math.round((Math.random() * 200) * 100) / 100.0); // Dvije decimale
        }
        brojSedmice++;

        //Update slekcije
        Roba t = listaRobe.getSelectionModel().getSelectedItem();
        listaRobe.getSelectionModel().clearSelection();
        listaRobe.getSelectionModel().select(t);
        stanjeTabela.refresh();
        netoLabela.setText(df.format(igrac.getUkupnaVrijednost()) + "KM");
        int hefta = Integer.parseInt(Sedmica.getText());
        hefta++;
        Sedmica.setText(hefta + "");
        refreshGraphs();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        brojSedmice = 1;
        df = new DecimalFormat("#.00"); // Za labele
        roba = new ArrayList<>();
        igrac = new Igrac(10000);
        roba.add(new Roba(0, "Zlato", 0, 100, 10, 400));
        roba.add(new Roba(1, "Srebro", 0, 60, 6, 240));
        roba.add(new Roba(2, "Nafta", 0, 130, 13, 420));
        roba.add(new Roba(3, "Zeljezo", 0, 30, 3, 120));
        roba.add(new Roba(4, "Dijamanti", 0, 300, 30, 1200));
        roba.add(new Roba(5, "Politicki glasovi", 0, 10, 5, 25));


        //Ubacivanje u Listu
        ObservableList<Roba> listaZaPromatranje = FXCollections.observableArrayList(roba);
        listaRobe.setItems(listaZaPromatranje);
        listaRobe.getSelectionModel().selectedItemProperty().addListener((vrijednost, staraVrijednost, novaVrijednost) -> {
            if (novaVrijednost != null) {
                kolicinaLabela.textProperty().bind(novaVrijednost.kolicinaProperty().asString());
                nazivRobeLabela.textProperty().bind(novaVrijednost.imeProperty());
                trenutnaVrijednostLabela.textProperty().bind(novaVrijednost.trenutnaVrijednostJediniceProperty().asString().concat("KM"));
                //ukupnaVrijednostLabela.setText(df.format(novaVrijednost.getTrenutnaVrijednostJedinice() * novaVrijednost.getKolicina()) + "KM");
                prethodnaVrijednostLabela.setText(df.format(novaVrijednost.getHistorija().get(brojSedmice - 1)) + "KM");
                ukupnaVrijednostLabela.textProperty().bind(DoubleBinding.doubleExpression(novaVrijednost.kolicinaProperty().multiply(novaVrijednost.trenutnaVrijednostJediniceProperty())).asString().concat("KM"));

                // Postavka grafa
                berzaGraf.getData().clear();
                XYChart.Series<Number, Number> s = new XYChart.Series<>();
                s.setName(novaVrijednost.getIme());
                for (int i = 0; i < novaVrijednost.historija.size(); i++) {
                    s.getData().add(new XYChart.Data<>(i, novaVrijednost.historija.get(i)));
                    if (i == novaVrijednost.historija.size() - 1 && i >= 15) {
                        xOsa.setLowerBound(i - 14);
                        xOsa.setUpperBound(i + 1);
                    }
                }
                s.getData().add(new XYChart.Data<>(s.getData().size(), novaVrijednost.getTrenutnaVrijednostJedinice()));
                berzaGraf.getData().add(s);
            }
        });
        listaRobe.getSelectionModel().selectFirst();

        // Ubacivanje u tabelu
        igrac.setListaRobe(roba);
        stanjeTabela.setItems(FXCollections.observableArrayList(igrac.getListaRobe()));
        nazivRobeKolona.setCellValueFactory(new PropertyValueFactory<>("ime"));
        kolicinaKolona.setCellValueFactory(new PropertyValueFactory<>("kolicina"));
        trentnaVrijednostKolona.setCellValueFactory(new PropertyValueFactory<>("trenutnaVrijednostJedinice"));
        rastKolona.setCellValueFactory(data -> {
            Roba r = data.getValue();
            double t = r.getTrenutnaVrijednostJedinice();
            double s = r.getHistorija().get(r.getHistorija().size() - 1);
            return new SimpleStringProperty((Math.round((t - s) / s * 100) * 100) / 100.0 + "%");
        });
        ukupnaVrijednostKolona.setCellValueFactory(data -> new SimpleStringProperty((df.format(data.getValue().getTrenutnaVrijednostJedinice() * data.getValue().getKolicina()) + "")));

        //Binding igraca
        novacLabela.textProperty().bind(igrac.stanjeNovcaProperty().asString().concat("KM"));
        netoLabela.setText(igrac.getUkupnaVrijednost() + "KM");
        refreshGraphs();
    }

    public void refreshGraphs() {
        //Bar chart za max - tmp
        barChart.getData().clear();
        for (Roba r : roba) {
            XYChart.Series<String, Number> s = new XYChart.Series<>();
            s.setName(r.getIme());
            s.getData().add(new XYChart.Data<>(r.getIme(), Collections.max(r.getHistorija())));
            barChart.getData().add(s);
        }

        //Pie chart
        pieChart.getData().clear();
        for (Roba r : roba) {
            if (r.getKolicina() != 0) pieChart.getData().add(new PieChart.Data(r.getIme(), r.getKolicina()));
        }
    }

    public void Prodaj(ActionEvent actionEvent) {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("prodaj.fxml"));
            ProdajController prodajController = new ProdajController(listaRobe.getSelectionModel().getSelectedItem().getKolicina());
            loader.setController(prodajController);
            Parent root = loader.load();
            stage.setTitle("SASE");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();
            stage.setOnHiding(event -> {
                listaRobe.getSelectionModel().getSelectedItem().setKolicina(listaRobe.getSelectionModel().getSelectedItem().getKolicina() - prodajController.getKolicina());
                igrac.setStanjeNovca(igrac.getStanjeNovca() + listaRobe.getSelectionModel().getSelectedItem().getTrenutnaVrijednostJedinice() * prodajController.getKolicina());
                netoLabela.setText(df.format(igrac.getUkupnaVrijednost()) + "KM");
                stanjeTabela.refresh();
                refreshGraphs();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Kupi(ActionEvent actionEvent) {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("kupi.fxml"));
            KupiController kupiController = new KupiController((int) (igrac.getStanjeNovca() / listaRobe.getSelectionModel().getSelectedItem().getTrenutnaVrijednostJedinice()));
            loader.setController(kupiController);
            Parent root = loader.load();
            stage.setTitle("SASE");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();
            stage.setOnHiding(event -> {
                listaRobe.getSelectionModel().getSelectedItem().setKolicina(listaRobe.getSelectionModel().getSelectedItem().getKolicina() + kupiController.getKolicina());
                igrac.setStanjeNovca(igrac.getStanjeNovca() - listaRobe.getSelectionModel().getSelectedItem().getTrenutnaVrijednostJedinice() * kupiController.getKolicina());
                netoLabela.setText(df.format(igrac.getUkupnaVrijednost()) + "KM");
                stanjeTabela.refresh();
                refreshGraphs();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

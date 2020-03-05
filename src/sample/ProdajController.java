package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ProdajController implements Initializable {
    public Button prodajBtn;
    public Spinner<Integer> spinnerProdaj;

    private int max;
    private int kolicina;

    public ProdajController(int max) {
        this.max = max;
        kolicina = 0;
    }

    @SuppressWarnings("unused")
    public void odustani() {
        max = 0;
        ((Stage) prodajBtn.getScene().getWindow()).close();
    }

    @SuppressWarnings("unused")
    public void prodaj() {
        kolicina = spinnerProdaj.getValue();
        ((Stage) spinnerProdaj.getScene().getWindow()).close();
    }

    public int getKolicina() {
        return kolicina;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        spinnerProdaj.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, max, max / 2, 1));
    }
}

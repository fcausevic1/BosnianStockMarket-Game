package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class KupiController implements Initializable {
    public Spinner<Integer> spinnerKupi;
    public Button kupiBtn;
    private int max;
    private int kolicina;

    public KupiController(int max) {
        this.max = max;
        kolicina = 0;
    }

    @SuppressWarnings("unused")
    public void odustani() {
        max = 0;
        ((Stage) kupiBtn.getScene().getWindow()).close();
    }

    @SuppressWarnings("unused")
    public void kupi() {
        kolicina = spinnerKupi.getValue();
        ((Stage) spinnerKupi.getScene().getWindow()).close();
    }

    public int getKolicina() {
        return kolicina;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        spinnerKupi.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, max, max / 2, 1));
    }
}

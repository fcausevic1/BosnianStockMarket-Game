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
    public Button odustaniBtn;
    public Button kupiBtn;

    public void odustani() {
        ((Stage)kupiBtn.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}

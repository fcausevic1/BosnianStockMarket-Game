package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.stage.Stage;

public class ProdajController {
    public Button prodajBtn;
    public Spinner<Integer> spinnerProdaj;
    public Button odustaniBtn;

    public void odustani() {
        ((Stage)prodajBtn.getScene().getWindow()).close();
    }
}

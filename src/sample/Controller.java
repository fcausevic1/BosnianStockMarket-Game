package sample;

import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class Controller implements Initializable {
    public LineChart berzaGraf;
    public NumberAxis yOsa;
    public NumberAxis xOsa;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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

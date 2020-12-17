package Controller;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import sample.Client;

import java.io.IOException;

public class BarChartC {

    @FXML
    private BarChart<String,Number> barChart;

    @FXML
    private void initialize() throws IOException {
        Client stream = new Client();
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        BarChart<String,Number> bc =
                new BarChart<String,Number>(xAxis,yAxis);
        XYChart.Series series1 = new XYChart.Series();
        Integer count = stream.getInt();
        for (int i = 0;i<count;i++) {
            series1.getData().add(new XYChart.Data(stream.getString(), Double.parseDouble(stream.getString())));
        }
        barChart.getData().addAll(series1);

    }

}

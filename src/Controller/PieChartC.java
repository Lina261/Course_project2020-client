package Controller;

import Model.Country;
import Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ChoiceBox;
import sample.Client;

import java.io.IOException;

public class PieChartC {
    @FXML
    private PieChart pieChart;

    @FXML
    private void initialize() throws IOException {
        Client stream = new Client();
        stream.sendInt(17);
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList();
        Integer country_count = stream.getInt();
        for (int i = 0;i <country_count;i++) {
            pieChartData.add(new PieChart.Data(stream.getString(), stream.getInt()));
        }
        pieChart.setData(pieChartData);
    }

}

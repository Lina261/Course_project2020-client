package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PieChartD {
    public void main() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("pieChart.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("Диаграмма");
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
        stage.setOnCloseRequest(event -> {
            UserPage user = new UserPage();
            user.main();
        });
    }
}

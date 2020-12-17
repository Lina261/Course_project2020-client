package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CountryView {
    public void main() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("countryView.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("Страны-резиденции");
        stage.setScene(new Scene(root, 400, 400));
        stage.show();
        stage.setOnCloseRequest(event -> {
            AdminPage adminPage= new AdminPage();
            adminPage.main();
        });
    }
}

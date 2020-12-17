package View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminPage {
    public void main() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("adminPage.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("Страница администратора");
        stage.setScene(new Scene(root, 710, 450));
        stage.show();
        stage.setOnCloseRequest(event -> {
            Entrance entrance = new Entrance();
            entrance.entrance();
        });
    }


}

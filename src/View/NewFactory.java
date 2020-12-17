package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NewFactory {
    public void main() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("newFactory.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("Добавление предприятия");
        stage.setScene(new Scene(root, 600, 400));
        stage.showAndWait();
        stage.setOnCloseRequest(event -> {
            UserPage user = new UserPage();
            user.main();
        });
    }
}

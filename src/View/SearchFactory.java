package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SearchFactory {
    public void main() {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("findFactory.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Результаты поиска");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
            stage.setOnCloseRequest(event -> {
                UserPage user= new UserPage();
                user.main();
            });
        }
    }


package View;

import com.sun.glass.ui.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class UserPage {

        public void main() {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("userPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();

            Stage stage = new Stage();
            stage.setTitle("Страница пользователя");
            stage.setScene(new Scene(root, 900, 600));
            stage.show();
            stage.setOnCloseRequest(event -> {
                Entrance entrance = new Entrance();
                entrance.entrance();
            });
        }
    }



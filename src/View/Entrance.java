package View;

import Controller.EntranceC;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Entrance extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("entrance.fxml"));

        stage.setTitle("Вход");
        stage.setScene(new Scene(root, 400, 410));
        stage.show();
    }
    public void main() {
        Application.launch();
    }
    public void entrance() {


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("entrance.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();

        Stage stage = new Stage();
        stage.setTitle("Вход");
        stage.setScene(new Scene(root, 400, 410));
        stage.show();
    }

}

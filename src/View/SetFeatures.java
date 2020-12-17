package View;

import Controller.SetFeaturesC;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class SetFeatures {
    public void main(Integer idFactory) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("setFeatures.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();

        SetFeaturesC controller = loader.getController();
        controller.setData(idFactory);

        Stage stage = new Stage();
        stage.setTitle("Ввод финансовых показателей");
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
}}

package View;

import Controller.EditFactoryC;
import Model.Factory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EditFactory {
    public void main(Factory factory) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("editFactory.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        EditFactoryC controller = loader.getController();

        controller.setData(factory);

        Stage stage = new Stage();
        stage.setTitle("Редактирование предприятия");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();

        stage.setOnCloseRequest(event -> {
            UserPage user = new UserPage();
            user.main();
        });
    }
}

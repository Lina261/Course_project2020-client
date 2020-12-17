package View;

import Controller.EditUserC;
import Model.OtherUser;
import Model.User;
import Model.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EditUser {
    public void main(OtherUser user) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("editUser.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        EditUserC editUserC = loader.getController();

        editUserC.setData(user);

        Stage stage = new Stage();
        stage.setTitle("Редактирование пользователя");
        stage.setScene(new Scene(root, 600, 400));
        stage.showAndWait();
    }
}

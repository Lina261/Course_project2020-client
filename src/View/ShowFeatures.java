package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ShowFeatures {
    public void main() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("showFeatures.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        Parent root = loader.getRoot();

        Stage stage = new Stage();
        stage.setTitle("Финансовые показатели");
        stage.setScene(new Scene(root, 600, 400));
        stage.showAndWait();
    }
}

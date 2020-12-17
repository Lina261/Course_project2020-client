package Controller;

import Model.Country;
import Model.Factory;
import Model.Feature;
import Model.User;
import View.UserPage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Client;

import java.io.IOException;


public class SetFeaturesC {
    @FXML
    private TextField proceeds;

    @FXML
    private TextField assets;

    @FXML
    private Label errorM;
    @FXML
    private TextField equity;
    @FXML
    private TextField bacon;

    private Integer idFactory;
    @FXML
    private void initialize() throws IOException {

    }



    @FXML
    void saveFeatures(ActionEvent event) {
        if (proceeds.getLength() > 0 && assets.getLength() >0 && equity.getLength() > 0 && bacon.getLength() > 0
        && Double.parseDouble(proceeds.getText())>0  && Double.parseDouble(assets.getText())>0  && Double.parseDouble(equity.getText())>0  && Double.parseDouble(bacon.getText())>0) {
            Client stream = new Client();
            stream.sendInt(14);
            String proceed = proceeds.getText();
            String asset = assets.getText();
            String eq = equity.getText();
            String bac = bacon.getText();

            stream.sendInt(this.idFactory);
            stream.sendStr(proceed);
            stream.sendStr(asset);
            stream.sendStr(eq);
            stream.sendStr(bac);


            errorM.getScene().getWindow().hide();
            UserPage homePage = new UserPage();
            homePage.main();
        }
        else {
            errorM.setText("Заполните все поля корректно");
            errorM.setVisible(true);
        }

    }

    public void setData(Integer idFactory) {
        this.idFactory=idFactory;
    }
}

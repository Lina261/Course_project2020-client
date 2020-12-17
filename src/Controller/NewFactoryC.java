package Controller;
import Model.Country;
import Model.User;
import View.UserPage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.Client;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Client;

import java.io.IOException;

public class NewFactoryC {


    @FXML
    private ObservableList<Country> allcountry = FXCollections.observableArrayList();

    @FXML
    private TextField factoryName;
    @FXML
    private TextField factoryAddress;
    @FXML
    private Label errorM;
    @FXML
    private TextField directorSurname;
    @FXML
    private ChoiceBox<Country> country;

    @FXML
    private void initialize() throws IOException {
        Client stream = new Client();

        Integer countryCount = stream.getInt();
        for (int i = 0;i<countryCount;i++) {
            Integer idCountry = stream.getInt();
            String countryName = stream.getString();
            allcountry.add(new Country(idCountry, countryName));
        }
        country.setItems(allcountry);
        country.setValue(allcountry.get(0));
    }

    

    @FXML
    void newFactory(ActionEvent event) {
        if (factoryName.getLength() > 0 && factoryAddress.getLength() >0 && directorSurname.getLength() > 0 && !allcountry.isEmpty()) {
            Client stream = new Client();
            stream.sendInt(7);
            String name = factoryName.getText();
            String address = factoryAddress.getText();
            String director = directorSurname.getText();
            Country c = country.getSelectionModel().getSelectedItem();

            User user = new User();
            stream.sendStr(name);
            stream.sendStr(address);
            stream.sendStr(director);
            stream.sendInt(c.getIdCountry());
            stream.sendInt(user.getIdUser());

            errorM.getScene().getWindow().hide();
            UserPage homePage = new UserPage();
            homePage.main();
        }
        else {
            errorM.setText("Заполните все поля");
            errorM.setVisible(true);
        }

    }
}

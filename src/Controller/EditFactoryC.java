package Controller;

import Model.Country;
import Model.*;
import View.UserPage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.Client;

import java.io.IOException;

public class EditFactoryC {
    @FXML
    private ObservableList<Country> allcountry = FXCollections.observableArrayList();
    private Integer idFactory;
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
    public void setData(Factory factory) {
        System.out.println("setData");
        this.factoryName.setText(factory.getFactoryName());
        this.factoryAddress.setText(factory.getFactoryAddress());
        this.directorSurname.setText(factory.getDirectorSurname());
        this.factoryAddress.setText(factory.getFactoryAddress());
        this.country.getSelectionModel().getSelectedItem();


        this.idFactory = factory.getIdFactory();
    }

    @FXML
    private void initialize() throws IOException {
        System.out.println("Initialize");
        allcountry.clear();

        init_country();

        country.setItems(allcountry);

    }

    private void init_country() throws IOException {
        Client stream = new Client();

        stream.sendInt(10);
        Integer countryCount = stream.getInt();

        for (int i = 0;i<countryCount;i++) {
            Integer idCountry = stream.getInt();
            String countryName = stream.getString();
            allcountry.add(new Country(idCountry, countryName));
        }

    }


    public void editFactory(ActionEvent actionEvent) {
        if (factoryName.getLength() > 0 && factoryAddress.getLength() > 0
                && directorSurname.getLength() > 0
                && !allcountry.isEmpty()
        ) {
            Client stream = new Client();
            String factory = factoryName.getText();
            String address = factoryAddress.getText();
            String director = directorSurname.getText();


            stream.sendInt(12);

            stream.sendInt(this.idFactory);
            stream.sendStr(factory);
            stream.sendStr(address);
            stream.sendStr(director);
            stream.sendInt(country.getSelectionModel().getSelectedItem().getIdCountry());

            errorM.getScene().getWindow().hide();
            UserPage user = new UserPage();
            user.main();
            return;

        } else {
            errorM.setText("Заполните все поля");
            errorM.setVisible(true);
        }
    }
}


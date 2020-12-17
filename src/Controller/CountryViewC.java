package Controller;

import Model.Country;

import Model.Feature;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Client;

import java.io.IOException;

public class CountryViewC {
    private ObservableList<Country> countryData = FXCollections.observableArrayList();

    @FXML
    private TableView<Country> allcountry;

    @FXML
    private TableColumn<Country, Integer> idCountry;

    @FXML
    private TableColumn<Country, String> country;

    @FXML
    private void initialize() throws IOException {
        countryData.clear();
        initData();
        idCountry.setCellValueFactory(new PropertyValueFactory<Country, Integer>("idCountry"));
        country.setCellValueFactory(new PropertyValueFactory<Country, String>("country"));

        allcountry.setItems(countryData);
    }
    private void initData() throws IOException{
        Client stream = new Client();

        Integer countryCount = stream.getInt();

        for (int i = 0;i<countryCount;i++) {
            Integer idCountry = stream.getInt();
            String countryName = stream.getString();
            countryData.add(new Country(idCountry, countryName));

        }
    }
}

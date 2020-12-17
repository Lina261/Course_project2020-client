package Controller;

import Model.Factory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Client;

import java.io.IOException;

public class SearchFactoryC {
    private ObservableList<Factory> factoryData = FXCollections.observableArrayList();

    @FXML
    private TableView<Factory> factoryTable;

    @FXML
    private TableColumn<Factory, Integer> id;

    @FXML
    private TableColumn<Factory, String> factoryC;

    @FXML
    private TableColumn<Factory, String> addressC;

    @FXML
    private TableColumn<Factory, String> directorC;

    @FXML
    private TableColumn<Factory, String> countryC;
    @FXML
    private TableColumn<Factory, String> userC;

    @FXML
    private void initialize() throws IOException {
        factoryData.clear();
        get_result();

        id.setCellValueFactory(new PropertyValueFactory<Factory, Integer>("idFactory"));
        factoryC.setCellValueFactory(new PropertyValueFactory<Factory, String>("factoryName"));
        addressC.setCellValueFactory(new PropertyValueFactory<Factory, String>("factoryAddress"));
        directorC.setCellValueFactory(new PropertyValueFactory<Factory, String>("directorSurname"));
        countryC.setCellValueFactory(new PropertyValueFactory<Factory, String>("countryName"));
        userC.setCellValueFactory(new PropertyValueFactory<Factory, String>("login"));

        factoryTable.setItems(factoryData);
    }

    private void get_result() throws IOException {
        Client stream = new Client();

        Integer resCount = Integer.parseInt(stream.getString());
        for (int i = 0; i < resCount; i++) {
            Integer idfactory = stream.getInt();
            String fName = stream.getString();
            String addr = stream.getString();
            String dir = stream.getString();
            String country = stream.getString();
            String user = stream.getString();

            factoryData.add(new Factory(idfactory, fName, addr, dir,country,user));
        }
    }

}

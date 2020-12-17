package Controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import sample.Client;
import View.*;
import Model.Factory;
import Model.OtherUser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;

public class AdminPageC {

    private ObservableList<Factory> allfactories = FXCollections.observableArrayList();

    @FXML
    private TableView<Factory> factories;

    @FXML
    private TableColumn<Factory, Integer> idFactory;

    @FXML
    private TableColumn<Factory, String> factoryName;
    @FXML
    private TableColumn<Factory, String> factoryAddr;

    @FXML
    private TableColumn<Factory, String> country;
    @FXML
    private TableColumn<Factory, String> director;

    @FXML
    private TableColumn<Factory, String> userFactory;


    private ObservableList<OtherUser> usersData = FXCollections.observableArrayList();

    @FXML
    private TableView<OtherUser> users;

    @FXML
    private TableColumn<OtherUser, Integer> id;


    @FXML
    private TableColumn<OtherUser, String> name;

    @FXML
    private TableColumn<OtherUser, String> login;

    @FXML
    private TableColumn<OtherUser, String> password;

    @FXML
    private TableColumn<OtherUser, Integer> role;

    @FXML
    private Button delUserB;

    @FXML
    private void initialize() throws IOException {
        usersData.clear();
        initData();

        id.setCellValueFactory(new PropertyValueFactory<OtherUser, Integer>("idUser"));
        name.setCellValueFactory(new PropertyValueFactory<OtherUser, String>("name"));
        login.setCellValueFactory(new PropertyValueFactory<OtherUser, String>("login"));
        password.setCellValueFactory(new PropertyValueFactory<OtherUser, String>("password"));
        role.setCellValueFactory(new PropertyValueFactory<OtherUser, Integer>("role"));

        users.setItems(usersData);
    }
    private void initData() throws IOException {
        Client stream = new Client();
        stream.sendInt(3);
        Integer user_count = stream.getInt();

        for (int i = 0;i<user_count;i++) {
            Integer idUser = stream.getInt();
            String name = stream.getString();
            String login = stream.getString();
            String password = stream.getString();
            Integer role = stream.getInt();
            usersData.add(new OtherUser(idUser,name,login, password,role));
        }


    }

    public void allFactory(Event event) throws IOException {
            allfactories.clear();
            Client stream = new Client();
            stream.sendInt(6);

            Integer company_count = stream.getInt();

            for (int i = 0;i<company_count;i++) {
                Integer idFactory = stream.getInt();
                String factoryName = stream.getString();
                String factoryAddr = stream.getString();
                String director = stream.getString();
                String country = stream.getString();
                String login = stream.getString();
                allfactories.add(new Factory(idFactory, factoryName, director, login,country,factoryAddr));
            }

          idFactory.setCellValueFactory(new PropertyValueFactory<Factory, Integer>("idFactory"));
          factoryName.setCellValueFactory(new PropertyValueFactory<Factory, String>("factoryName"));
        factoryAddr.setCellValueFactory(new PropertyValueFactory<Factory, String>("factoryAddress"));
        director.setCellValueFactory(new PropertyValueFactory<Factory, String>("directorSurname"));
        country.setCellValueFactory(new PropertyValueFactory<Factory, String>("countryName"));
        userFactory.setCellValueFactory(new PropertyValueFactory<Factory, String>("login"));

            factories.setItems(allfactories);
        }



    public void allFeatures(ActionEvent actionEvent) {
        Client stream = new Client();
        Integer idFactory = factories.getSelectionModel().getSelectedItem().getIdFactory();
        stream.sendInt(8);
        stream.sendInt(idFactory);
        ShowFeatures showFeatures = new ShowFeatures();
        showFeatures.main();
    }

    public void editUser(ActionEvent actionEvent) throws IOException {
        EditUser editUser = new EditUser();
        editUser.main(users.getSelectionModel().getSelectedItem());

        this.initialize();
    }

    public void newUser(ActionEvent actionEvent) throws IOException {
        Registration registration = new Registration();
        registration.main();

        this.initialize();
    }

    public void delUser(ActionEvent actionEvent) {
        ObservableList<OtherUser> selected;
        selected = users.getSelectionModel().getSelectedItems();
        Integer userId = selected.get(0).getIdUser();
        Client stream = new Client();
        stream.sendInt(4);
        stream.sendInt(userId);

        selected.forEach(users.getItems()::remove);
    }
    public void Exit(ActionEvent actionEvent) {
        delUserB.getScene().getWindow().hide();
        Entrance entrance = new Entrance();
        entrance.entrance();
    }



    public void showCountry(ActionEvent actionEvent) {
        Client stream = new Client();

        stream.sendInt(15);
        factories.getScene().getWindow().hide();

        CountryView countryView = new CountryView();
        countryView.main();
    }

}

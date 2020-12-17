package Controller;
import Model.*;
import javafx.scene.chart.PieChart;
import sample.Client;
import View.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
public class UserPageC {
    @FXML
    private MenuBar menuBar;



    @FXML
    private ChoiceBox<Country> number_factory;

    @FXML
    private TableView<Factory> factoryTable;

    @FXML
    private TableColumn<Factory, Integer> idFactoryCol;

    @FXML
    private TableColumn<Factory, String> user;

    @FXML
    private TableColumn<Factory, String> factoryCol;

    @FXML
    private TableColumn<Factory, String> factoryAddressCol;

    @FXML
    private TableColumn<Factory, String> directorSurnameCol;
    @FXML
    private TableColumn<Factory, String> countryCol;



    @FXML
    private Button addnewFactory;
    @FXML
    private Button setFeatures;

    @FXML
    private Button del_company;

    @FXML
    private TextField findFactory;

    private ObservableList<Factory> factoryData = FXCollections.observableArrayList();

    private ObservableList<Country> countryData = FXCollections.observableArrayList();


    @FXML
    private void initialize() throws IOException {
        System.out.println("Вход");
        factoryData.clear();
        countryData.clear();

        initCountry();
        handler_choice();

        idFactoryCol.setCellValueFactory(new PropertyValueFactory<Factory, Integer>("idFactory"));
        factoryCol.setCellValueFactory(new PropertyValueFactory<Factory, String>("factoryName"));
        factoryAddressCol.setCellValueFactory(new PropertyValueFactory<Factory, String>("factoryAddress"));
        directorSurnameCol.setCellValueFactory(new PropertyValueFactory<Factory, String>("directorSurname"));
        countryCol.setCellValueFactory(new PropertyValueFactory<Factory, String>("countryName"));

        factoryTable.setItems(factoryData);
        number_factory.setItems(countryData);

    }
    private void initCountry() throws IOException{

        Client stream = new Client();

        stream.sendInt(10);

        Integer country_count = stream.getInt();
        //System.out.println("Country count - " + country_count);
        for (int i = 0;i<country_count;i++) {
            Integer idCountry = stream.getInt();
            String country = stream.getString();
            countryData.add(new Country(idCountry, country));
        }
       // System.out.println(countryData);
        if (country_count > 0) {
            number_factory.setValue(countryData.get(0));
            TableOfCountry();
        }

    }
    private void TableOfCountry() throws IOException {
        factoryData.clear();
        System.out.println(countryData);
        Integer idCountry = number_factory.getSelectionModel().getSelectedItem().getIdCountry();
        Client stream = new Client();

        stream.sendInt(9);
        stream.sendInt(idCountry);

        Integer factoryCount = stream.getInt();

        for (int i = 0;i<factoryCount; i++) {
            Integer idFactory = stream.getInt();
            String factoryName = stream.getString();
            String factoryAddress = stream.getString();
            String directorSurname = stream.getString();
            String country = stream.getString();
            String user = stream.getString();

            factoryData.add(new Factory(idFactory, factoryName, directorSurname, user,country,factoryAddress));
        }

    }
    private void handler_choice() {
        number_factory.setOnAction(event -> {
            try {
                if (!countryData.isEmpty()) {
                    TableOfCountry();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }



    public void setFeatures(ActionEvent actionEvent) throws IOException, SQLException {
       if (!factoryTable.getSelectionModel().isEmpty()) {
//            product_table.getScene().getWindow().hide();
           setFeatures.getScene().getWindow().hide();
           SetFeatures setFeatures = new SetFeatures();
           setFeatures.main(factoryTable.getSelectionModel().getSelectedItem().getIdFactory());


        }

    }

    public void addNewFactory(ActionEvent actionEvent) {
        Client stream = new Client();
        stream.sendInt(10);
        addnewFactory.getScene().getWindow().hide();
        NewFactory newFactory = new NewFactory();
        newFactory.main();
    }

    public void editFactory(ActionEvent actionEvent) {
        if (!factoryTable.getSelectionModel().isEmpty()) {
            factoryTable.getScene().getWindow().hide();

            EditFactory editProductForm = new EditFactory();
            editProductForm.main(factoryTable.getSelectionModel().getSelectedItem());
        }
    }

    public void delFactory(ActionEvent actionEvent) throws IOException {
        ObservableList<Factory> selected;
        selected = factoryTable.getSelectionModel().getSelectedItems();
        Integer factoryId = selected.get(0).getIdFactory();
        Client stream = new Client();
        stream.sendInt(11);
        stream.sendInt(factoryId);
        selected.forEach(factoryTable.getItems()::remove);
    }





    public void makeEfficiency(ActionEvent actionEvent) throws IOException {
        if (!factoryTable.getSelectionModel().isEmpty()) {
            Client stream = new Client();
            stream.sendInt(16);
            stream.sendInt(factoryTable.getSelectionModel().getSelectedItem().getIdFactory());

        }
    }

    public void findFactory(ActionEvent actionEvent) {
        Client stream = new Client();
        stream.sendInt(13);
        stream.sendStr(findFactory.getText());

        addnewFactory.getScene().getWindow().hide();
        SearchFactory search = new SearchFactory();
        search.main();
    }



    public void Logout(ActionEvent actionEvent) {
        menuBar.getScene().getWindow().hide();
        Entrance entrance = new Entrance();
        entrance.entrance();
    }

    public void showFeatures(ActionEvent actionEvent) {
        Client stream = new Client();
        Integer idFactory = factoryTable.getSelectionModel().getSelectedItem().getIdFactory();
        stream.sendInt(8);
        stream.sendInt(idFactory);
        ShowFeatures showFeatures = new ShowFeatures();
        showFeatures.main();
    }



    public void otchet(ActionEvent actionEvent) throws IOException {
        Client stream = new Client();
        Integer idFactory = factoryTable.getSelectionModel().getSelectedItem().getIdFactory();
        stream.sendInt(19);
        stream.sendInt(idFactory);
        FileWriter writer = new FileWriter("Result.txt");
        writer.write("FactoryName: " + stream.getString() + "\n");
        writer.write("directorSurname: " + stream.getString() + "\n");
        writer.write("factoryAddress: " + stream.getString() + "\n");
        writer.write("proceeds: " + stream.getString() + "\n");
        writer.write("assets: " + stream.getString() + "\n");
        writer.write("equity: " + stream.getString() + "\n");
        writer.write("bacon: " + stream.getString() + "\n");
        writer.write("result: " + stream.getString() + "\n");
        writer.close();
    }

    public void graphic(ActionEvent actionEvent) {
        if (!countryData.isEmpty()) {
//            factoryTable.getScene().getWindow().hide();
            Client stream = new Client();
            stream.sendInt(18);
            stream.sendInt(number_factory.getSelectionModel().getSelectedItem().getIdCountry());

            BarChart barChart = new BarChart();
            barChart.main();
        }
    }

    public void by_country(ActionEvent e) {
        if (!countryData.isEmpty()) {
            PieChartD pieChart = new PieChartD();
            pieChart.main();
        }
    }
}

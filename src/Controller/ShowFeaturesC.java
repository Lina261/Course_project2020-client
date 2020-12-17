package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import sample.Client;
import Model.Feature;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;


    public class ShowFeaturesC {


        private ObservableList<Feature> featureData = FXCollections.observableArrayList();

        @FXML
        private TableView<Feature> featuresTable;

        @FXML
        private TableColumn<Feature, Integer> idFeatureC;

        @FXML
        private TableColumn<Feature, String> factoryNameC;
        @FXML
        private TableColumn<Feature, Double> proceedsC;
        @FXML
        private TableColumn<Feature, Double> assetsC;
        @FXML
        private TableColumn<Feature, Double> equityC;
        @FXML
        private TableColumn<Feature, Double> baconC;


        @FXML
        private void initialize() throws IOException {
            featureData.clear();
            initData();
            idFeatureC.setCellValueFactory(new PropertyValueFactory<Feature, Integer>("idFeature"));
            factoryNameC.setCellValueFactory(new PropertyValueFactory<Feature, String>("factoryName"));
            proceedsC.setCellValueFactory(new PropertyValueFactory<Feature, Double>("proceeds"));
            assetsC.setCellValueFactory(new PropertyValueFactory<Feature, Double>("assets"));
            equityC.setCellValueFactory(new PropertyValueFactory<Feature, Double>("equity"));
            baconC.setCellValueFactory(new PropertyValueFactory<Feature, Double>("bacon"));

            featuresTable.setItems(featureData);
        }

        private void initData() throws IOException{
            Client stream = new Client();

            Integer featureCount = stream.getInt();

            for (int i = 0;i<featureCount;i++) {
                Integer idFeature = stream.getInt();
                String factoryName = stream.getString();
                Double proceeds =Double.parseDouble(stream.getString());
                Double assets = Double.parseDouble(stream.getString());
                Double equity = Double.parseDouble(stream.getString());
                Double bacon = Double.parseDouble(stream.getString());
                featureData.add(new Feature(idFeature, factoryName, proceeds, assets,equity,bacon));

            }
        }
    }


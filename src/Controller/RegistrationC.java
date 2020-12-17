package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.Client;
import View.Entrance;
import View.UserPage;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import java.io.IOException;

public class RegistrationC {


    @FXML
    private TextField name;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;


    @FXML
    private CheckBox role;



    @FXML
    private Label errorM;




    public void registration(ActionEvent actionEvent) throws IOException {
        if (  name.getLength() > 0 && login.getLength() > 0 && (password.getText().length() > 0) ) {


                Client stream = new Client();

                stream.sendInt(2);
                String name = this.name.getText();
                String login = this.login.getText();
                String password = this.password.getText();
                Integer role = (this.role.isSelected()) ? 1 : 0;

                stream.sendStr(name);
                stream.sendStr(login);
                stream.sendStr(password);
                stream.sendInt(role);

                errorM.getScene().getWindow().hide();

            } else {
                errorM.setVisible(true);

            }


    }}




//package Controller;
//
//import View.AdminPage;
//import View.Registration;
//import javafx.event.ActionEvent;
//import javafx.scene.control.Label;
//import sample.Client;
//
//import View.Entrance;
//import View.UserPage;
//import Model.User;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TextField;
//
//import java.awt.*;
//import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
//import java.io.IOException;
//
//public class EntranceC extends User{
//    @FXML
//    private TextField login;
//
//    @FXML
//    private TextField
//
//    @FXML
//    private PasswordField password;
//
//    @FXML
//    private Label errorM;
//
//    @FXML
//    private Button entranceB;
//
//    public EntranceC(Integer idUser, String name, String login, String password, Boolean role) {
//        super(idUser, name, login, password, role);
//    }
//
//    public void entrance(ActionEvent actionEvent) throws IOException {
//        Client stream = new Client();
//        stream.sendInt(1);
//
//        String login = this.login.getText();
//        String pass = this.password.getText();
//
//        stream.sendStr(login);
//        stream.sendStr(pass);
//
//        String res = "";
//
//        res = stream.getString();
//        if (res.equals("error")) {
//            this.errorM.setVisible(true);
//        }
//        if (res.equals("ok"))
//        {
//            idUser = stream.getInt();
//            name = stream.getString();
//            role = stream.getBoolean();
//            entranceB.getScene().getWindow().hide();
//            if (role) {
//                AdminPage adminPage = new AdminPage();
//                adminPage.main();
//            } else {
//                UserPage userPage = new UserPage();
//                userPage.main();
//            }
//
//        }
//
//    }
//
//    public void registration(ActionEvent actionEvent) {
//        Registration registration = new Registration();
//        registration.main();
//    }
//
//
//}
package Controller;

import Model.User;
import View.AdminPage;
import View.Registration;
import View.UserPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.Client;

import java.io.IOException;

public class EntranceC extends User {

    @FXML
    private TextField login;

    @FXML
    private Button entranceB;

    @FXML
    private Button registrationB;

    @FXML
    private Label errorM;

    @FXML
    private PasswordField password;


    @FXML
    void entrance(ActionEvent event) throws IOException {
        Client stream = new Client();
        stream.sendInt(1);

        String login = this.login.getText();
        String pass = this.password.getText();

        stream.sendStr(login);
        stream.sendStr(pass);

        String res = "";

        res = stream.getString();
        if (res.equals("error")) {
            this.errorM.setVisible(true);
        }
        if (res.equals("ok"))
        {
            idUser = stream.getInt();
            name = stream.getString();
            role = stream.getInt();
            entranceB.getScene().getWindow().hide();
            if (role == 1) {
                AdminPage adminPage = new AdminPage();
                adminPage.main();
            } else {
                UserPage userPage = new UserPage();
                userPage.main();
            }

        }
    }

    @FXML
    void registration(ActionEvent event) {
        Registration registration = new Registration();
        registration.main();
    }

}

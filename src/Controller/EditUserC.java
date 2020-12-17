package Controller;

import Model.OtherUser;
import sample.Client;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
public class EditUserC implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


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

    private int idUser;

    public void editUser(ActionEvent actionEvent) {
        if ( name.getLength() > 0 && login.getLength() > 0 && (password.getText().length() > 0) ) {


                Client stream = new Client();

                stream.sendInt(5);

                String name = this.name.getText();
                String login = this.login.getText();
                String password = this.password.getText();
                Integer role = this.role.isSelected() ? 1 : 0;


                stream.sendInt(idUser);

                stream.sendStr(name);
                stream.sendStr(login);
                stream.sendStr(password);
                stream.sendInt(role);


                errorM.getScene().getWindow().hide();



        } else {
            errorM.setText("Заполните все поля");
            errorM.setVisible(true);
        }
    }
    public void setData(OtherUser user) {
        this.name.setText(user.getName());
        this.login.setText(user.getLogin());
        this.password.setText(user.getPassword());
        this.role.setSelected(user.getRole()==1 ? true : false);
        this.idUser = user.getIdUser();
    }




}

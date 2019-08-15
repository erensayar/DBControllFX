package dbcontrollfx.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminGirisController {

    @FXML
    private TextField tf_userName;

    @FXML
    private PasswordField pf_password;

    @FXML
    private TextField tf_dbName;

    @FXML
    private TextField tf_port;

    @FXML
    private TextField tf_host;

    @FXML
    private Button bt_testConnetion;

    @FXML
    private Label label1;

    /*
    @FXML
    private CheckBox cb_remember;
    */
    
    public static String name;
    public static String password;
    public static String dbName;
    public static String port;
    public static String host;

    @FXML
    void connect(ActionEvent event) {
        name = tf_userName.getText();
        password = pf_password.getText();
        dbName = tf_dbName.getText();
        port = tf_port.getText();
        host = tf_host.getText();
        
        label1.setText("Connecting...");

        if (dbcontrollfx.Connection.DBConnect.tryConnect() == true) {
            label1.setText("DataBase Connection Successful");

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/dbcontrollfx/View/AnaPencere.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                //stage.initstyle(StagestyLe TRANSPARENT) 
                stage.setTitle("Ana Pencere");
                stage.setScene(new Scene(root1, 1046, 608));
                stage.show();
            } catch (Exception e) {
                label1.setText("Error!");
            }

        } else {
            label1.setText("DataBase Connection Failed! Try Again");
        }

    }
    
    /*
    @FXML
    void remember(ActionEvent event) {
        System.out.println(cb_remember.isSelected());

    }
    */

}

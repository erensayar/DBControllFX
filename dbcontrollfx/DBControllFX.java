
package dbcontrollfx;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DBControllFX extends Application {
    

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/dbcontrollfx/View/AdminGiris.fxml"));
        primaryStage.setTitle("MySql Login");
        primaryStage.setScene(new Scene(root, 279, 279));
        primaryStage.show();
    }
    


    public static void main(String[] args) {
        launch(args);
    }
}



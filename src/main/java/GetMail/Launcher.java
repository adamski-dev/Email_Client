package GetMail;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class Launcher extends Application {

    public static void main (String[] args){launch(args);}


    public void start(Stage stage) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));


        Scene scene = new Scene(parent, 550, 300);
        stage.setScene(scene);
        stage.show();
    }

}
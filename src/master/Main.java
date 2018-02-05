package master;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    static Parent root;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException{
        root = FXMLLoader.load(getClass().getResource("/master/Students_Profile.fxml"));
        primaryStage.setScene(new Scene(root,600,700));
        primaryStage.show();

    }
}

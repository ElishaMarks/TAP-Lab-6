package org.example.taplab6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CalendarApp extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Calendar");

        // Încarcăm fișierul FXML
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Calendar.fxml"));
        Parent root = fxmlLoader.load();

        // Obținem controlerul asociat
       // CalendarController controller = fxmlLoader.getController();

        // Creăm scena și o afișăm
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}



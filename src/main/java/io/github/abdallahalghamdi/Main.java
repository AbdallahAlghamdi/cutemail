package io.github.abdallahalghamdi;
import io.github.abdallahalghamdi.maillist.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;

public class Main extends Application {
    public static void main(String[] args) {
        System.setProperty("prism.lcdtext", "false");
        System.setProperty("prism.subpixeltext", "false");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Controller().getView(), 600,500, false, SceneAntialiasing.DISABLED);
//        scene.getStylesheets().add(Objects.requireNonNull(this.getClass().getResource("/css/main.css")).toExternalForm());
        URL CSS_PATH = this.getClass().getResource("/css/main.css");
        if(CSS_PATH!=null){
            System.out.println(CSS_PATH.getPath());
            scene.getStylesheets().add(CSS_PATH.toExternalForm());

        }
        else
            System.out.println("NOT FOUND CSS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
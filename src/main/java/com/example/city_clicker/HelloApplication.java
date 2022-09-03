package com.example.city_clicker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        HelloController h = new HelloController(stage);
        Scene s = h.getStartMenu();
        stage.getIcons().add(new Image("file:src/main/resources/com/example/city_clicker/city_clicker_logo.png"));
        stage.setScene(s);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
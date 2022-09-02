package com.example.city_clicker;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.ArrayList;

public class HelloController {
    private View v;
    private Stage s;
    private ArrayList<menuButton> startMenuButtons = new ArrayList<>();

    public HelloController(Stage s) {
        v = new View();
        this.s = s;
        beginApp();
    }

    private void beginApp() {
        startMenuButtons = v.getStartMenuButtons();
        menuButton start_game = startMenuButtons.get(0);
        start_game.setOnAction(new startMenuButtons.startGame(v.getGameScreen(),s,v.Get_SCREEN_WIDTH(),v.Get_SCREEN_HEIGHT()));
    }


    //returning the startmenu to be added to the stage in helloApplication
    public Scene getStartMenu() {
        Scene scene = new Scene(v.getStartMenu(),v.Get_SCREEN_WIDTH(),v.Get_SCREEN_HEIGHT());
        return scene;
    }


}
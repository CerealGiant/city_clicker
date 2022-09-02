package com.example.city_clicker;

import javafx.beans.binding.When;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class View {
    private final int SCREEN_WIDTH = 720;
    private final int SCREEN_HEIGHT = 680;
    private final String GAMESCREEN_IMGPATH = "src/main/resources/com/example/city_clicker/city_clicker.png";
    private final String STARTSCREEN_IMGPATH = "src/main/resources/com/example/city_clicker/startMenu_background.jpg";
    private final String LOGO_IMGPATH = "src/main/resources/com/example/city_clicker/city_clicker_logo.png";
    private AnchorPane gameScreen = null;
    private AnchorPane startMenu = null;
    private ArrayList<menuButton> startMenuButtons = new ArrayList<>();

    public View() {
        gameScreen = new AnchorPane();
        startMenu = new AnchorPane();
        loadStartMenu();
        loadGameScreen();
    }

    //loading the startmenu
    private void loadStartMenu() {

        //Setting background of the start screen
        setBackground(STARTSCREEN_IMGPATH,startMenu);


        //Adding logo to the start screen
        ImageView logo = createImage(LOGO_IMGPATH);
        logo.setLayoutY(20);
        logo.setLayoutX(140);
        startMenu.getChildren().add(logo);


        //Adding the 2 menu buttons to the start screen
        menuButton start_game = new menuButton("Start");
        menuButton continue_game = new menuButton("Continue");


        start_game.setLayoutX(260);
        start_game.setLayoutY(270);

        continue_game.setLayoutX(260);
        continue_game.setLayoutY(340);

        startMenu.getChildren().addAll(start_game,continue_game);

        startMenuButtons.add(start_game);
        startMenuButtons.add(continue_game);

    }


    //loading the gamescreen
    private void loadGameScreen() {
        //Setting the background of the game screen
        setBackground(GAMESCREEN_IMGPATH,gameScreen);

        //Adding blank property cards
        factoryCard fc = new factoryCard(gameScreen);

        ImageView p2 = createImage("src/main/resources/com/example/city_clicker/wall.jpg");
        p2.setLayoutX(190);
        p2.setLayoutY(230);
        gameScreen.getChildren().add(p2);

        ImageView p3 = createImage("src/main/resources/com/example/city_clicker/wall.jpg");
        p3.setLayoutX(190);
        p3.setLayoutY(340);
        gameScreen.getChildren().add(p3);

        ImageView p4 = createImage("src/main/resources/com/example/city_clicker/wall.jpg");
        p4.setLayoutX(190);
        p4.setLayoutY(450);
        gameScreen.getChildren().add(p4);


        ImageView p5 = createImage("src/main/resources/com/example/city_clicker/wall.jpg");
        p5.setLayoutX(190);
        p5.setLayoutY(560);
        gameScreen.getChildren().add(p5);

    }


    //function that sets background of any given pane
    private void setBackground(String IMAGE_PATH, Pane PaneToSetTo) {
        Image i = null;
        try {
            i = new Image(new FileInputStream(IMAGE_PATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BackgroundImage b = new BackgroundImage(i, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        Background background = new Background(b);
        PaneToSetTo.setBackground(background);
    }

    private ImageView createImage(String IMAGE_PATH) {
        Image i = null;
        try {
            i = new Image(new FileInputStream(IMAGE_PATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView v = new ImageView(i);
        return v;
    }


    //Returning the gameScreen
    public AnchorPane getGameScreen() {return gameScreen;}

    //Returning the startMenu
    public AnchorPane getStartMenu() {return startMenu;}

    //returning height and width of the screen set in view
    public int Get_SCREEN_WIDTH() {return SCREEN_WIDTH;}
    public int Get_SCREEN_HEIGHT() {return SCREEN_HEIGHT;}

    //returning the startMenu buttons
    public ArrayList<menuButton> getStartMenuButtons() {return startMenuButtons;}

}

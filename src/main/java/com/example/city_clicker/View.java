package com.example.city_clicker;

import javafx.beans.binding.When;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class View {
    private final int SCREEN_WIDTH = 720;
    private final int SCREEN_HEIGHT = 620;
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


        //Adding button to generate money upon click
        Button clicker = new Button();
        String PATH = "-fx-background-color: transparent; \n" +
                "-fx-background-image: url('file:src/main/resources/com/example/city_clicker/img.png')";
        clicker.setStyle(PATH);
        //menuButton clicker = new menuButton("$$");
        clicker.setPrefHeight(200);
        clicker.setPrefWidth(200);
        clicker.setLayoutX(10);
        clicker.setLayoutY(150);
        gameScreen.getChildren().add(clicker);

        //Save button on top right hand corner
        Button save = new Button();
        String save_PATH = "-fx-background-color: transparent; \n" +
                "-fx-background-image: url('file:src/main/resources/com/example/city_clicker/save.png')";
        save.setPrefWidth(64);
        save.setPrefHeight(70);
        save.setStyle(save_PATH);
        save.setLayoutX(580);
        save.setLayoutY(-1);
        gameScreen.getChildren().add(save);

        //Settings button on top right hand corner
        Button settings = new Button();
        String settings_PATH = "-fx-background-color: transparent; \n" +
                "-fx-background-image: url('file:src/main/resources/com/example/city_clicker/settings.png')";
        settings.setPrefWidth(64);
        settings.setPrefHeight(67);
        settings.setStyle(settings_PATH);
        settings.setLayoutX(650);
        settings.setLayoutY(8);
        gameScreen.getChildren().add(settings);

        //Display some stats below the clicker display

        // $ generated per second
        Text persec = new Text("$0"+" \n\ngenerated per \n\nsecond");
        persec.setWrappingWidth(200);
        setFont(persec);
        persec.setLayoutX(10);
        persec.setLayoutY(400);
        gameScreen.getChildren().add(persec);
        persec.setFill(Color.web("#00FF99"));

        // Upkeep value
        Text upkeep = new Text("$0" + " \n\ndue in \n\n0 sec(upkeep)");
        upkeep.setWrappingWidth(200);
        setFont(upkeep);
        upkeep.setLayoutX(10);
        upkeep.setLayoutY(490);
        upkeep.setFill(Color.web("#FF3300"));
        gameScreen.getChildren().add(upkeep);

        //Button to refund last 3 transactions(bottom left)
        Button refund = new Button("Refund purchase");
        setFont(refund);
        refund.setStyle("-fx-background-color: #FF0000;");
        refund.setLayoutX(2);
        refund.setLayoutY(590);
        refund.setPrefWidth(224);
        gameScreen.getChildren().add(refund);

        //Adding property cards(in the middle section)
        factoryCard fc = new factoryCard(gameScreen);
        bankCard bc = new bankCard(gameScreen);
        businessParkCard bpc = new businessParkCard(gameScreen);
        casinoCard cc = new casinoCard(gameScreen);
        officeCard oc = new officeCard(gameScreen);


        //Adding the upgrade buttons below each property card
        Button upgrade_factory = new Button("Upgrade Factory");
        upgrade_factory.setPrefWidth(228);
        setFont(upgrade_factory);
        upgrade_factory.setStyle("-fx-background-color: #CCFF00;");
        upgrade_factory.setLayoutX(245);
        upgrade_factory.setLayoutY(190);//+70 from image
        gameScreen.getChildren().add(upgrade_factory);

        Button upgrade_bank = new Button("Upgrade Bank");
        upgrade_bank.setPrefWidth(228);
        setFont(upgrade_bank);
        upgrade_bank.setStyle("-fx-background-color: #CCFF00;");
        upgrade_bank.setLayoutX(245);
        upgrade_bank.setLayoutY(290);//+70 from image
        gameScreen.getChildren().add(upgrade_bank);

        Button upgrade_bpark = new Button("Upgrade Bsns Park");
        upgrade_bpark.setPrefWidth(228);
        setFont(upgrade_bpark);
        upgrade_bpark.setStyle("-fx-background-color: #CCFF00;");
        upgrade_bpark.setLayoutX(245);
        upgrade_bpark.setLayoutY(390);//+70 from image
        gameScreen.getChildren().add(upgrade_bpark);

        Button upgrade_casino = new Button("Upgrade Casino");
        upgrade_casino.setPrefWidth(228);
        setFont(upgrade_casino);
        upgrade_casino.setStyle("-fx-background-color: #CCFF00;");
        upgrade_casino.setLayoutX(245);
        upgrade_casino.setLayoutY(490);//+70 from image
        gameScreen.getChildren().add(upgrade_casino);

        Button upgrade_office = new Button("Upgrade Office");
        upgrade_office.setPrefWidth(228);
        setFont(upgrade_office);
        upgrade_office.setStyle("-fx-background-color: #CCFF00;");
        upgrade_office.setLayoutX(245);
        upgrade_office.setLayoutY(590);//+70 from image
        gameScreen.getChildren().add(upgrade_office);


        //Adding upgrade cards(on the right hand side)
        incomeTaxCard it = new incomeTaxCard(gameScreen);
        corporateTaxBreakCard cbreak = new corporateTaxBreakCard(gameScreen);
        savingsPlanCard spc = new savingsPlanCard(gameScreen);
        stimulusCard sc = new stimulusCard(gameScreen);


        //Adding the upgrade buttons below each upgrade card
        Button upgrade_itax = new Button("Upgrade Income Tax");
        upgrade_itax.setPrefWidth(226);
        setFont(upgrade_itax);
        upgrade_itax.setStyle("-fx-background-color: #CCFF00;");
        upgrade_itax.setLayoutX(492);
        upgrade_itax.setLayoutY(200);//+80 from image
        gameScreen.getChildren().add(upgrade_itax);

        Button upgrade_corporate = new Button("Upgrade C Tax Break");
        upgrade_corporate.setPrefWidth(226);
        setFont(upgrade_corporate);
        upgrade_corporate.setStyle("-fx-background-color: #CCFF00;");
        upgrade_corporate.setLayoutX(492);
        upgrade_corporate.setLayoutY(310);//+80 from image
        gameScreen.getChildren().add(upgrade_corporate);

        Button upgrade_savings = new Button("Upgrade Savings");
        upgrade_savings.setPrefWidth(226);
        setFont(upgrade_savings);
        upgrade_savings.setStyle("-fx-background-color: #CCFF00;");
        upgrade_savings.setLayoutX(492);
        upgrade_savings.setLayoutY(420);//+80 from image
        gameScreen.getChildren().add(upgrade_savings);

        Button upgrade_stimulus = new Button("Upgrade Stimulus");
        upgrade_stimulus.setPrefWidth(226);
        setFont(upgrade_stimulus);
        upgrade_stimulus.setStyle("-fx-background-color: #CCFF00;");
        upgrade_stimulus.setLayoutX(492);
        upgrade_stimulus.setLayoutY(530);//+80 from image
        gameScreen.getChildren().add(upgrade_stimulus);



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

    private void setFont(Text t) {

        String FONT_PATH = "src/main/resources/com/example/city_clicker/game_font.ttf";

        try {
            t.setFont(Font.loadFont(new FileInputStream(FONT_PATH),12));
        } catch (FileNotFoundException e) {
            t.setFont(Font.loadFont("Verdana",25));
        }
    }
    private void setFont(Button b) {

        String FONT_PATH = "src/main/resources/com/example/city_clicker/game_font.ttf";

        try {
            b.setFont(Font.loadFont(new FileInputStream(FONT_PATH),10));
        } catch (FileNotFoundException e) {
            b.setFont(Font.loadFont("Verdana",25));
        }
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

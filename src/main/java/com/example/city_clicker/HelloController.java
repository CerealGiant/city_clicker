package com.example.city_clicker;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class HelloController {
    private View v;
    private Stage s;
    private Model m;
    private ArrayList<menuButton> startMenuButtons = new ArrayList<>();
    private ArrayList<propertyCard> buildings = new ArrayList<>();
    private ArrayList<upgradeButton> upgradePropertyButtons = new ArrayList<>();
    private Button clicker = null;
    private Timer counter;

    public HelloController(Stage s) {
        v = new View();
        m = new Model();
        counter = new Timer();
        this.s = s;
        startGame();
        buildings = v.getBuildings();
        clicker = v.getClicker();
        upgradePropertyButtons = v.getUpgradePropertyButtons();

        //Stopping the timer when the game is over
        s.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                counter.cancel();
            }
        });
    }

    //Updation when the treasury(clicker) is clicked
    private void treasuryClick() {
        clicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //When button is clicked, we update the model side and view side
                m.updateMoney(1);
                v.setMoneyDisplayedText(m.returnMoney());
            }
        });
    }

    //Before game is launched, we need to set up some other things.
    private void gameInit() {
        //If building has not been purchased, set the gameText to "Buy ...."
        if(!factory.getInstance().returnPurchased()) {
            //Factory has not been purchased
            upgradePropertyButtons.get(0).setText("Buy Factory");
        }
        treasuryClick();
    }


    //When game is started
    private void startGame() {
        startMenuButtons = v.getStartMenuButtons();
        menuButton start_game = startMenuButtons.get(0);
        start_game.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //When the start button is clicked
                Scene dest = new Scene(v.getGameScreen(),v.Get_SCREEN_WIDTH(),v.Get_SCREEN_HEIGHT());
                gameInit(); //We will set the properties to purchased/unpurchased
                s.setScene(dest);
                gameLoop();
            }
        });
    }


    //Runs when the game is running.
    private void gameLoop() {
        //Initalise a timer
        counter.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //Update the money (model side + view side)
                m.updateMoney(1);
                v.setMoneyDisplayedText(m.returnMoney());
                purchaseProduct();
            }
        },0,1000);
    }

    //This function handles anything to do with user purchasing any product
    private void purchaseProduct() {
        //Setting for factory first
        upgradePropertyButtons.get(0).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //Update the model side + view side
                if(m.purchase(factory.getInstance())) {
                    //Purchase was successful, update view side

                    //1. change the money
                    v.setMoneyDisplayedText(m.returnMoney());

                    //2. change the text and image
                    upgradePropertyButtons.get(0).setText("Upgrade Factory");


                    //3. update imageview and level text
                    buildings.get(0).changeImage("purchased");


                }else {
                    System.out.println("Insufficient funds");
                }
            }
        });
    }




    //returning the startmenu to be added to the stage in helloApplication
    public Scene getStartMenu() {
        Scene scene = new Scene(v.getStartMenu(),v.Get_SCREEN_WIDTH(),v.Get_SCREEN_HEIGHT());
        return scene;
    }










}
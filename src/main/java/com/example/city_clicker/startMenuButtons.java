package com.example.city_clicker;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.lang.reflect.AccessibleObject;

public class startMenuButtons {

    public static class startGame implements ICommand, EventHandler<ActionEvent> {

        private Pane destPane;
        private Stage s;
        private int SCREEN_WIDTH;
        private int SCREEN_HEIGHT;
        private Model m;

        public startGame(Pane dest,Stage s,int sw,int sh,Model m) {
            destPane = dest;
            this.s = s;
            this.m = m;
            SCREEN_WIDTH = sw;
            SCREEN_HEIGHT = sh;
        }

        @Override
        public void execute() {
            Scene dest = new Scene(destPane,SCREEN_WIDTH,SCREEN_HEIGHT);
            s.setScene(dest);

            //Start the game's timer
            //m.initGame();

            //Update the view's value at the same time


        }


        @Override
        public void handle(ActionEvent actionEvent) {
            execute();
        }
    }

    public static class continueGame implements ICommand, EventHandler<ActionEvent> {

        @Override
        public void execute() {

        }

        @Override
        public void handle(ActionEvent actionEvent) {
            execute();
        }
    }
}

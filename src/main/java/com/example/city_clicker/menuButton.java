package com.example.city_clicker;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class menuButton extends Button {
    private String FONT_PATH = "src/main/resources/com/example/city_clicker/uiButtonFont.ttf";
    private String BUTTON_PRESSED_PATH = "-fx-background-color: transparent; \n" +
            "-fx-background-image: url('file:src/main/resources/com/example/city_clicker/red_button_pressed.png')";
    private String BUTTON_RELEASED_PATH = "-fx-background-color: transparent; \n"+
            "-fx-background-image: url('file:src/main/resources/com/example/city_clicker/red_button.png')";

    public menuButton(String text) {
        setFont();
        setText(text);
        setPrefWidth(190);
        setPrefHeight(49);
        buttonReleasedStyle();
        initaliseListeners();
    }

    private void setFont() {
        try {
            setFont(Font.loadFont(new FileInputStream(FONT_PATH),18));
        } catch (FileNotFoundException e) {
            setFont(Font.font("Verdana",23));
        }
    }

    //pressed button is 4 pixels lower than the release button image
    private void buttonPressedStyle() {
        setWrapText(true);
        setStyle(BUTTON_PRESSED_PATH);
        setHeight(45);
        setLayoutY(getLayoutY() + 4);
    }

    private void buttonReleasedStyle() {
        setWrapText(true);
        setStyle(BUTTON_RELEASED_PATH);
        setHeight(49);
        setLayoutY(getLayoutY() - 4);
    }

    private void initaliseListeners() {

        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setEffect(new DropShadow());
            }
        });

        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setEffect(null);
            }
        });

        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)) buttonPressedStyle();
            }
        });

        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                buttonReleasedStyle();
            }
        });
    }
}

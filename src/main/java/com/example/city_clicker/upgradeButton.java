package com.example.city_clicker;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class upgradeButton extends Button {

    private Pane paneToPlaceOn;
    private building b;
    private final int XPOS;
    private final int YPOS;
    private final int WIDTH = 228;
    private String type;

    upgradeButton(int x,int y,Pane p,String type) {
        XPOS = x;
        YPOS = y;
        this.type = type;
        setDesign();
        setButtonText();
        p.getChildren().add(this);
    }

    private void setDesign() {
        setFont();
        setPrefWidth(WIDTH);
        setLayoutY(YPOS);
        setLayoutX(XPOS);
        setStyle("-fx-background-color: #CCFF00;");
    }

    private void setButtonText() {
        setText("Upgrade Factory");
    }

    //setting font
    private void setFont() {

        String FONT_PATH = "src/main/resources/com/example/city_clicker/game_font.ttf";
        try {
            setFont(Font.loadFont(new FileInputStream(FONT_PATH),10));
        } catch (FileNotFoundException e) {
            setFont(Font.loadFont("Verdana",25));
        }
    }



}

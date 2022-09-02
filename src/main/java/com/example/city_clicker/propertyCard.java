package com.example.city_clicker;

//propertyCard will refer to the mini windows containing each type of building in the properties tab of the game
//propertyCard will have a few main features:
//1. It will display an image of the current building based on the building object
//2. It will display the current level of the property(this will be gotten from the building object)(as a text below)
//3. It will contain the upgrade and purchase buttons as well

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class propertyCard {

    public ImageView createImage(String IMAGE_PATH) {
        Image i = null;
        try {
            i = new Image(new FileInputStream(IMAGE_PATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView v = new ImageView(i);
        return v;
    }

    public void addImageToScreen(ImageView v, int xpos, int ypos,AnchorPane gameScreen) {
        v.setLayoutX(xpos);
        v.setLayoutY(ypos);
        gameScreen.getChildren().add(v);
    }

}

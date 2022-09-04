package com.example.city_clicker;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class stimulusCard extends propertyCard{
    private final String CARD_PATH = "src/main/resources/com/example/city_clicker/economic_stimulus.png";

    public stimulusCard(AnchorPane gameScreen) {
        //In the constructor, we will load up the default card
        ImageView card = createImage(CARD_PATH);
        addImageToScreen(card,490,450,gameScreen);
    }

    @Override
    public void changeImage(String type) {

    }
}

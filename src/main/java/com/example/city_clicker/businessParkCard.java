package com.example.city_clicker;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class businessParkCard extends propertyCard{
    private final String CARD_PATH = "src/main/resources/com/example/city_clicker/businessParkCard.png";

    public businessParkCard(AnchorPane gameScreen) {
        //In the constructor, we will load up the default card
        ImageView card = createImage(CARD_PATH);
        addImageToScreen(card,245,320,gameScreen); //+100 from previous image
        Text bp_txt = new Text("BPark Lvl ");
        setFont(bp_txt);
        addTextToScreen(bp_txt,320,360,gameScreen); //+40 from image
    }

    @Override
    public void changeImage(String type) {

    }
}

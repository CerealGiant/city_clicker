package com.example.city_clicker;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class casinoCard extends propertyCard{
    private final String CARD_PATH = "src/main/resources/com/example/city_clicker/casinoCard.png";

    public casinoCard(AnchorPane gameScreen) {
        //In the constructor, we will load up the default card
        ImageView card = createImage(CARD_PATH);
        addImageToScreen(card,245,420,gameScreen); //+100 from previous image
        Text casino_txt = new Text("Casino Lvl ");
        setFont(casino_txt);
        addTextToScreen(casino_txt,320,460,gameScreen); //+40 from image
    }
}

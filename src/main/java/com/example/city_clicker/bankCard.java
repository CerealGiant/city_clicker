package com.example.city_clicker;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class bankCard extends propertyCard{
    private final String CARD_PATH = "src/main/resources/com/example/city_clicker/bankCard.png";

    public bankCard(AnchorPane gameScreen) {
        //In the constructor, we will load up the default card
        ImageView card = createImage(CARD_PATH);
        addImageToScreen(card,245,220,gameScreen); //+100 from previous image
        Text bank_txt = new Text("Bank Lvl ");
        setFont(bank_txt);
        addTextToScreen(bank_txt,320,260,gameScreen); //+40 from image
    }
}

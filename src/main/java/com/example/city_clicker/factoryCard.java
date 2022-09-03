package com.example.city_clicker;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;



//Singleton class
public class factoryCard extends propertyCard{
    private final String CARD_PATH = "src/main/resources/com/example/city_clicker/factoryCard.png";

    public factoryCard(AnchorPane gameScreen) {
        //In the constructor, we will load up the default card
        ImageView card = createImage(CARD_PATH);
        addImageToScreen(card,245,120,gameScreen);
        Text fctry_txt = new Text("Factory Lvl ");
        setFont(fctry_txt);
        addTextToScreen(fctry_txt,320,160,gameScreen);
    }




}

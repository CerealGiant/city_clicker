package com.example.city_clicker;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class officeCard extends propertyCard{
    private final String CARD_PATH = "src/main/resources/com/example/city_clicker/officeCard.png";

    public officeCard(AnchorPane gameScreen) {
        //In the constructor, we will load up the default card
        ImageView card = createImage(CARD_PATH);
        addImageToScreen(card,245,520,gameScreen); //+100 from previous image
        Text office_txt = new Text("Office Lvl ");
        setFont(office_txt);
        addTextToScreen(office_txt,320,560,gameScreen); //+40 from image
    }

    @Override
    public void changeImage(String type) {

    }
}

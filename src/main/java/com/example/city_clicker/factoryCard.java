package com.example.city_clicker;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;



//Singleton class
public class factoryCard extends propertyCard{
    private String CARD_PATH = "src/main/resources/com/example/city_clicker/factoryCard.png";
    private factory f;
    private ImageView card = null;
    private int factory_lvl = 1;
    private Text fctry_txt = new Text("");


    public factoryCard(AnchorPane gameScreen) {
        f = factory.getInstance();
        if(!f.returnPurchased()) {
            CARD_PATH = "src/main/resources/com/example/city_clicker/unpurchased_factory.jpg";
        }
        //In the constructor, we will load up the default card
        card = createImage(CARD_PATH);
        addImageToScreen(card,245,120,gameScreen);
        if(!f.returnPurchased()) fctry_txt = new Text("Factory Lvl");
        else fctry_txt = new Text("Factory Lvl "+factory_lvl);
        setFont(fctry_txt);
        addTextToScreen(fctry_txt,320,160,gameScreen);
    }

    public void changeImage(String type) {
        if(type.equals("purchased")) {
            updateImage(card,"src/main/resources/com/example/city_clicker/factoryCard.png");
            fctry_txt.setText("Factory Lvl "+factory_lvl);
        }
    }

    public void updateLevel(int lvl) {
        factory_lvl = lvl;
        fctry_txt.setText("Factory Lvl "+factory_lvl);
    }

}

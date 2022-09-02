package com.example.city_clicker;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


//Singleton class
public class factoryCard extends propertyCard{
    private final String WALL_PATH = "src/main/resources/com/example/city_clicker/wall.jpg";

    public factoryCard(AnchorPane gameScreen) {
        //In the constructor, we will load up the wall path and set its position
        ImageView wall = createImage(WALL_PATH);
        addImageToScreen(wall,190,120,gameScreen);
    }


}

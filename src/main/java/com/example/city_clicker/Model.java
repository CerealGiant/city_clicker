package com.example.city_clicker;

import java.util.Timer;
import java.util.TimerTask;

public class Model {
    private factory f = null;
    private int money;

    public Model() {
        f = factory.getInstance();
        money = 0;
    }


    public boolean purchase(building b) {
        //Whenever user clicks on buy for anything
        if(money >= b.returnPurchaseCost()) {
            //Tell user he cannot buy
            money-=b.returnPurchaseCost();
            b.setPurchased(true);
            return true;
        }
        return false;
    }




    public void updateMoney(int value) {
        money+=value;
    }

    public int returnMoney() {
        return money;
    }




}

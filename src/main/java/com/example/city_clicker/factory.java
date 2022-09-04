package com.example.city_clicker;

public class factory extends building{

    private static factory instance = null;


    //Private constructor
    private factory() {
        super();
        incomePerSecond = 1;
        purchaseCost = 10;
        upgradeCost = (int)(purchaseCost*1.2);
    }

    //Static method to get the instance of factory.
    public static factory getInstance() {
        if (instance == null)
            instance = new factory();
        return instance;
    }


}

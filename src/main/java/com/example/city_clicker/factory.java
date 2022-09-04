package com.example.city_clicker;

public class factory extends building{

    private static boolean purchased;
    private static int upgradeCost; //shows cost for the next level
    private final int purchaseCost = 10;
    private static int level = 1;
    private static int incomePerSecond;
    private static factory instance = null;


    //Private constructor
    private factory() {
        super();
        incomePerSecond = 1;
        upgradeCost = (int)(purchaseCost*1.2);
    }

    //Static method to get the instance of factory.
    public static factory getInstance() {
        if (instance == null)
            instance = new factory();
        return instance;
    }


}

package com.example.city_clicker;

abstract public class building {
    protected static boolean purchased;
    protected static int upgradeCost; //shows cost for the next level
    protected int purchaseCost = 0;
    protected static int level = 1;
    protected static int incomePerSecond;


    public building() {
        purchased = false;
    }

    protected static int calculateUpgradeCost(boolean up) {
        //upgradecost = upgradecost*1.2 -> for the next level
        //upgradecost = upgradcost*0.8
        if(up) {
            return (int) (upgradeCost * 1.2);
        }
        //If level is decreasing
        return (int) (upgradeCost/1.2);
    }

    public static void levelDown() {
        level--;
        upgradeCost = calculateUpgradeCost(false);
        incomePerSecond = level;
    }

    public static void levelUp() {
        level++;
        upgradeCost = calculateUpgradeCost(true); //display upgrade cost for next level
        incomePerSecond = level;
    }
    public int returnCurrentLevel() {
        return level;
    }

    public static int returnUpgradeCost() {
        return upgradeCost;
    }

    public static int returnIncome() {
        return incomePerSecond;
    }

    public static boolean returnPurchased() {
        return purchased;
    }

    public static void setPurchased(boolean p) {
        purchased = p;
    }

    public abstract void upgradeBuilding();

}
